package com.excel.easyexcel.easyreader;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.excel.easyexcel.easywriter.EasyWriter;
import org.junit.Test;

import java.io.File;

/**
 * ClassName:EasyReader
 * Package:com.excel.easyexcel.easyreader
 * Description:
 *
 * @date:2021/1/13 11:58
 * @author:zh
 */
public class EasyReader {

    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "C:\\Users\\Admin\\Desktop\\班级1610509120113.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet("班级").doRead();

//        // 写法2：
//        fileName = EasyWriter.path;
//        ExcelReader excelReader = null;
//        try {
//            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            excelReader.read(readSheet);
//        } finally {
//            if (excelReader != null) {
//                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                excelReader.finish();
//            }
//        }
    }
}
