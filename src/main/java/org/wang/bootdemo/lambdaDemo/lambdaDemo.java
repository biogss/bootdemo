package org.wang.bootdemo.lambdaDemo;

import java.util.function.*;

/**
 * lambda表达式测试类
 * @author biogss
 */
public class lambdaDemo {

    public void apply(int num, Consumer<Integer> con){
        con.accept(num);
    }

    public void apply2(int num1, int num2, BiConsumer<Integer, Integer> bicon){
        bicon.accept(num1, num2);
    }

    public String apply3(int num, Function<Integer, String> func) {
        return func.apply(num);
    }

    public String apply4(Supplier<String> sup) {
        return sup.get();
    }

    public boolean apply5(String a, Predicate<String> pre) {
        return pre.test(a);
    }

    public static void main(String[] args) {
        lambdaDemo ld = new lambdaDemo();
        ld.apply(1000, (num) -> {
            System.out.println("消费了" + num + "元");
        });

        ld.apply2( 1000, 200, (a, b) -> {
            System.out.println("打折促销，原价：" + a + "，现在只要：" + b + ",便宜了：" + (a/b)+ "倍");
        });

        String s = ld.apply3(100, (Integer num) -> {
            return String.valueOf(num) + "abc";});
        System.out.println(s);

        System.out.println(ld.apply4(() -> {
            int a = 3;
            int b = 5;
            return String.valueOf(a + b);
        }));

        System.out.println(ld.apply5("a", (String a) -> {
            return a.equals("a");
        }));
    }
}
