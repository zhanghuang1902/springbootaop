package com.srpingboot.jedis.expirelistener;



import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * ClassName:RedisKeyExpirationListener
 * Package:com.srpingboot.jedis.expirelistener
 * Description:
 *
 * @date:2020/11/30 15:57
 * @author:zh
 *
 * 引入的依赖
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        String s = new String(body);
        String s1 = new String(pattern);
        String s2 = new String(channel);
        System.out.println("body"+s);
        System.out.println("pattern"+s1);
        System.out.println("channel"+s2);
        System.out.println("过期"+message.toString());
    }
}
