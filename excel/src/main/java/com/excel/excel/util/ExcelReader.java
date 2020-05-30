package com.excel.excel.util;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.excel.excel.Person;

import java.util.List;

/**
 * @author 97083
 */
class ExcelReaderClass {

    public static void main(String[] args) throws Exception {
        ExcelReader reader = ExcelUtil.getReader("D:\\Test/测试.xlsx",0);
        List<Person> all =  reader.readAll(Person.class);



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


