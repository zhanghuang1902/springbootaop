package com.excel.excel.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * ClassName:ExcelController
 * Package:com.excel.excel.util
 * Description:
 *
 * @date:2020/6/1 17:02
 * @author:zh
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {


    @GetMapping("/readAndWrite/{name}")
    public String readAndWrite(@PathVariable("name") String name){

        if(StringUtils.isEmpty(name)){
            name = "三安挑片统计";
        }
//        ReadHandler readHandler = new ReadHandler();
        List<SanAnExcel> data = new ArrayList<>();
        AtomicBoolean b = new AtomicBoolean(true);
        ExcelUtil.readBySax("D:/Test/挑片率统计.xlsx", 0, (s,r,rl)->{
            if(b.get()){
                b.set(false);
                return;
            }
            SanAnExcel sanAnExcel = new SanAnExcel();
            sanAnExcel.set磊晶号((String)rl.get(0));
            sanAnExcel.set最终等级((String)rl.get(1));
            sanAnExcel.set表面等级((String)rl.get(2));
            sanAnExcel.set快测尺寸((String)rl.get(3));
            sanAnExcel.setIV(rl.get(4)==""?null:Double.parseDouble(rl.get(4).toString()));
            sanAnExcel.setSmpWld1Avg(rl.get(5)==""?null:Double.parseDouble(rl.get(5).toString()));
            sanAnExcel.setSmpLop1Avg(rl.get(6)==""?null:Double.parseDouble(rl.get(6).toString()));
            sanAnExcel.setSmpVf1Avg(rl.get(7)==""?null:Double.parseDouble(rl.get(7).toString()));
            sanAnExcel.setEsd2000pct(rl.get(8)==""?null:Double.parseDouble(rl.get(8).toString()));
            sanAnExcel.setEsd4000pct(rl.get(9)==""?null:Double.parseDouble(rl.get(9).toString()));
            sanAnExcel.setWdStd(rl.get(10)==""?null:Double.parseDouble(rl.get(10).toString()));
            sanAnExcel.setVF4avg(rl.get(11)==""?null:Double.parseDouble(rl.get(11).toString()));
            sanAnExcel.set可投产品((String)rl.get(12));
            data.add(sanAnExcel);
        });
        if(data.isEmpty()){
            return "没有读取到数据";
        }
        //读取sheet2参数
        ExcelReader readerCode = ExcelUtil.getReader("D:/Test/挑片率统计1.xlsx",1);
        List<SanAnCode> code = readerCode.readAll(SanAnCode.class);
        ArrayList<SanAnExcel> objects = new ArrayList<>();
        for (SanAnExcel sanAnExcel : data) {
            for (SanAnCode sanAnCode : code) {
//                if(sanAnExcel.get可投产品()!=null && sanAnExcel.get可投产品().equals(sanAnCode.get投片型号())){
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
                        sanAnExcel.set可投产品(sanAnCode.get投片型号());
                        sanAnExcel.set快测尺寸(sanAnCode.get快测尺寸());
                        objects.add(sanAnExcel);
                    }
//                }
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
        BigExcelWriter writer= ExcelUtil.getBigWriter("C:\\Users\\Admin\\Desktop\\"+name+".xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(objects);
        writer.flush();
        // 关闭writer，释放内存
//        writer.close();
        readerCode.close();
        return "搞定";
    }
}
