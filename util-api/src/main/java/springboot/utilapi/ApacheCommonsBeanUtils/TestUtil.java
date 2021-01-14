package springboot.utilapi.ApacheCommonsBeanUtils;

import org.apache.commons.beanutils.BeanUtils;
import springboot.utilapi.ApacheCommonsBeanUtils.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:TestUtil
 * Package:springboot.utilapi.ApacheCommonsBeanUtils
 * Description:
 *
 * @date:2021/1/14 17:41
 * @author:zh
 */
public class TestUtil {
    public static void main(String[] args) throws Exception {
        User user = new User();
        //设置对象属性功能
        BeanUtils.setProperty(user, "name", "张煌");
        BeanUtils.setProperty(user, "age",18);
        System.out.println(user.toString());
        //bean转map  属性 为key  属性值为value
        Map<String, String> map = BeanUtils.describe(user);

        //map转bean  key必须对应上属性值
        HashMap hashMap = new HashMap();
        hashMap.put("name", "谢喆");
        hashMap.put("age", 20);
        User user1 = new User();
        BeanUtils.populate(user1,hashMap);
        System.out.println(user1.toString());

        //克隆对象
        User o = (User)BeanUtils.cloneBean(user);
        System.out.println(o.getAge());



    }
}
