package com.example.springboot;

import java.math.BigDecimal;

/**
 * ClassName:TestClass
 * Package:com.example.springboot
 * Description:
 *
 * @date:2020/5/22 13:25
 * @author:zh
 */
public class TestClass {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(20.10);
        String s = decimal.setScale(2,BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        System.out.println(s);
    }
}
