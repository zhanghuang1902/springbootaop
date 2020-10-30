package com.springboot.aop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
class AopApplicationTests {

    @Test
    void contextLoads() throws IOException {
        FileReader fileReader = null;
        try {
            //创建读
            fileReader = new FileReader("hello.txt");
            //读文件
            int len=fileReader.read();
            while (len!=-1){
                System.out.println(fileReader.read());
                len=fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
    }

}
