package com.lc.spi.registry;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Registry {
    void register(URL url);
}
