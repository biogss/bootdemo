package org.wang.bootdemo.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDemo implements InvocationHandler {

    Object target;

    public ProxyDemo(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxyHandler execute before!");
        Object obj = method.invoke(target, args);
        System.out.println("proxyHandler execute after!");
        return obj;
    }

    public static void main(String[] args) {
        MyInterface myInterface = (MyInterface) ProxyPackage.getProxy(new MyObject());
        myInterface.execute();
        YourInterface yourInterface = (YourInterface)ProxyPackage.getProxy(new MyObject());
        yourInterface.doSomething(12345);
    }
}
