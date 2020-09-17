package com.springboot.aop.aop;

import com.springboot.aop.bean.InputBean;
import com.springboot.aop.bean.OutPutBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ClassName:AopService
 * Package:com.springboot.aop.aop
 * Description:
 *
 * @date:2020/8/26 16:46
 * @author:zh
 */
@Aspect
@Component
public class AopService {

    @Pointcut("execution(* com.springboot.aop.controller..*.*(..))")
    public void pointCut() {}


    @Before("pointCut()") //前进入一次
    public void before(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if(arg instanceof InputBean){
                InputBean bean = (InputBean) arg;
                bean.setName("赵辅明");
            }
        }
        System.out.println("before 能修改参数吗?");
    }

    @AfterReturning(value = "pointCut()",returning = "keys") //后进入一次
    public void doAfterReturning(JoinPoint joinPoint,Object keys){
        if(keys instanceof OutPutBean){
            OutPutBean bean = (OutPutBean) keys;
            bean.setMessage("我是一个aop");
        }
    }

    //@Around("pointCut()") 前后各进入一次
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if(arg instanceof InputBean){
                InputBean bean = (InputBean) arg;
                bean.setName("谢喆");
            }
        }
        Object proceed = joinPoint.proceed();
        if(proceed instanceof  OutPutBean){
            OutPutBean putBean = (OutPutBean) proceed;
            putBean.setMessage(putBean.getName()+"我用了aop了");
        }
        return proceed;
    }
}
