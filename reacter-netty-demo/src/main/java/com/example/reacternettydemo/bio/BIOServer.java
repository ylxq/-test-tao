package com.example.reacternettydemo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress socketAddress = new InetSocketAddress(9980);
        serverSocket.bind(socketAddress);

        while (true) {
            Socket accept = serverSocket.accept();

            new Thread(() -> {
                InputStream inputStream = null;
                try {
                    inputStream = accept.getInputStream();
                    byte[] bytes = new byte[1024];
                    int read = 0;
                    while ((read = inputStream.read(bytes)) >= 0){
                        String s = new String(bytes, 0, read);
                        System.out.println(s);
                        accept.getOutputStream().write("你所说的很对!!!!!!!".getBytes(StandardCharsets.UTF_8));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }).start();
        }


    }
}
