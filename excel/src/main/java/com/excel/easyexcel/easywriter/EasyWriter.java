package com.excel.easyexcel.easywriter;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.excel.easyexcel.bean.Data;
import com.excel.easyexcel.bean.User;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:EasyWriter
 * Package:com.excel.easyexcel.easywriter
 * Description:
 *
 * @date:2021/1/13 9:43
 * @author:zh
 */
public class EasyWriter {
    public static  String  path="C:\\Users\\Admin\\Desktop\\班级"+System.currentTimeMillis()+".xlsx";

    public static List<Data> list=new ArrayList<>() ;

    @Test
    public  void EasyWriterOne() {
        //创建数据源
        Data data = new Data("张煌", "20", "1");
        Data data1 = new Data("谢喆", "18", "2");
        Data data2 = new Data("赵辅明", "21", "3");
        list.add(data);
        list.add(data1);
        list.add(data2);
        //写出
        File file = new File(path);
        EasyExcel.write(file,Data.class).sheet("班级").doWrite(list);
    }

    @Test
    public void EasyWriterTwo(){
        Data data = new Data("张宝岩", "19", "1");
        list.add(data);
        File file = new File(path);
        //创建工作薄
        ExcelWriter writer = EasyExcel.write(file, Data.class).build();
        //创建工作表
        WriteSheet sheet = EasyExcel.writerSheet("班级").build();
        //工作薄写入
        writer.write(list, sheet);
        //关闭流
        writer.finish();
    }

    /**
     * 根据参数只导出指定的列
     */
    @Test
    public void EasyWriterThree(){
        Data data = new Data("张宝岩", "19", "1");
        list.add(data);
        File file = new File(path);
        HashSet<String> excludeColumnFiledNames = new HashSet<>();
        excludeColumnFiledNames.add("age");
        Set<String> includeColumnFiledNames = new HashSet<>();
        includeColumnFiledNames.add("age");
        includeColumnFiledNames.add("name");
        //根据参数只导出指定的列 忽略age 导出不显示
        EasyExcel.write(file, Data.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("班级").doWrite(list);
        //根据参数只导出指定的列 显示age 导出显示 只导出age,name列
        EasyExcel.write(file, Data.class).includeColumnFiledNames(includeColumnFiledNames).sheet("班级").doWrite(list);

    }

    /**
     * 复杂头写出
     */
    @Test
    public void EasyWriterFour(){
        User users = new User("张宝岩", "20", "1");
        ArrayList<User> data = new ArrayList<>();
        data.add(users);
        File file = new File(path);
        EasyExcel.write(file, User.class).sheet("班级").doWrite(data);
    }

    /**
     * 重复多次写入(写到单个或者多个Sheet)
     */
    @Test
    public void EasyWriterFive(){
        //创建数据源
        Data data = new Data("张煌", "20", "1");
        Data data1 = new Data("谢喆", "18", "2");
        Data data2 = new Data("赵辅明", "21", "3");
        list.add(data);
        list.add(data1);
        list.add(data2);
        ExcelWriter writer = null;
        try {
            File file = new File(path);
            //写出
            writer = EasyExcel.write(file, Data.class).build();
//            // 这里注意 如果同一个sheet只要创建一次
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            for (int i = 0; i < 5; i++) {
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                writer.write(list, writeSheet);
//            }
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//            for (int i = 0; i < 5; i++) {
//                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
//                WriteSheet writeSheetTwo = EasyExcel.writerSheet(i, "模板" + i).build();
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                writer.write(list, writeSheetTwo);
//            }

            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
                if(i==2){
                    WriteSheet writeSheetThree = EasyExcel.writerSheet(i, "模板" + i).head(User.class).build();
                    writer.write(list, writeSheetThree);
                }
                WriteSheet writeSheetThree = EasyExcel.writerSheet(i, "模板" + i).head(Data.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                writer.write(list, writeSheetThree);
            }
        } finally {
            if(writer!=null){
                writer.finish();
            }
        }
    }
}
