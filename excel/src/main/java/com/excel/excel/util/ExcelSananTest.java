package com.excel.excel.util;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ExcelSananTest
 * Package:com.excel.excel.util
 * Description:
 *
 * @date:2020/6/1 15:51
 * @author:zh
 */
public class ExcelSananTest {

public static List<Object> aa = new ArrayList<>();

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        ExcelUtil.readBySax("D:/Test/挑片率统计.xlsx", 0, createRowHandler(list));
        write(list);
    }

    private static RowHandler createRowHandler(List<Object> list) {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                list.add(rowlist);
                ExcelSananTest.aa.add(rowlist);
            }
        };
    }

    public static void write(List<Object> list){
        BigExcelWriter writer= ExcelUtil.getBigWriter("C:\\Users\\Admin\\Desktop\\DSB.xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(list);
        // 关闭writer，释放内存
        writer.close();
    }
}
