package org.wang.bootdemo.singletonDemo;

public class singletonDemo4 {
    private static singletonDemo4 instance = null;

    private singletonDemo4(){

    }

    /**
     * 此方案是比较完善的方案，内存占用小，多线程安全。性能也高。就是代码比较麻烦
     * @return
     */
    public static singletonDemo4 getInstance() {
        if (instance == null) {
            synchronized (singletonDemo4.class) {
                if (instance == null) {
                    instance = new singletonDemo4();
                }
            }
        }
        return instance;
    }
}
