package com.springboot.aop.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * ClassName:Job
 * Package:com.springboot.aop.job
 * Description:
 *
 * @date:2020/9/10 17:55
 * @author:zh
 */
@Component
public class Job {

    @XxlJob("demoJobHandler")
    public ReturnT<String> execute(String param) {
        XxlJobLogger.log("hello world.");
        return ReturnT.SUCCESS;
    }
}
