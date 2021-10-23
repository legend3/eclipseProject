package org.legend.aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("logException")
public class LogException implements ThrowsAdvice {
    //异常通知的具体方法(一定要public！)
    public void afterThrowing(Method method, Object[] args, Object target, Throwable ex) {
        System.out.println("异常通知的目标对象：" + target + "  异常通知的目标对象的方法：" + method + "   异常通知的目标对象的方法的参数：" + args + "    异常通知的抛出异常：" + ex);
    }
}
