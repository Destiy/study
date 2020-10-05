package com.matree.netty.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable<Object>
{

    private ChannelHandlerContext context;
    private String result;
    private String param;

    /**
     * (1)
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 其他方法会使用到ctx
        System.out.println("channelActive");
        context = ctx;
    }

    /**
     * (4)
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead");
        result = msg.toString();
        // 唤醒等待线程
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * (3)(5)
     */
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1");
        context.writeAndFlush(param);
        // 等待服务端 返回数据
        wait();
        System.out.println("call2");
        return result;
    }

    /**
     * (2)
     */
    public void setParam(String param) {
        System.out.println("setParam");
        this.param = param;
    }
}
