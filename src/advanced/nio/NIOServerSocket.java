package advanced.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NIOServerSocket {
    /** 处理业务操作的线程 */
    private static ExecutorService workPool = Executors.newCachedThreadPool();

    abstract class ReactorThread extends Thread{
        Selector selector;
        LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();

        /**
         * selector 监听到有事件后，调用这个方法
         *
         * @param channel
         * @throws Exception
         */
        public abstract void handler(SelectableChannel channel) throws Exception;

        private ReactorThread() throws IOException {
            selector = Selector.open();
        }

        volatile boolean running = false;

        @Override
        public void run() {
            try {
                while (running) {
                    Runnable task;
                    while ((task = taskQueue.poll()) != null) {
                        task.run();
                    }
                    selector.select(1000);

                    Set<SelectionKey> selected = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selected.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        int readyOps = key.readyOps();
                        // sub Read and Accept
                        if ((readyOps & (SelectionKey.OP_READ | SelectionKey.OP_ACCEPT)) != 0 || readyOps == 0) {
                            try {
                                SelectableChannel channel = (SelectableChannel) key.attachment();
                                channel.configureBlocking(false);
                                handler(channel);
                                if (!channel.isOpen()) {
                                    key.cancel();   // if shut down, unsubscribe key
                                }
                            } catch (Exception e) {
                                key.cancel(); // if exception, unsubscribe key
                            }

                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private void doStart() {
            if (!running) {
                running = true;
                start();
            }
        }

        private SelectionKey register(SelectableChannel channel) throws ExecutionException, InterruptedException {
            // 为什么register要以任务提交的形式，让reactor线程去处理？
            // 因为线程在执行channel注册到selector的过程中，会和调用selector.select()方法的线程争用同一把锁
            // 而select()方法实在eventLoop中通过while循环调用的，争抢的可能性很高，为了让register能更快的执行，就放到同一个线程来处理
            FutureTask<SelectionKey> futureTask = new FutureTask<>(() -> channel.register(selector, 0, channel));
            taskQueue.add(futureTask);
            return futureTask.get();
        }
    }


    private ServerSocketChannel serverSocketChannel;

    // accept
    private ReactorThread[] mainReactorThreads = new ReactorThread[1];
    // I/O
    private ReactorThread[] subReactorThreads = new ReactorThread[8];

    /**
     * 初始化线程组
     *
     * @throws IOException
     */
    private void newGroup() throws IOException{
        // 创建IO 线程
        for (int i = 0; i < subReactorThreads.length; i++) {
            subReactorThreads[i] = new ReactorThread() {
                @Override
                public void handler(SelectableChannel channel) throws Exception {
                    // work 线程只负责处理IO 处理，不处理accept 事件
                    SocketChannel channel1 = (SocketChannel) channel;
                    ByteBuffer requestBuffer = ByteBuffer.allocate(1024);
                    while (channel.isOpen() && channel1.read(requestBuffer) != -1) {
                        // 长连接情况下，需要手动判断数据有没有读取结束
                        if (requestBuffer.position() > 0) break;
                    }
                    if (requestBuffer.position() == 0) return;

                    requestBuffer.flip();
                    byte[] content = new byte[requestBuffer.limit()];
                    requestBuffer.get(content);
                    System.out.println(new String(content));
                    System.out.println(Thread.currentThread().getName() + " Received Date, From: " + channel1.getRemoteAddress());

                    // TODO 业务操作、数据库、接口..
                    workPool.submit(() -> {
                    });
                    String response = "HTTP/1.1 200 OK\r\n" +
                            "Content-Length: 11\r\n\r\n" +
                            "Hello World";
                    ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
                    while (buffer.hasRemaining()) {
                        channel1.write(buffer);
                    }
                }
            };
        }

        // 创建accept 线程
        for (int i = 0; i < mainReactorThreads.length; i++) {
            mainReactorThreads[i] = new ReactorThread() {
                AtomicInteger integer = new AtomicInteger(0);

                @Override
                public void handler(SelectableChannel channel) throws Exception {
                    // 只做请求分发，不做具体的数据读取
                    ServerSocketChannel channel1 = (ServerSocketChannel) channel;
                    SocketChannel socketChannel = channel1.accept();
                    socketChannel.configureBlocking(false);
                    // 收到连接建立的通知后，分发给I/O 线程继续去读取数据
                    int index = integer.getAndIncrement() % subReactorThreads.length;
                    ReactorThread workEventLoop = subReactorThreads[index];
                    workEventLoop.doStart();
                    SelectionKey selectionKey = workEventLoop.register(socketChannel);
                    selectionKey.interestOps(SelectionKey.OP_READ);
                    System.out.println(Thread.currentThread().getName() + " Received Date, From: " + socketChannel.getRemoteAddress());
                }
            };
        }
    }

    private void initAndRegister() throws IOException, ExecutionException, InterruptedException {
        // 1. 创建 serverSocketChannel
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        // 2. 将serverSocketChannel 注册到selector
        int index = new Random().nextInt(mainReactorThreads.length);
        mainReactorThreads[index].doStart();
        SelectionKey selectionKey = mainReactorThreads[index].register(serverSocketChannel);
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
    }

    private void bind() throws IOException {
        serverSocketChannel.bind(new InetSocketAddress(8080));
        System.out.println("Successful Starting, PORT: '8080'");
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        NIOServerSocket nioServerSocket = new NIOServerSocket();
        nioServerSocket.newGroup();
        nioServerSocket.initAndRegister();
        nioServerSocket.bind();
    }


}
