package com.excel.excel.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
//        List<Object> list = new ArrayList<>();
//        ExcelUtil.readBySax("D:/Test/挑片率统计.xlsx", 0, createRowHandler(list));
        ExcelReader reader = ExcelUtil.getReader("D:/Test/挑片率统计.xlsx",0);
        List<SanAnExcel> all =  reader.readAll(SanAnExcel.class);
        //将list转换成含有13个字段的集合
        ExcelReader readerCode = ExcelUtil.getReader("D:/Test/挑片率统计.xlsx",1);
        List<SanAnCode> code = readerCode.readAll(SanAnCode.class);
        ArrayList<SanAnExcel> objects = new ArrayList<>();
        for (SanAnExcel sanAnExcel : all) {
            for (SanAnCode sanAnCode : code) {
                if(sanAnExcel.get可投产品()!=null && sanAnExcel.get可投产品().equals(sanAnCode.get投片型号())){
                    if(NumberUtil.compare(sanAnCode.get波长min(),sanAnExcel.getSmpWld1Avg())==-1 &&NumberUtil.compare(sanAnCode.get波长max(),sanAnExcel.getSmpWld1Avg())==1
                            && sanAnExcel.getSmpLop1Avg()!=null && NumberUtil.compare(sanAnCode.get亮度min(),sanAnExcel.getSmpLop1Avg())==-1 &&NumberUtil.compare(sanAnCode.get亮度max(),sanAnExcel.getSmpLop1Avg())==1
                            && sanAnExcel.getSmpVf1Avg()!=null &&NumberUtil.compare(sanAnCode.get电压min(),sanAnExcel.getSmpVf1Avg())==-1 &&NumberUtil.compare(sanAnCode.get电压max(),sanAnExcel.getSmpVf1Avg())==1
                            && sanAnExcel.getVF4avg()!=null &&NumberUtil.compare(sanAnCode.getVF4min(),sanAnExcel.getVF4avg())==-1 &&NumberUtil.compare(sanAnCode.getVF4max(),sanAnExcel.getVF4avg())==1
                            && sanAnExcel.getWdStd()!=null &&NumberUtil.compare(sanAnCode.getWDSTDmin(),sanAnExcel.getWdStd())==-1 &&NumberUtil.compare(sanAnCode.getWDSTDmax(),sanAnExcel.getWdStd())==1
                            && sanAnExcel.getEsd2000pct()!=null &&NumberUtil.compare(sanAnCode.getESD2000min(),sanAnExcel.getEsd2000pct())==-1 &&NumberUtil.compare(sanAnCode.getESD2000max(),sanAnExcel.getEsd2000pct())==1
                            && sanAnExcel.getEsd4000pct()!=null &&NumberUtil.compare(sanAnCode.getESD4000min(),sanAnExcel.getEsd4000pct())==-1 &&NumberUtil.compare(sanAnCode.getESD4000max(),sanAnExcel.getEsd4000pct())==1
                            && sanAnExcel.get最终等级()!=null &&sanAnCode.get最终等级().equals(sanAnExcel.get最终等级())
                            && sanAnExcel.get表面等级()!=null &&sanAnCode.get表面等级().indexOf(sanAnExcel.get表面等级())!=-1)
                    {
                        objects.add(sanAnExcel);
                    }
                }
            }
        }
        //读取sheet2参数
        //找出符合条件的信息转换成list
        //计算比例
        //导出符合挑片信息的结果
        write(objects);
        //导出计算比例结果

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

    public static void write(List<SanAnExcel> all ){
        SimpleDateFormat format = new SimpleDateFormat("HH点mm分ss秒");
        Date date = new Date();
        String time = format.format(date);
        BigExcelWriter writer= ExcelUtil.getBigWriter("d:/三安/三安挑片查询"+time+".xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(all);
        // 关闭writer，释放内存
        writer.close();
    }
}
