package com.excel.excel.util;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            name = "nidayede";
        }
        ReadHandler readHandler = new ReadHandler();
        ExcelUtil.readBySax("D:/Test/挑片率统计.xlsx", 0, readHandler);
        List<Object> data = readHandler.getData();
        if(data.isEmpty()){
            return "没有读取到数据";
        }
        BigExcelWriter writer= ExcelUtil.getBigWriter("C:\\Users\\Admin\\Desktop\\"+name+".xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(data);
        // 关闭writer，释放内存
        writer.close();
        return "搞定";
    }
}
