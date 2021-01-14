package com.excel.easyexcel.easyreader;

import java.util.List;

/**
 * ClassName:DemoDAO
 * Package:com.excel.easyexcel.easyreader
 * Description:
 *
 * @date:2021/1/13 11:55
 * @author:zh
 */
public class DemoDAO{
    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
