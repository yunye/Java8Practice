package com.cjr.java8.practice.lambda.part2;

import com.cjr.java8.practice.lambda.Apple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Lambda 与排序
 *
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

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(100, "green"));
        inventory.add(new Apple(300, "green"));
        inventory.add(new Apple(200, "red"));

        List<Apple> greenApples = filter(inventory, a -> "green".equals(a.getColor()));
        System.out.println("greenApples: " + greenApples);

        Comparator<Apple> c1 = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        inventory.sort(c1);
        System.out.println("重量升序：" + inventory);

        inventory.sort((a1, a2) -> a2.getWeight().compareTo(a1.getWeight()));
        System.out.println("重量降序：" + inventory);

        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("重量升序：" + inventory);

    }


    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
