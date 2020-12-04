package com.springboot.wx.wxutil;

import com.springboot.wx.bean.AccessTokenBean;
import com.springboot.wx.bean.QrCodeBean;
import com.springboot.wx.bean.SceneStr;
import com.springboot.wx.validator.InterimQrCodeValidator;
import com.springboot.wx.wxurl.WxUrl;
import com.srpingboot.jedis.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * ClassName:AccessTokenController
 * Package:com.springboot.wx.accesstoken
 * Description:
 *
 * @date:2020/12/3 16:15
 * @author:zh
 */
@RestController
public class WxUtilController {

    @Value("${appid}")
    private String appid;

    @Value("${appsecret}")
    private String appsecret;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取微信公众号token
     *
     * @return
     */
    @RequestMapping("/accessToken")
    public String accessToken() {
        String url = WxUrl.url;
        String replace = url.replace("APPID", appid).replace("APPSECRET", appsecret);
        AccessTokenBean s = restTemplate.getForEntity(replace, AccessTokenBean.class).getBody();
        String access_token = s.getAccess_token();
        System.out.println(access_token);
        JedisUtil.set("access_token", access_token, 7600, 8);
        return access_token;
    }

    /**
     * 获取微信带参数二维码  临时
     *
     * @return
     */
    @RequestMapping("/interimQrCode")
    public void interimQrCode(HttpServletResponse response) throws IOException {
        //获取微信请求地址
        String url = WxUrl.interim_QrCode;
        String access_token;
        //判断redis是否存在
        if (JedisUtil.exists("access_token", 8)) {
            access_token = JedisUtil.get("access_token", 8);
        } else {
            access_token = accessToken();
        }
        url = url.replace("TOKEN", access_token);
        InterimQrCodeValidator validator = new InterimQrCodeValidator();
        HashMap<String, SceneStr> map = new HashMap<>();
        SceneStr sceneStr = new SceneStr();
        validator.setAction_name("QR_STR_SCENE");
        validator.setExpire_seconds("604800");
        sceneStr.setScene_str("zhanghuang");
        map.put("scene", sceneStr);
        validator.setAction_info(map);
        QrCodeBean body = restTemplate.postForEntity(url, validator, QrCodeBean.class).getBody();
        String ticket = body.getTicket();
        String qrCodeUrl = WxUrl.QrCode.replace("TICKET", ticket);
        byte[] s = restTemplate.getForObject(qrCodeUrl, byte[].class);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(s);
        outputStream.flush();
        outputStream.close();
    }


}
