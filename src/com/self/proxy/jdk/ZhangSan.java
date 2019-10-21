package com.self.proxy.jdk;

public class ZhangSan implements Person {

    private String sex = "boy";
    private String name = "zhangsan";

    @Override
    public void findLove() {
        System.out.println("my name is " + this.name + " sex is " + this.sex);
        System.out.println("if a");
        System.out.println("if b");
        System.out.println("if c");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
