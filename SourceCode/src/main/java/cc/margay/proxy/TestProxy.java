package cc.margay.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        Person p1 = new Student();
        Person p2 = new Teacher();
        InvocationHandler h1 = new LogHandler(p1);
        InvocationHandler h2 = new LogHandler(p2);
        ClassLoader classLoader = Person.class.getClassLoader();
        Class[] interfaces = new Class[] {Person.class};
        // 通过调用Proxy.newProxyInstance()方法创建动态代理
        // 该方法接受一个类加载器(通常可以从已加载对象获得), 希望代理实现的接口(只能是接口), 以及接口的一个实现
        Person proxy1 = (Person) Proxy.newProxyInstance(classLoader, interfaces, h1);
        Person proxy2 = (Person) Proxy.newProxyInstance(classLoader, interfaces, h2);
        proxy1.say();
        proxy2.say();
    }
}
