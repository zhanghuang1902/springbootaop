package com.excel.easyexcel.bean;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * ClassName:User
 * Package:com.excel.easyexcel.bean
 * Description:
 *
 * @date:2021/1/13 10:50
 * @author:zh
 */
public class User {
    @ExcelProperty({"培优班","姓名"})
    private String name;

    @ExcelProperty({"培优班","年龄"})
    private String age;

    @ExcelProperty({"班级分次","班级"})
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

    public User(String name, String age, String classId) {
        this.name = name;
        this.age = age;
        this.classId = classId;
    }

}
