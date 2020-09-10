package com.springboot.aop.service;

import com.springboot.aop.bean.InputBean;
import com.springboot.aop.bean.OutPutBean;
import org.springframework.stereotype.Service;

/**
 * ClassName:AopService
 * Package:com.springboot.aop.service
 * Description:
 *
 * @date:2020/8/26 16:47
 * @author:zh
 */
@Service
public class AopTestService {
    public OutPutBean result(InputBean bean) {
        OutPutBean outPutBean = new OutPutBean();
        outPutBean.setName(bean.getName());
        outPutBean.setMessage("没有涉及到aop");
        return outPutBean;
    }
}
