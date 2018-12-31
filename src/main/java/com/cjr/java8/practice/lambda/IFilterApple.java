package com.cjr.java8.practice.lambda;

/**
 * 过滤接口
 *
 * @author cjr
 * @date 2018-12-24
 */
public interface IFilterApple {

    /**
     * 条件验证
     *
     * @param apple Apple实例对象
     * @return 验证结果boolean值
     */
    boolean test(Apple apple);
}
