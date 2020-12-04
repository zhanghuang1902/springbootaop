package com.springboot.wx.wxurl;

/**
 * ClassName:WxUrl
 * Package:com.springboot.wx.wxurl
 * Description:
 *
 * @date:2020/12/3 16:29
 * @author:zh
 */
public class WxUrl {

    /**
     * 获取微信token地址
     */
    public static String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取微信临时二维码地址
     */
    public static String interim_QrCode="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

    /**
     * 获取微信临时二维码图片地址
     */
    public static String QrCode="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
}
