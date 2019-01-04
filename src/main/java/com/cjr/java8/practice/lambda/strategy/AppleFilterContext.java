package com.cjr.java8.practice.lambda.strategy;

import com.cjr.java8.practice.lambda.Apple;

/**
 * 策略上下文
 * @author cjr
 * @date 2018/12/31 12:28
 */
public class AppleFilterContext {

    private IAppleFilterStrategy appleFilterStrategy;

    public AppleFilterContext(IAppleFilterStrategy appleFilterStrategy){
        this.appleFilterStrategy = appleFilterStrategy;
    }

    public boolean test(Apple apple){
        return appleFilterStrategy.test(apple);
    }
}
