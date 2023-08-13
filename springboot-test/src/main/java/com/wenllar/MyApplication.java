package com.wenllar;

import org.springboot.WenllarSpringApplication;
import org.springboot.annotation.WenllarSpringbootApplication;

@WenllarSpringbootApplication
public class MyApplication {

    public static void main(String[] args) throws Exception {
        WenllarSpringApplication.run(MyApplication.class);
    }
}
