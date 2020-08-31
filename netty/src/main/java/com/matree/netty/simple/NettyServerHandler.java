package com.matree.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义一个handler 需要继承netty 规定好的某个handlerAdapter
 *
 * @author wy
 * @date 2020-08-28 15:51
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取数据 （可以读取客户端发送的数据）
     *
     * @param ctx 上下文对象，含有 管道pipeline 通道channel 地址
     * @param msg 客户端发送的消息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("server ctx = " + ctx);

        // 转成byteBuf
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送的数据是：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    /**
     * 数据读取完毕
     *
     * @param ctx 上下文对象
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // write + flush
        // 一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端.", CharsetUtil.UTF_8));
    }

    /**
     * 发生异常
     * 一般是需要关闭通道
     *
     * @param ctx   上下文
     * @param cause 抛出异常
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
