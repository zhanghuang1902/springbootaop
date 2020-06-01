package com.excel.excel.util;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 */
public class ExcelSanan {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("HH点mm分ss秒");
        Date date = new Date();
        String time = format.format(date);
        ExcelReader reader = ExcelUtil.getReader("D:/Test/挑片率统计.xlsx",0);
        List<SanAnExcel> all =  reader.readAll(SanAnExcel.class);
        ExcelWriter writer = ExcelUtil.getWriter("d:/三安/三安挑片查询"+time+".xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(13, "三安挑片");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(all, true);
        // 关闭writer，释放内存
        writer.close();
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
