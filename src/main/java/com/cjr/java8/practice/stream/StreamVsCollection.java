package com.cjr.java8.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流和集合的区别
 * @author cjr
 * @date 2019/1/4 15:15
 */
public class StreamVsCollection {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "C#", "JavaScript");
        Stream<String> stream = names.stream();
        stream.forEach(s -> System.out.println(s));

        /// 流只能被消费一次，如果取消下面代码的注释， 则会抛异常 IllegalStateException
        /// stream.forEach(s -> System.out.println(s));
    }


}
