package com.cjr.java8.practice.lambda.strategy;

import com.cjr.java8.practice.lambda.Apple;

/**
 * 策略实现：按重量
 * @author cjr
 * @date 2018/12/31 12:17
 */
public class WeightFilterStrategy implements IAppleFilterStrategy {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
