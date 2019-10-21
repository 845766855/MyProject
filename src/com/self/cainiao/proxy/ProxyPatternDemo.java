package com.self.cainiao.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test01.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}
