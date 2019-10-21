package com.self.prototype;

public class PrototypeTest {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getSgape("1");
        System.out.println("Shape:" + cloneShape.getType());

        Shape cloneShape1 = ShapeCache.getSgape("2");
        System.out.println("Shape:" + cloneShape1.getType());

        Shape cloneShape2 = ShapeCache.getSgape("3");
        System.out.println("Shape:" + cloneShape2.getType());
    }
}
