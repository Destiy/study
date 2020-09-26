package com.matree.netty.inandoutstack.server;

import com.matree.netty.inandoutstack.MyByteToLongDecoder;
import com.matree.netty.inandoutstack.MyLongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 入栈、出栈 handler独立工作 互不影响
 *
 * @author wy
 * @data 2020-09-26 15:37
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 入栈的handler 进行解码 MyByteToLongDecoder
        pipeline.addLast(new MyByteToLongDecoder());

        // 出栈的handler 进行编码
        pipeline.addLast(new MyLongToByteEncoder());

        // 自定义handler 处理业务逻辑
        pipeline.addLast(new MyServerHandler());
    }
}
