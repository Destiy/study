package com.matree.netty.protocltcp;

import lombok.Data;

@Data
public class MessageProtocol {

    private int len;

    private byte[] content;
}
