package com.example.springboot.bean;

/**
 * ClassName:UserMessage
 * Package:com.example.springboot.bean
 * Description:
 *
 * @date:2020/2/23 17:33
 * @author:zh
 */
public class UserMessage {

    private int id;

    private String userName;

    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
