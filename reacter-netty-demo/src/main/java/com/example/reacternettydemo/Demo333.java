package com.example.reacternettydemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;


public class Demo333 {
    public static void main(String[] args) throws InterruptedException {
    EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (2)
           b.group(workerGroup)
                    .channel(NioSocketChannel.class) // (3)
                    .handler(new ChannelInboundHandlerAdapter(){
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

                            ByteBuf byteBuf = (ByteBuf) msg;
                            System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
                            byteBuf.release();
                        }


                    })
                    .option(ChannelOption.SO_BACKLOG, 128) ; // (6)

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.connect("localhost",8080).sync(); // (7)

            threadPoolExecutor.execute(() -> {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNext()){
                    f.channel().writeAndFlush(Unpooled.wrappedBuffer(scanner.next().getBytes(StandardCharsets.UTF_8)));
                }
            });
            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),Executors.defaultThreadFactory());
}
