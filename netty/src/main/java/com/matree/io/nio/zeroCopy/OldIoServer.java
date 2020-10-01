package com.matree.io.nio.zeroCopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java io 服务端
 * @author wy
 * @data 2020-08-10 23:48
 */
public class OldIoServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7000);

        while(true) {
            Socket accept = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

            try {
                byte[] bytes = new byte[4096];
                while(true) {
                    int read = dataInputStream.read(bytes, 0, bytes.length);
                    if (-1 == read) { break; }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
