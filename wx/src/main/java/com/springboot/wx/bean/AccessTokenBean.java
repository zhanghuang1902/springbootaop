package com.springboot.wx.bean;

/**
 * ClassName:AccessTokenBean
 * Package:com.springboot.wx.bean
 * Description:
 *
 * @date:2020/12/3 16:55
 * @author:zh
 */
public class AccessTokenBean {

    private String access_token;

    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
