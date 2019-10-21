package com.self.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CenterPerson implements MethodInterceptor {

    public Object getInstance(Class clazz) throws Exception {
        //反射机制   实例化
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //比JDK动态代理少一个 被代理接口
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("this sex is " + this.person.getSex() );
        System.out.println("start check");
//        this.person.findLove();
        methodProxy.invokeSuper(o,objects);
//        methodProxy.invoke(o,objects);//死循环
        System.out.println("is ok");
        return null;
    }
}
