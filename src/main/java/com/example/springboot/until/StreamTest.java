package com.example.springboot.until;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:StreamTest
 * Package:com.example.springboot.until
 * Description:
 *
 * @date:2020/2/24 22:28
 * @author:zh
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> id=new ArrayList<>();
        id.add("1");
        id.add("张三");
        id.add("李四");
        id.add("2");
        id.add("3");
        id.add("3");
        System.out.println(id.toString());

        List<String> list = id.stream().filter(s -> s.equals("张三")).collect(Collectors.toList());
        System.out.println(list.toString());
        List<String> collect = id.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = id.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect1);
        List<String> collect2 = id.stream().collect(Collectors.toList());
        System.out.println(collect2);
        List<String> collect3 = id.stream().skip(3).collect(Collectors.toList());
        System.out.println(collect3);
        List<String> collect4 = id.stream().limit(3).skip(2).collect(Collectors.toList());
        System.out.println(collect4);
        List<String> collect5 = id.stream().skip(1).limit(1).collect(Collectors.toList());
        System.out.println(collect5);
        List<String> collect6 = id.stream().map(s -> "3").collect(Collectors.toList());
        System.out.println(collect6);
    }
}
