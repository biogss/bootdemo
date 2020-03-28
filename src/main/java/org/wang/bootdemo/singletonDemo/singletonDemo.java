package org.wang.bootdemo.singletonDemo;

import java.util.Set;

public class singletonDemo {

    /**
     * 饿汉模式
     * 优点：不存在多线程问题，编码简单
     * 缺点：占用内存高，不管用不用，直到对象销毁才释放内存
     */
    private final static singletonDemo instance = new singletonDemo();

    private singletonDemo(){
    }

    public static singletonDemo getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        singletonDemo sd = singletonDemo.getInstance();
        singletonDemo sd2 = singletonDemo.getInstance();
        System.out.println(sd.equals(sd2));
    }
}
