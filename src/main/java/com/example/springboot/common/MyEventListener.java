package com.example.springboot.common;

import com.example.springboot.bean.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ClassName:MyEventListener
 * Package:com.example.springboot.common
 * Description:
 *
 * @date:2020/2/24 14:43
 * @author:zh
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        User user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        System.out.println("用户名：" + user.getUsername());
        System.out.println("密码：" + user.getPassword());
    }
}
