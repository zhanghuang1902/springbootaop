package com.excel.excel.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
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
        ExcelReader reader = ExcelUtil.getReader("D:/Test/挑片率统计.xlsx",0);
        //将list转换成含有13个字段的集合
        List<SanAnExcel> all =  reader.readAll(SanAnExcel.class);
        //读取sheet2参数
        ExcelReader readerCode = ExcelUtil.getReader("D:/Test/挑片率统计.xlsx",1);
        List<SanAnCode> code = readerCode.readAll(SanAnCode.class);
        //找出符合条件的信息转换成list
        ArrayList<SanAnExcel> objects = new ArrayList<>();
        for (SanAnExcel sanAnExcel : all) {
            for (SanAnCode sanAnCode : code) {
                if(sanAnExcel.get可投产品()!=null && sanAnExcel.get可投产品().equals(sanAnCode.get投片型号())){
                    if(sanAnExcel.getSmpWld1Avg()!=null
                            && ((NumberUtil.compare(sanAnCode.get波长min(),sanAnExcel.getSmpWld1Avg())==-1 && NumberUtil.compare(sanAnCode.get波长max(),sanAnExcel.getSmpWld1Avg())==1) || (NumberUtil.compare(sanAnCode.get波长min(),sanAnExcel.getSmpWld1Avg())==0 || NumberUtil.compare(sanAnCode.get波长max(),sanAnExcel.getSmpWld1Avg())==0))
                            && sanAnExcel.getSmpLop1Avg()!=null &&
                            ((NumberUtil.compare(sanAnCode.get亮度min(),sanAnExcel.getSmpLop1Avg())==-1 &&NumberUtil.compare(sanAnCode.get亮度max(),sanAnExcel.getSmpLop1Avg())==1) || (NumberUtil.compare(sanAnCode.get亮度min(),sanAnExcel.getSmpLop1Avg())==0 || NumberUtil.compare(sanAnCode.get亮度max(),sanAnExcel.getSmpLop1Avg())==0))
                            && sanAnExcel.getSmpVf1Avg()!=null &&
                            ((NumberUtil.compare(sanAnCode.get电压min(),sanAnExcel.getSmpVf1Avg())==-1 &&NumberUtil.compare(sanAnCode.get电压max(),sanAnExcel.getSmpVf1Avg())==1) || (NumberUtil.compare(sanAnCode.get电压min(),sanAnExcel.getSmpVf1Avg())==0 || NumberUtil.compare(sanAnCode.get电压max(),sanAnExcel.getSmpVf1Avg())==0))
                            && sanAnExcel.getVF4avg()!=null &&
                            ((NumberUtil.compare(sanAnCode.getVF4min(),sanAnExcel.getVF4avg())==-1 &&NumberUtil.compare(sanAnCode.getVF4max(),sanAnExcel.getVF4avg())==1) || (NumberUtil.compare(sanAnCode.getVF4min(),sanAnExcel.getVF4avg())==0 || NumberUtil.compare(sanAnCode.getVF4max(),sanAnExcel.getVF4avg())==0))
                            && sanAnExcel.getWdStd()!=null &&
                            ((NumberUtil.compare(sanAnCode.getWDSTDmin(),sanAnExcel.getWdStd())==-1 &&NumberUtil.compare(sanAnCode.getWDSTDmax(),sanAnExcel.getWdStd())==1) || (NumberUtil.compare(sanAnCode.getWDSTDmin(),sanAnExcel.getWdStd())==0 || NumberUtil.compare(sanAnCode.getWDSTDmax(),sanAnExcel.getWdStd())==0))
                            && sanAnExcel.getEsd2000pct()!=null &&
                            ((NumberUtil.compare(sanAnCode.getESD2000min(),sanAnExcel.getEsd2000pct())==-1 &&NumberUtil.compare(sanAnCode.getESD2000max(),sanAnExcel.getEsd2000pct())==1) || (NumberUtil.compare(sanAnCode.getESD2000min(),sanAnExcel.getEsd2000pct())==0 || NumberUtil.compare(sanAnCode.getESD2000max(),sanAnExcel.getEsd2000pct())==0))
                            && sanAnExcel.getEsd4000pct()!=null &&
                            ((NumberUtil.compare(sanAnCode.getESD4000min(),sanAnExcel.getEsd4000pct())==-1 &&NumberUtil.compare(sanAnCode.getESD4000max(),sanAnExcel.getEsd4000pct())==1) || (NumberUtil.compare(sanAnCode.getESD4000min(),sanAnExcel.getEsd4000pct())==0 || NumberUtil.compare(sanAnCode.getESD4000max(),sanAnExcel.getEsd4000pct())==0))
                            && sanAnExcel.get最终等级()!=null && sanAnCode.get最终等级().equals(sanAnExcel.get最终等级())
                            && sanAnExcel.get表面等级()!=null &&sanAnCode.get表面等级().indexOf(sanAnExcel.get表面等级())!=-1)
                    {
                        objects.add(sanAnExcel);
                    }
                }
            }
        }
        //计算比例
        //总条数
        int size = objects.size();
        List<ExcelResultSanAn> result = new ArrayList<>();
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        //各产品条数
        Map<String, List<SanAnExcel>> collect = objects.stream().collect(Collectors.groupingBy(SanAnExcel::get可投产品));
        collect.forEach((key,value)->{
            ExcelResultSanAn resultSanAn = new ExcelResultSanAn();
            resultSanAn.set下线品名(key);
            resultSanAn.set可投片数(value.size());
            result.add(resultSanAn);
        });
        for (ExcelResultSanAn resultSanAn : result) {
            resultSanAn.set比例(numberFormat.format((float)resultSanAn.get可投片数()/(float)size*100)+"%");
        }
        //导出符合挑片信息的结果
        write(objects,result);
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

    public static void write(List<SanAnExcel> all, List<ExcelResultSanAn> result){
        SimpleDateFormat format = new SimpleDateFormat("HH点mm分ss秒");
        Date date = new Date();
        String time = format.format(date);
        String path="d:/三安/三安挑片查询"+time+".xlsx";
        BigExcelWriter writer= ExcelUtil.getBigWriter(path);
        // 一次性写出内容，使用默认样式
        writer.write(all);
        // 关闭writer，释放内存
        writer.close();
        ExcelWriter writer2 = ExcelUtil.getWriter(path,"sheet2");
        // 合并单元格后的标题行，使用默认标题样式
        writer2.merge(result.size()-2, "挑片比例");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer2.write(result, true);
        // 关闭writer，释放内存
        writer2.close();
    }
}
