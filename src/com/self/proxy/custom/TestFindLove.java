package com.self.proxy.custom;

import com.self.proxy.custom.Person;
import com.self.proxy.custom.GPProxyPerson;
import com.self.proxy.custom.ZhangSan;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class TestFindLove {

    public static void main(String[] args) {
//        new ZhangSan().findLove();
        try {
            Person obj = (Person) new GPProxyPerson().getInstance(new ZhangSan());
            System.out.println(obj.getClass());
            obj.findLove();

//            byte[] data = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{obj.getClass()});
//            FileOutputStream os = new FileOutputStream("E:\\$Proxy0.class");
//            os.write(data);
//            os.close();
//            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
