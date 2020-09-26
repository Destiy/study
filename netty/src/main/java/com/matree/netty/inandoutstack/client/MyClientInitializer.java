package com.matree.netty.inandoutstack.client;

import com.matree.netty.inandoutstack.MyByteToLongDecoder;
import com.matree.netty.inandoutstack.MyLongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wy
 * @data 2020-09-26 16:19
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 入栈handler 对数据进行解码
        pipeline.addLast(new MyByteToLongDecoder());
        // 加入出栈handler 对数据进行编码
        pipeline.addLast(new MyLongToByteEncoder());
        // 加入自定义handler 处理业务逻辑
        pipeline.addLast(new MyClientHandler());
    }
}
