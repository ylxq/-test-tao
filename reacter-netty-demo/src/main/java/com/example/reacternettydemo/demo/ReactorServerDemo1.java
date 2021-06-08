package com.example.reacternettydemo.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
import reactor.util.Logger;


import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class ReactorServerDemo1 {


    public static void main(String[] args) throws InterruptedException {

        TcpServer.create()
                .handle((in, out) -> {
                    in.receive()
                            .take(1)
                            .log(ReactorServerDemo1.class.getName())
                            .subscribe(data -> System.out.println("Server Received: "+data.toString(CharsetUtil.UTF_8)));

                    return out.sendString(Mono.just("Hi")).neverComplete();
                })
                .host("localhost")
                .port(9999)
                .bindNow().channel()
                .closeFuture().sync();
    }
}
