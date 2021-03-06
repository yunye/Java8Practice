package com.cjr.java8.practice.lambda;

/**
 * 苹果
 * 
 * @author cjr
 * @date 2018-12-24
 *
 */
public class Apple {
    /** 重量. */
    private Integer weight = 0;

    /** 颜色. */
    private String color = "";

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }
}
