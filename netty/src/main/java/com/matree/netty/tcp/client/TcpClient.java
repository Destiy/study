package com.matree.netty.tcp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wy
 * @data 2020-09-26 15:45
 */
public class TcpClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new TcpClientInitializer());
            ChannelFuture ch = bootstrap.connect("localhost", 7000).sync();
            ch.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
