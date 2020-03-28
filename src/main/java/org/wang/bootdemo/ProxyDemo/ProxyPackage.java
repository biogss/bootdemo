package org.wang.bootdemo.ProxyDemo;

import java.lang.reflect.Proxy;

public class ProxyPackage {

    public static Object getProxy(Object obj) {
        ProxyDemo pyd = new ProxyDemo(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), pyd);

    }
}
