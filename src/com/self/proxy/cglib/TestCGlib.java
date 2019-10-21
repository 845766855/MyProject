package com.self.proxy.cglib;

public class TestCGlib {

    public static void main(String[] args) {
        try {
            LiSi obj = (LiSi) new CenterPerson().getInstance(new LiSi().getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
