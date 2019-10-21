package com.self.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPerson implements InvocationHandler {

    private Person person;

    public Object getInstance(Person object) throws Exception {
        this.person = object;
        Class clazz = person.getClass();
        System.out.println("proxy is " + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this sex is " + this.person.getSex() );
        System.out.println("start check");
        this.person.findLove();
        System.out.println("is ok");
        return null;
    }
}
