package advanced.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

public class NIOServer {

    private static ArrayList<SocketChannel> channels = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);   // Non-blocking mode
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        System.out.println("Successful startup");
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept(); // Get new TCP connection Channel
            // TCP Request/Reader/Response
            if (socketChannel != null) {
                System.out.println("Received new connection: " + socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);     // Default block mode,it must be set to Non-blocking
                channels.add(socketChannel);
            } else {
                Iterator<SocketChannel> iterator = channels.iterator();
                while (iterator.hasNext()) {
                    SocketChannel next = iterator.next();
                    try {
                        ByteBuffer request = ByteBuffer.allocate(1024);
                        if (next.read(request) == 0) {  // 如果没有数据了，则不继续后面处理
                            continue;
                        }
                        while (next.isOpen() && next.read(request) != -1) {
                            // 长连接情况下，需要手动判断数据有没有读取结束
                            if (request.position() > 0) {
                                break;
                            }
                        }

                        request.flip();
                        byte[] content = new byte[request.limit()];
                        request.get(content);
                        System.out.println(new String(content));
                        System.out.println("Received date, : " + next.getRemoteAddress());

                        String response = "HTTP/1.1 200 OK\r\n" +
                                "Content-Length: 11\r\n\r\n" +
                                "Hello World";
                        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
                        while (buffer.hasRemaining()) {
                            next.write(buffer);
                        }
                        next.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
