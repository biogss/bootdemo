package org.wang.bootdemo.singletonDemo;

public class singletonDemo2 {

    /**
     * 懒汉模式
     * 优点：get()时才会创建，占用内容低
     * 缺点：多线程模式下存在问题，会创建多个实例
     */
    private static singletonDemo2 instance = null;

    private singletonDemo2(){

    }

    public static singletonDemo2 getInstance() {
        if (instance == null) {
            instance = new singletonDemo2();
        }
        return instance;
    }

    public static void main(String[] args) {
        singletonDemo2 sd = singletonDemo2.getInstance();
        singletonDemo2 sd2 = singletonDemo2.getInstance();
//        System.out.println(sd.equals(null));
        System.out.println(sd.equals(sd2));
    }
}
