package com.cjr.java8.practice.lambda.strategy;

import com.cjr.java8.practice.lambda.Apple;

/**
 * @author cjr
 * @date 2018/12/31 12:25
 */
public class ColorFilterStrategy implements IAppleFilterStrategy {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
