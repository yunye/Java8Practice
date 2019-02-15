package com.cjr.java8.practice.stream;

/**
 * 流的查找
 * @author cjr
 * @date 2019-02-15
 *
 */
public class Finding {

    public static void main(String[] args) {
        boolean flag = Dish.menu.stream().anyMatch(t -> t.isVegetarian());
        System.out.println(flag);

    }

}
