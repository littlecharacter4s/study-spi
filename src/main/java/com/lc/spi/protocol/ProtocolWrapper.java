package com.lc.spi.protocol;

import com.alibaba.dubbo.common.URL;

/**
 * dubbo aop
 */
public class ProtocolWrapper implements Protocol {
    private Protocol protocol;

    public ProtocolWrapper(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public void export(URL url) {
        System.out.println("before...");
        protocol.export(url);
        System.out.println("after...");
    }

    @Override
    public void refer() {
        System.out.println("before...");
        protocol.refer();
        System.out.println("after...");
    }
}
