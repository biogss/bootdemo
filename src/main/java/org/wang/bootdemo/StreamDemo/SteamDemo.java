package org.wang.bootdemo.StreamDemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamDemo {

    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(7);
        alist.add(3);
        alist.add(4);
        alist.add(4);
        alist.add(5);
        Stream<Integer> steam = alist.stream();
        //steam.distinct().forEach((Integer num) -> System.out.println(num));
        //steam.distinct().filter((num) -> {return num > 2;}).forEach((num) -> System.out.println(num));
        List<String> blist = steam.filter((num) -> {return num >2;})
                .sorted(Comparator.comparingInt((num) -> {return num % 2;}))
                .map((num) -> {return String.valueOf(num) + "a";})
                .collect(Collectors.toList());
        blist.stream().forEach((str) ->{
            System.out.println(str);
        });

    }


}
