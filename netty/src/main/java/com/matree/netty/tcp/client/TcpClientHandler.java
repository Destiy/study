package com.matree.netty.tcp.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author wy
 * @data 2020-09-28 0:04
 */
public class TcpClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] byteBuf = new byte[msg.readableBytes()];
        msg.readBytes(byteBuf);

        String request = new String(byteBuf, CharsetUtil.UTF_8);
        System.out.println("client receive data: " + request);
        System.out.println("client receive data count: " + ++count);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // use client send 10 number data 'hello,server'
        for (int i = 0; i < 10; i++) {
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,sever " + i, CharsetUtil.UTF_8);
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
