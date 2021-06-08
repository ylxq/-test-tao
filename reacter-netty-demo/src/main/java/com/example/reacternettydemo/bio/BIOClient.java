package com.example.reacternettydemo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BIOClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9980);

        OutputStream outputStream = socket.getOutputStream();
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    outputStream.write(next.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int read = 0;
                while ((read = inputStream.read(bytes)) >= 0) {
                    String s = new String(bytes, 0, read);
                    System.out.println("server:" + s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
