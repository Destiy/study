package com.matree.netty.rpc.customer;

import com.matree.netty.rpc.netty.NettyClient;
import com.matree.netty.rpc.publicinterface.HelloService;

public class ClientBootstrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient customer = new NettyClient();
        HelloService helloService = (HelloService) customer.getBean(HelloService.class, providerName);

        String hello = helloService.hello("hello dubbo");
        System.out.println("call result = " + hello);
    }
}
