package com.lc.spi.registry;

import com.alibaba.dubbo.common.URL;
import com.lc.spi.protocol.Protocol;

/**
 * dubbo ioc
 */
public class IocRegistry implements Registry {
    private Protocol protocol;

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public void register(URL url) {
        protocol.export(url);
    }
}
