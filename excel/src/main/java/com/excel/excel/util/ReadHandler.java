package com.excel.excel.util;

import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ReadHandler
 * Package:com.excel.excel.util
 * Description:
 *
 * @date:2020/6/1 17:00
 * @author:zh
 */
public class ReadHandler implements RowHandler {

    private List<Object> data = new ArrayList<>();


    @Override
    public void handle(int sheetIndex, int rowIndex, List<Object> rowList) {
        data.add(rowList);
    }

    public List<Object> getData() {
        return data;
    }
}
