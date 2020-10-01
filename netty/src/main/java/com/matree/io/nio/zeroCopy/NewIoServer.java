package com.matree.io.nio.zeroCopy;

import java.io.IOException;
import java.lang.invoke.SerializedLambda;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 零拷贝 服务端
 * @author wy
 * @data 2020-08-11 0:27
 */
public class NewIoServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7001);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 获取serverSocket
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(inetSocketAddress);

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            int readCount = 0;
            while ( -1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                } catch (IOException e) {
                    break;
                }
                // 倒带 position = 0 , mark 作废
                byteBuffer.rewind();
            }
        }

    }
}
