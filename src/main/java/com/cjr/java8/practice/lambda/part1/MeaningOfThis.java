package com.cjr.java8.practice.lambda.part1;

/**
 * 匿名内部类在多线程环境下读取变量值的问题
 *
 * @author cjr
 * @date 2019/1/3 17:10
 */
public class MeaningOfThis {

    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println("value: " + this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
