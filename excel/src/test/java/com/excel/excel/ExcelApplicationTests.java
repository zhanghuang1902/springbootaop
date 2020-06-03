package com.excel.excel;

import com.excel.excel.util.ExcelController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelApplicationTests {

    @Autowired
    private ExcelController excelController;

    @Test
    void contextLoads() {
        excelController.readAndWrite("123");
    }

}
