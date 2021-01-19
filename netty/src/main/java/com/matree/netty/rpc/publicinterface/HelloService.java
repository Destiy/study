package com.matree.netty.rpc.publicinterface;

/**
 * 这个是接口，是服务提供方提供 和服务消费方都需要
 * @author wy
 */
public interface HelloService {

    String hello(String msg);
}
