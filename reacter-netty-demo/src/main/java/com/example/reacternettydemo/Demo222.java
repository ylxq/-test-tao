package com.example.reacternettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Demo222 {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Channel> channelList = new HashMap<>();

        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new ChannelDuplexHandler() {

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
                                    String name = inetSocketAddress.getHostName() + inetSocketAddress.getPort();
                                    channelList.put(name, ctx.channel());
                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                    channelList.values().remove(ctx.channel());
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    System.out.println(cause);
                                    String value ="用户已退出";
                                    channelList.entrySet().stream()
                                            .filter(entry -> !entry.getValue().equals(ctx.channel()))
                                            .forEach(entry -> {
                                                String val = entry.getKey() + "：" + value;
                                                entry.getValue().writeAndFlush(Unpooled.wrappedBuffer(val.getBytes(StandardCharsets.UTF_8)));
                                            });
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    ByteBuf byteBuf = (ByteBuf) msg;
                                    String value = byteBuf.toString(StandardCharsets.UTF_8);
                                    channelList.entrySet().stream()
                                            .filter(entry -> !entry.getValue().equals(ctx.channel()))
                                            .forEach(entry -> {
                                                String val = entry.getKey() + "：" + value;
                                                entry.getValue().writeAndFlush(Unpooled.wrappedBuffer(val.getBytes(StandardCharsets.UTF_8)));
                                            });
                                    byteBuf.release();
                                }


                            });
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(8080).sync(); // (7)

            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}
