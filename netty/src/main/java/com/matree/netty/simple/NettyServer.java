package com.matree.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wy
 * @date 2020-08-28 14:41
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {


        // 创建bossGroup 和workGroup
        // bossGroup : 处理连接请求, 真正的和客户端业务处理，交给workGroup 完成
        // 都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        // 创建服务端的启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            bootstrap.group(bossGroup, workGroup) // 设置两个线程组
                    .channel(NioServerSocketChannel.class)  // 使用NioServerSocketChannel 的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)  /* 线程队列等待个数*/
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  // 设置保持会话连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 创建一个通道测试对象
                        // 给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); // 给workGroup 的eventLoop 对应的管道设置管道处理器

            System.out.println("server is ready ...");

            // 绑定一个端口并同步，生成一个channelFuture 对象
            ChannelFuture cf = bootstrap.bind(6668).sync();

            // 对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}