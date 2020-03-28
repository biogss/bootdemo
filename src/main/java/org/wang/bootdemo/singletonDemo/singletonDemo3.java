package org.wang.bootdemo.singletonDemo;

public class singletonDemo3 {

    private static singletonDemo3 instance = null;

    private singletonDemo3(){

    }

    /**
     * 不加synchronized则每个线程获得的实例都不一样
     * 加了锁虽然保证了线程安全，但是效率低下
     */
    public synchronized static singletonDemo3 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new singletonDemo3();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            new Thread(
                    () -> {
                        singletonDemo3 sd2 = singletonDemo3.getInstance();
                        System.out.println(sd2.toString());
                    }
            ).start();
        }
    }
}
