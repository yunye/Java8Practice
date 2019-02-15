package com.cjr.java8.practice.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流Stream的构造
 *
 * @author cjr
 * @date 2019/1/4 16:11
 */
public class BuildingStreams {

    private static final String FILENAME = "D:\\devTools\\githubProject\\Java8Practice\\src\\main\\java\\com\\cjr\\java8\\practice\\stream\\data.txt";

    public static void main(String[] args) throws IOException {
        // Stream.of
        System.out.println("------ Stream.of ------");
        Stream<String> stream = Stream.of("北京", "上海", "广州");
        stream.forEach(System.out::println);

        //Stream.empty
        Stream<String> emptyStream = Stream.empty();

        //Arrays.stream
        System.out.println("------ Arrays.stream ------");
        int[] numbers = {1, 3, 5, 7};
        System.out.println(Arrays.stream(numbers).sum());

        //Stream.iterator
        System.out.println("------ Stream.iterator ------");
        Stream.iterate(0, n -> n + 2).limit(3).forEach(System.out::println);

        //斐波那契数列
        System.out.println("------ 斐波那契数列流 ------");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(10)
                .map(ints -> ints[0]).forEach(System.out::println);

        //产生随机数流
        System.out.println("------ 产生随机数流 ------");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        System.out.println("------ 产生limit个相同的数字1的流 ------");
        Stream.generate(() -> 1).limit(5).forEach(System.out::println);

        //IntStream 、IntSupplier
        System.out.println("------ 产生limit个相同的数字流 ------");
        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        System.out.println("------ 使用IntSupplier产生limit个斐波那契数列流------");
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int returnValue = this.previous;
                int next = this.previous + this.current;
                this.previous = current;
                this.current = next;
                return returnValue;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        // flatMap
        System.out.println("------ 统计文本文件中不同的单词个数 ------");
        long uniqueWords = Files.lines(Paths.get(FILENAME), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        System.out.println(uniqueWords);

    }
}
