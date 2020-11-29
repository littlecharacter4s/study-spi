package com.lc.spi.protocol;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Protocol {
    @Adaptive(value = "protocolType")
    void export(URL url);
    void refer();
}
