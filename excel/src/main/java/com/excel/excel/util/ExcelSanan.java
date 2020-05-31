package com.excel.excel.util;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.List;

public class ExcelSanan {

    public static void main(String[] args) throws Exception {
        ExcelReader reader = ExcelUtil.getReader("D:\\Test/测试.xlsx",0);
        List<Person> all =  reader.readAll(Person.class);
        for (Person person : all) {
            System.out.println(person.toString());
        }



    }

    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int i, int i1, List<Object> list) {
                Console.log("[{}] [{}] {}", i, i1, list);
            }
        };
    }
}
