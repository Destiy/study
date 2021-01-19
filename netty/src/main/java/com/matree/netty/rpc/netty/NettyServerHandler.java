package com.matree.netty.rpc.netty;

import com.matree.netty.rpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 1. 获取客户端发送的消息，并调用服务
        System.out.println("msg = " + msg);
        // 2. 客户端在调用服务器的api 时，我们需要定义一个协议
        // 比如我们要求 每次发送消息都必须以某个字符串开头，"HelloService#hello"
        String message = msg.toString();
        if (message.startsWith("HelloService")) {
            String result = new HelloServiceImpl().hello(message.substring(message.indexOf("#") + 1));
            ctx.writeAndFlush(result);
        }

        ctx.writeAndFlush("尼玛");
    }

    /**
     * 表示channel 处于活动状态
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " online");
    }

    /**
     * 断开连接
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " leave");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
