package org.wang.bootdemo.ProxyDemo;

public class MyObject implements MyInterface,YourInterface {
    @Override
    public void execute() {
        System.out.println("myObject execute！");
//        return 100;
    }

    @Override
    public void doSomething(int num) {
        System.out.println(num);
    }
}
