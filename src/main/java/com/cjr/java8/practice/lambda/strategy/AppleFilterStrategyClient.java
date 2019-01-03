package com.cjr.java8.practice.lambda.strategy;

import com.cjr.java8.practice.lambda.Apple;

/**
 * 策略使用的客户端程序
 *
 * @author cjr
 * @date 2018/12/31 14:40
 */
public class AppleFilterStrategyClient {

    public static void main(String[] args) {
        //1. 创建策略： 根据重量过滤
        IAppleFilterStrategy wightStrategy = new WeightFilterStrategy();

        //2. 创建上下文对象
        AppleFilterContext appleFilterContext = new AppleFilterContext(wightStrategy);

        //3. 调用策略上下文对象的方法
        Apple apple = new Apple(200, "green");
        System.out.println(appleFilterContext.test(apple));

        //4. 创建策略： 根据颜色过滤
        IAppleFilterStrategy colorStrategy = new ColorFilterStrategy();

        //5. 创建上下文对象
        AppleFilterContext appleFilterContext2 = new AppleFilterContext(colorStrategy);

        //6. 调用策略上下文对象的方法
        Apple apple2 = new Apple(200, "red");
        System.out.println(appleFilterContext2.test(apple2));
    }
}
