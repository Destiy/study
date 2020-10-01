package com.matree.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.nio.charset.Charset;

/**
 * SimpleChannelInboundHandler是 SimpleChannelInboundHandler的子类
 * HttpObject 表示客户端 <-> 服务器相互通信的数据封装成HttpObject
 *
 * @author wy
 * @date 2020-09-08 17:26
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户端数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 判断 msg 是不是 httpRequest请求
        if (msg instanceof HttpRequest) {

            System.out.println("pipeline hashCode = " + ctx.pipeline().hashCode() +
                    " TestHttpServerHandler hash = " + this.hashCode());
            System.out.println("msg 类型 = " + msg.getClass());
            System.out.println("客户端地址 = " + ctx.channel().remoteAddress());

            HttpRequest httpRequest = (HttpRequest) msg;
            URI  uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了favicon.ico, 不做处理");
                return;
            }
            // 回复信息给浏览器 [http协议]
            ByteBuf content = Unpooled.copiedBuffer("he llo 我是服务器", CharsetUtil.UTF_16);
            // 构造一个http响应，即HttpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    content);
            response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}