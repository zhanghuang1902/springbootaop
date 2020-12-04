package com.springboot.wx.validator;

import com.springboot.wx.bean.SceneStr;

import java.util.Map;

/**
 * ClassName:InterimQrCodeValidator
 * Package:com.springboot.wx.bean
 * Description:
 *
 * @date:2020/12/3 18:04
 * @author:zh
 */
public class InterimQrCodeValidator {

    private String expire_seconds;

    private String action_name;

    private Map<String, SceneStr> action_info;

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public Map<String, SceneStr> getAction_info() {
        return action_info;
    }

    public void setAction_info(Map<String, SceneStr> action_info) {
        this.action_info = action_info;
    }
}
