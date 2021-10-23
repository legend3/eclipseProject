package org.legend.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

//普通类->前置通知
@Component("logBefore")
public class LogBefore implements MethodBeforeAdvice {//继承前置通知接口
    //前置通知
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("*****前置通知*******");
    }
}

