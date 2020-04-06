package advanced.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("tomcat 服务启动成功");
        while(!serverSocket.isClosed()) {
            Socket request = serverSocket.accept();
            System.out.println("received a new socket : " + request.toString());
            threadPool.execute(()->{
                try {
                    InputStream inputStream = request.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    String msg;
                    while((msg = reader.readLine()) != null){
                        if (msg.length() <= 0){
                            break;
                        }
                        System.out.println(msg);
                    }
                    System.out.println("收到数据，来自:" + request.toString());
                    OutputStream outputStream = request.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-length: 11\r\n\r\n".getBytes());
                    outputStream.write("Hello World".getBytes());
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
