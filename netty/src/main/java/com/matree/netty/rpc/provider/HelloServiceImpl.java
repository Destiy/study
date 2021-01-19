package com.matree.netty.rpc.provider;

import com.matree.netty.rpc.publicinterface.HelloService;

public class HelloServiceImpl implements HelloService {

    /**
     * 当有消费方调用该方法时，就放回一个结果
     * @param msg   message
     * @return  string
     */
    @Override
    public String hello(String msg) {
        System.out.println("收到client message: " + msg);
        if (msg == null) {
            return "hello client, receive your message";
        }
        return "hello client, receive your message = " + msg;
    }
}
