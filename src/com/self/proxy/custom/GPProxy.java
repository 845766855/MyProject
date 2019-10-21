package com.self.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 生成代理对象的代码
 */
public class GPProxy {
    private static String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException {
        //生成源代码
        String filePath = GPProxy.class.getResource("").getPath();
        String proxySrc = generateSrc(interfaces[0]);
        //输出源代码 保存为.java文件
        File f = new File(filePath + "$Proxy0.java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            //编译源代码  生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            f.delete();
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //将class文件动态加载到JVM
        //返回被代理后的代理对象
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package com.self.proxy.custom;" + ln)
                .append("import java.lang.reflect.Method;" + ln)
                .append("public class $Proxy0 implements " + interfaces.getName() + " {" + ln)
                .append("GPInvocationHandler h;" + ln)
                .append("public $Proxy0(GPInvocationHandler h){" + ln)
                .append("this.h = h;" + ln)
                .append("}" + ln);
        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType() + " " + m.getName() + "() {" + ln);
            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch (Throwable e) {" + ln);
            src.append("e.printStackTrace();" + ln);
            src.append("}" + ln);
            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }
}
