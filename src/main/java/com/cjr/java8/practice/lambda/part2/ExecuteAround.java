package com.cjr.java8.practice.lambda.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 环绕执行
 * @author cjr
 * @date 2019/1/4 14:28
 */
public class ExecuteAround {

    private static final String FILENAME = "D:\\devTools\\githubProject\\Java8Practice\\src\\main\\java\\com\\cjr\\java8\\practice\\lambda\\part2\\data.txt";

    public static void main(String[] args) throws IOException {
        String txt = processFileLimited();
        System.out.println(txt);

        String txt2 = processFile(br -> br.readLine() + "\t" + br.readLine());
        System.out.println(txt2);

        String txt3 = processFile(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine() + "\t" + br.readLine() + "\t" + br.readLine();
            }
        });
        System.out.println(txt3);
    }

    public static String processFileLimited() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }
}
