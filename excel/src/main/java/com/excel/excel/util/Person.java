package com.excel.excel.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 97083
 */
public class Person {

    private String name;

    private String age;

    private String work;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", work='" + work + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list2.add("我");
        list2.add("是");
        list2.add("张煌");
        for (String s : list1) {
            for (String s1 : list2) {
                System.out.println(s+s1);
            }
        }

    }
}
