package com.matree.io.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Stream;

/**
 * Scattering: 将数据写入Buffer 时，可以采用buffer 数组，依次写入（分散）
 * Gathering： 从buffer 读取数据时，可以采用buffer 数据，依次读
 *
 * @author wy
 * @date 2020-08-07 16:43
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {

//        serverSocketChannel 和 SocketChannel

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到server 并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[]     byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);


        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;

        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead = " + byteRead);
                // 输出Buffer 的limit 和 position
                Arrays.stream(byteBuffers).map(buffer -> "position = " + buffer.position() +
                        ", limit = " + buffer.limit()).forEach(System.out::println);
            }
            Arrays.stream(byteBuffers).forEach(Buffer::flip);

            // 讲数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long write = socketChannel.write(byteBuffers);
                byteWrite += write;
            }

            Arrays.stream(byteBuffers).forEach(Buffer::clear);

            System.out.println("byteRead = " + byteRead + " byteWrite = " + byteWrite + "messageLength = " + messageLength);
        }
    }
}
