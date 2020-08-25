package com.example.recovery.bean;

/**
 * ClassName:TestBean
 * Package:com.example.recovery.bean
 * Description:
 *
 * @date:2020/8/20 10:48
 * @author:zh
 */
public class TestBean {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id='" + id + '\'' +
                '}';
    }
}
