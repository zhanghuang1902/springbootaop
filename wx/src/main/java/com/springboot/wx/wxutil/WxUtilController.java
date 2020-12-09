package com.springboot.wx.wxutil;

import com.springboot.wx.bean.AccessTokenBean;
import com.springboot.wx.bean.QrCodeBean;
import com.springboot.wx.bean.SceneStr;
import com.springboot.wx.validator.InterimQrCodeValidator;
import com.springboot.wx.wxurl.WxUrl;
import com.srpingboot.jedis.util.JedisUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    /**
     * 推送时间验证解密
     * 端口号必须是80 地址为微信公众号设置的路由
     */
    @GetMapping("/patient/authentication/authenticationMessage")
    public String getWxPushAndDecrypt(String signature,String timestamp,String nonce,String echostr) {
        try {
            List<String> list = Arrays.asList("123456", timestamp, nonce);
            list.sort(String::compareTo);
            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);
            String s = DigestUtils.sha1Hex(sb.toString());
            System.out.println(signature);
            System.out.println(s);
            if (signature.equals(s)) {
                return echostr;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
