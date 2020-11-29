package com.lc.spi.protocol;

import com.alibaba.dubbo.common.URL;

public class DubboProtocol implements Protocol {
    @Override
    public void export(URL url) {
        System.out.println("dubbo export service...");
    }

    @Override
    public void refer() {
        System.out.println("dubbo refer service...");
    }
}
