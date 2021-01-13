package com.springboot.wx.bean;

/**
 * ClassName:WxUserInfo
 * Package:com.springboot.wx.bean
 * Description:
 *
 * @date:2020/12/30 11:38
 * @author:zh
 */
public class WxUserInfo {

    private static final long serialVersionUID = 2119166090399412858L;
    private String openid;

    private String nickname;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private Object privilege;

    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl.contains("https")?headimgurl:headimgurl.replace("http","https");
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Object getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Object privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
