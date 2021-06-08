package com.example.reacternettydemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8890);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(socketAddress);

        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();

        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    writeBuffer.clear();
                    writeBuffer.put(next.getBytes());
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;


            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    try {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        buffer.clear();
                        channel.read(buffer);
                        buffer.flip();
                        System.out.println("received : " + new String(buffer.array()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else if (key.isWritable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    writeBuffer.flip();
                    channel.write(writeBuffer);
                    key.interestOps(SelectionKey.OP_READ);
                }
                iterator.remove();
            }

        }



    }
}
