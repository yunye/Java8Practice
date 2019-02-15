package com.cjr.java8.practice.stream;

import static com.cjr.java8.practice.stream.Dish.menu;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * 流的过滤
 * 
 * @author cjr
 * @date 2019-02-14
 *
 */
public class Filter {

    public static void main(String... args) {

        // filter by predicate 使用断言过滤
        List<Dish> vegetarainMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());

        vegetarainMenu.stream().forEach(System.out::println);

        // filter unique elements 过滤重复的元素
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        // truncating a stream 流的截断
        List<Dish> dishesLimit3 = menu.stream().filter(t -> t.getCalories() > 300).limit(3).collect(toList());

        dishesLimit3.stream().forEach(System.out::println);

        // skip element 跳过元素
        List<Dish> dishesSkip2 = menu.stream().filter(t -> t.getCalories() > 300).skip(2).collect(toList());
        dishesSkip2.forEach(System.out::println);

    }

}
