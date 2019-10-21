package com.self.proxy.custom;

import java.lang.reflect.Method;

public class GPProxyPerson implements GPInvocationHandler {
    private Person person;

    public Object getInstance(Person object) throws Exception {
        this.person = object;
        Class clazz = person.getClass();
        System.out.println("proxy is " + clazz);
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);

//        return null;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("this sex is " + this.person.getSex() );
        System.out.println("start check");
        this.person.findLove();
        System.out.println("is ok");
        return null;
    }
}
