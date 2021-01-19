package com.matree.netty.rpc.provider;

import com.matree.netty.rpc.netty.NettyServer;

/**
 * ServerBootstrap 会启动一个服务提供者，就是NettyServer
 */
public class ServerBootstrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
