package com.cjr.java8.practice.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 菜肴
 * @author cjr
 * @date 2019/1/4 15:07
 */
public class Dish {

    /**
     * 菜肴名称
     */
    private final String name;

    /**
     * 是否素菜
     */
    private final boolean vegetarian;

    /**
     * 热量-卡路里
     */
    private final int calories;

    /**
     * 菜肴类型
     */
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("猪肉", false, 800, Dish.Type.MEAT),
                    new Dish("牛肉", false, 700, Dish.Type.MEAT),
                    new Dish("鸡肉", false, 400, Dish.Type.MEAT),
                    new Dish("炸薯条", true, 530, Dish.Type.OTHER),
                    new Dish("大米", true, 350, Dish.Type.OTHER),
                    new Dish("时令水果", true, 120, Dish.Type.OTHER),
                    new Dish("披萨", true, 550, Dish.Type.OTHER),
                    new Dish("明虾", false, 400, Dish.Type.FISH),
                    new Dish("三文鱼", false, 450, Dish.Type.FISH));
}
