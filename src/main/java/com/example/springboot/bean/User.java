package com.example.springboot.bean;

/**
 * ClassName:User
 * Package:com.example.springboot.bean
 * Description:
 *
 * @date:2020/2/21 18:46
 * @author:zh
 */
public class User {

    private Long id;

    private String username;

    private String password;

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
