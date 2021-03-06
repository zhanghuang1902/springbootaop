package com.excel.excel.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelController.class);

    @GetMapping("/sanan")
    public String readAndWrite(){
        SimpleDateFormat format = new SimpleDateFormat("HH点mm分ss秒");
        Date date = new Date();
        String time = format.format(date);
//        ReadHandler readHandler = new ReadHandler();
        List<SanAnExcel> data = new ArrayList<>();
        AtomicBoolean b = new AtomicBoolean(true);
        ExcelUtil.readBySax("D:/sanan/J04.xlsx", 0, (s,r,rl)->{
            if(b.get()){
                b.set(false);
                return;
            }
            if(rl.get(44)==null && rl.get(45)==null && rl.get(47)==null && rl.get(55)==null && rl.get(56)==null && rl.get(60)!=null && rl.get(66)==null&& rl.get(67)==null){
                return;
            }
            if(rl.get(44)!=null || rl.get(45)!=null || rl.get(47)!=null || rl.get(55)!=null || rl.get(56)!=null || rl.get(60)!=null || rl.get(66)!=null || rl.get(67)!=null){
                SanAnExcel sanAnExcel = new SanAnExcel();
                sanAnExcel.set磊晶号((String)rl.get(4));
                sanAnExcel.set最终等级((String)rl.get(24));
                sanAnExcel.set表面等级((String)rl.get(25));
                sanAnExcel.set快测尺寸((String)rl.get(39));
                sanAnExcel.set结构码((String)rl.get(32));
                sanAnExcel.setIV(rl.get(41)==""?null:Double.parseDouble(rl.get(41).toString()));
                sanAnExcel.setSmpWld1Avg(rl.get(44)==null?null:Double.parseDouble(rl.get(44).toString()));
                sanAnExcel.setSmpLop1Avg(rl.get(45)==null?null:Double.parseDouble(rl.get(45).toString()));
                sanAnExcel.setSmpVf1Avg(rl.get(47)==null?null:Double.parseDouble(rl.get(47).toString()));
                sanAnExcel.setEsd2000pct(rl.get(55)==null?null:Double.parseDouble(rl.get(55).toString()));
                sanAnExcel.setEsd4000pct(rl.get(56)==null?null:Double.parseDouble(rl.get(56).toString()));
                sanAnExcel.setWdStd(rl.get(60)==null?null:Double.parseDouble(rl.get(60).toString()));
                sanAnExcel.setVF4avg(rl.get(66)==null?null:Double.parseDouble(rl.get(66).toString()));
                sanAnExcel.setEsd3000pct(rl.get(67)==null?null:Double.parseDouble(rl.get(67).toString()));
                data.add(sanAnExcel);
            }
        });
        if(data.isEmpty()){
            return "没有读取到数据";
        }
        //读取sheet2参数
        ExcelReader readerCode = ExcelUtil.getReader("D:/sanan/J04.xlsx",1);
        List<SanAnCode> code = readerCode.readAll(SanAnCode.class);
        ArrayList<SanAnExcel> objects = new ArrayList<>();
        for (SanAnExcel sanAnExcel : data) {
            for (SanAnCode sanAnCode : code) {
                    if(sanAnExcel.getSmpWld1Avg()!=null
                            && sanAnExcel.get快测尺寸()!=null && sanAnCode.get快测尺寸().equals(sanAnExcel.get快测尺寸())
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
                            && sanAnExcel.getEsd3000pct()!=null &&
                            ((NumberUtil.compare(sanAnCode.getESD3000min(),sanAnExcel.getEsd3000pct())==-1 &&NumberUtil.compare(sanAnCode.getESD3000max(),sanAnExcel.getEsd3000pct())==1) || (NumberUtil.compare(sanAnCode.getESD3000min(),sanAnExcel.getEsd3000pct())==0 || NumberUtil.compare(sanAnCode.getESD3000max(),sanAnExcel.getEsd3000pct())==0))
                            && sanAnExcel.get最终等级()!=null && sanAnCode.get最终等级().indexOf(sanAnExcel.get最终等级())!=-1
                            && sanAnExcel.get表面等级()!=null && sanAnCode.get表面等级().indexOf(sanAnExcel.get表面等级())!=-1
                            && sanAnExcel.get结构码()!=null && sanAnCode.get结构码().indexOf(sanAnExcel.get结构码())!=-1
                            )
                    {
                        sanAnExcel.set可投产品(sanAnCode.get投片型号());
                        objects.add(sanAnExcel);
                        break;
                    }
            }

        }
        //计算比例
        //总条数
        int size = data.size();
        //不符合条件
        data.removeAll(objects);
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
            resultSanAn.set快测尺寸(value.get(0).get快测尺寸());
            result.add(resultSanAn);
        });
        for (ExcelResultSanAn resultSanAn : result) {
            resultSanAn.set比例(numberFormat.format((float)resultSanAn.get可投片数()/(float)size*100)+"%");
        }
        ExcelResultSanAn resultSanAn1 = new ExcelResultSanAn();
        resultSanAn1.set下线品名("不能投片");
        resultSanAn1.set可投片数(size-objects.size());
        resultSanAn1.set快测尺寸("");
        resultSanAn1.set比例(numberFormat.format((float)(size-objects.size())/(float)size*100)+"%");
        result.add(resultSanAn1);
        ExcelResultSanAn resultSanAn2 = new ExcelResultSanAn();
        resultSanAn2.set下线品名("总片数");
        resultSanAn2.set可投片数(size);
        resultSanAn2.set快测尺寸("");
        result.add(resultSanAn2);
        String path="D:\\挑片率计算导出\\";
        BigExcelWriter writer= ExcelUtil.getBigWriter(path+"挑片结果查询"+time+".xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(objects);
        writer.setSheet("比例");
        writer.write(result);
        writer.setSheet("不可投片数");
        writer.write(data);
        writer.flush();
        // 关闭writer，释放内存
//        writer.close();
        readerCode.close();
        return "鸿珊大妹子:搞定";
    }

    @GetMapping("/excel")
    public String excel1(){
        LOGGER.info("excel");
        ExcelWriter writer = null;
        try {
            long start = System.currentTimeMillis();
            AtomicBoolean b = new AtomicBoolean(true);
            List<SanAnCount> bean = new ArrayList<>();
            Map<String,String> set = new HashMap<>();
            ExcelUtil.readBySax("D:/sanan/excel.xlsx", 0, (s,r,rl)->{
                if(b.get()){
                    b.set(false);
                    return;
                }
                if(rl.get(0)!="" && rl.get(1)!=""){
                    set.put((String)rl.get(0), (String) rl.get(1));
                }
                if(!(rl.get(2) instanceof Long)){
                    SanAnCount sanAnCount = new SanAnCount();
                    sanAnCount.set异常总表(rl.get(0).toString());
                    sanAnCount.set异常原因(rl.get(1).toString());
                    sanAnCount.set库存表(rl.get(2).toString());
                    bean.add(sanAnCount);
                }
            });
            for (SanAnCount item : bean) {
                if((item.get库存表()==null || "".equals(item.get库存表()))){
                    LOGGER.info("开始写出");
                    break;
                }
                if(set.containsKey(item.get库存表())){
                    item.set现有异常(item.get库存表());
                    item.set现有异常原因(set.get(item.get库存表()));
                }
            }
            // 通过工具类创建writer
            writer = ExcelUtil.getBigWriter("D:/sanan/excel(结果).xlsx");
            writer.write(bean);
            // 关闭writer，释放内存
            writer.flush();
            LOGGER.info("写出完成");
            return "导出成功,耗时："+(System.currentTimeMillis()-start)/1000 + " 秒。使用完毕，将excel(结果).xlsx 删除";
        }catch (Exception e){
            LOGGER.error("excel1异常",e.getCause());
            return "失败";
        }
    }
}
