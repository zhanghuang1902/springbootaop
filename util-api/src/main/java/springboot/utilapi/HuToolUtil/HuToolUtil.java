package springboot.utilapi.HuToolUtil;

import cn.hutool.core.util.XmlUtil;

import java.util.*;
import java.util.stream.Stream;

/**
 * ClassName:HuToolUtil
 * Package:springboot.utilapi.HuToolUtil
 * Description:
 *
 * @date:2020/10/30 15:58
 * @author:zh
 *
 * 类型转换工具类-Convert
 */
public class HuToolUtil {

    public static void main(String[] args) {


        List<String> abc=new ArrayList<>();
        abc.add("12346");
        String a="123456";
        boolean b = abc.contains("12346");
        boolean contains = a.contains("12356");
        System.out.println(contains);
        System.out.println(b);
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<returnsms> \n" +
                "  <returnstatus>Success（成功）</returnstatus>  \n" +
                "  <message>ok</message>  \n" +
                "  <remainpoint>1490</remainpoint>  \n" +
                "  <taskID>885</taskID>  \n" +
                "  <successCounts>1</successCounts> \n" +
                "</returnsms>\n";

        Map<String, Object> map = XmlUtil.xmlToMap(xml);
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println("key: "+s+"   " +"value: "+map.get(s));
        }
        System.out.println("==================");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println("key: "+next.getKey()+"   " +"value: "+next.getValue());
        }
        System.out.println("==================");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println("key : "+entry.getKey() +"value "+entry.getValue());
        }
        System.out.println("==================");
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
    }


}
