package com.example.reacternettydemo.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.CharsetUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.*;

public class ReactorClientDemo1 {
    public static void main(String[] args) throws InterruptedException {
        TcpClient tcpClient =
                TcpClient.create()
                        .host("localhost")
                        .port(9999)
                        .handle((inbound, outbound) -> {
                            inbound.receive()
                                    .subscribe(data -> {
                                        System.out.println("Server Received: " + data.toString(CharsetUtil.UTF_8));
                                    });


                            return outbound.sendString(Flux.just("hello", "world", "123123"));

                        })
                        .doOnDisconnected((s) -> {
                            System.out.println("sssss");
                        });
        tcpClient.connectNow().onDispose()
                .block();

    }

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), Executors.defaultThreadFactory());
}
