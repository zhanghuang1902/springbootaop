package com.excel.easyexcel.bean;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * ClassName:Data
 * Package:com.excel.easyexcel.bean
 * Description:
 *
 * @date:2021/1/13 9:41
 * @author:zh
 */
public class Data {

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "年龄")
    private String age;

    @ExcelProperty(value = "班级")
    private String classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Data(String name, String age, String classId) {
        this.name = name;
        this.age = age;
        this.classId = classId;
    }
}
