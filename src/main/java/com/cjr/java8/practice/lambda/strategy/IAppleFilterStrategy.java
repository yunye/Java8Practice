package com.cjr.java8.practice.lambda.strategy;

import com.cjr.java8.practice.lambda.Apple;

/**
 * 策略接口
 */
public interface IAppleFilterStrategy {

    boolean test(Apple apple);
}
