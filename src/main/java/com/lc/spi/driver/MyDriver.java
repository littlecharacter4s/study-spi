package com.lc.spi.driver;

public class MyDriver implements Driver {

    @Override
    public void drive() {
        System.out.println("mydriver drive...");
    }
}
