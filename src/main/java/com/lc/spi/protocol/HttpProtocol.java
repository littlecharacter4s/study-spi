package com.lc.spi.protocol;

import com.alibaba.dubbo.common.URL;

public class HttpProtocol implements Protocol {
    @Override
    public void export(URL url) {
        System.out.println("http export service...");
    }

    @Override
    public void refer() {
        System.out.println("http refer service...");
    }
}
