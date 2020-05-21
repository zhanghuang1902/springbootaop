package com.example.springboot.until;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ClassName:TestUtil
 * Package:com.example.springboot.until
 * Description:
 *
 * @date:2020/4/27 17:23
 * @author:zh
 */
public class TestUtil {
    public static void main(String[] args) throws Exception {
        SocketChannel localhost = SocketChannel.open(new InetSocketAddress("192.168.0.155", 7777));
        localhost.configureBlocking(false);
        System.out.println("请输入你的名字");
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (scanner.hasNext()){
            String next = scanner.next();
            if(next == null || next.trim().length() == 0){
                System.out.println("请重新输入你的名字");
            }else {
                name = next;
                System.out.println("你可以开始聊天了");
                break;
            }
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (scanner.hasNext()) {
            String next = scanner.next();
            byteBuffer.put(("\033[32m"+name+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+System.lineSeparator()).getBytes());
            byteBuffer.put(("\033[30m"+next).getBytes());
            byteBuffer.flip();
            localhost.write(byteBuffer);
            byteBuffer.clear();
        }
        localhost.close();
    }
}
