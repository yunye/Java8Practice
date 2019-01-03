package com.cjr.java8.practice.lambda.part2;

import com.cjr.java8.practice.lambda.Apple;
import java.util.Comparator;

/**
 * Lambda 与排序
 * @author cjr
 * @date 2019/1/3 17:30
 */
public class SortApple {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("hello 2");
        r2.run();

        Comparator<Apple> c1 = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };


    }
}
