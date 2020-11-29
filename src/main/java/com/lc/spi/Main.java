package com.lc.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.lc.spi.driver.Driver;
import com.lc.spi.protocol.Protocol;
import com.lc.spi.registry.Registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Java Spi：");
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()) {
            Driver driver = iterator.next();
            driver.drive();
        }
        System.out.println("Dubbo Spi：");
        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol dubboProtocol = extensionLoader.getExtension("dubbo");
        dubboProtocol.export(null);
        dubboProtocol.refer();
        Protocol httpProtocol = extensionLoader.getExtension("http");
        httpProtocol.export(null);
        httpProtocol.refer();
        System.out.println("----------AOP-----IOC----------");
        ExtensionLoader<Registry> registryExtensionLoader = ExtensionLoader.getExtensionLoader(Registry.class);
        Registry registry = registryExtensionLoader.getExtension("ioc");
        Map<String, String> param = new HashMap<>();
        param.put("protocolType", "http");
        URL url = new URL("", "", 0, param);
        registry.register(url);
    }
}
