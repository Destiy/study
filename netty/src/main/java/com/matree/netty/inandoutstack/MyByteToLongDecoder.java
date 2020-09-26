package com.matree.netty.inandoutstack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 对数据进行解码
 *
 * @author wy
 * @data 2020-09-26 15:38
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /**
     * @param ctx 上下文
     * @param in  入栈的byteBuf
     * @param out list 集合，将解码后的数据给下一个handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("---Decoder MyByteToLongDecoder");
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
