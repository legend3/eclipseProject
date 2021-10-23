package org.legend.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("logSchema")
public class LogSchema {
    //Schema前置通知
    public void before(JoinPoint pj) {//不实现接口，而是在spring容器文件中配置<aop:aspect ref="logSchema">
        System.out.println("Shema-前置通知："  + "\n目标对象（切点）：" + pj.getTarget()
                + "\n目标对象的方法：" + pj.getSignature().getName() + "\n参数：" + Arrays.toString(pj.getArgs()));
    }
    //Schema后置通知:JoinPoint适用于注解、schema两种形式！
    public void afterReturning(JoinPoint pj, Object returningValue){
        System.out.println("Shema-后置通知：" + "\n目标对象（切点）：" + pj.getTarget()
                + "\n目标对象的方法：" + pj.getSignature().getName() + "\n参数：" + Arrays.toString(pj.getArgs())
                + "\n返回值：" + returningValue);
    }
    //Schema异常通知
    public void whenException(JoinPoint pj, ArrayIndexOutOfBoundsException e) {
        System.out.println("Shema-方法：" + pj.getTarget() + "的异常通知：" + e.getMessage());
    }
    //注意：环绕通知 会返回目标方法的返回值，因此返回值为Object
    public Object around(ProceedingJoinPoint pj) {
        //前置通知
        System.out.println("Shcema-环绕前置通知");
        Object result = null;
        try {
            //执行方法
             result = pj.proceed();
            //后置通知
            System.out.println("Shcema-环绕后置通知："  + "\n目标对象（切点）：" + pj.getTarget()
                    + "\n目标对象的方法：" + pj.getSignature().getName() + "\n参数：" + Arrays.toString(pj.getArgs()));
        }catch (Throwable e) {
            //异常通知
            System.out.println("Shcema-环绕异常通知：" + e);
        }finally {
            //最终通知
            System.out.println("Schema-环绕最终通知");
        }
        return result;
    }
}
