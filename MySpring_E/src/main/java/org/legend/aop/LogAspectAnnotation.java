package org.legend.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * AOP注解实现方式
 */
@Component("logAspectAnnotation")
@Aspect//声明该类时一个通知
public class LogAspectAnnotation {
    //前置通知
    @Before("execution(public void org.legend.service.Impl.StudentServiceImpl.addStudent(..))")//属性：定义切点(在哪之前被执行)
    public void myBefore(JoinPoint jp) {
        System.out.println("注释-前置通知:" + "\n目标对象（切点）：" + jp.getTarget()
                            + "\n目标对象的方法：" + jp.getSignature().getName() + "\n参数：" + Arrays.toString(jp.getArgs()));
    }
    //后置通知
    @AfterReturning(returning="returningValue",//有返回值时，需要声明returning=
            pointcut="execution(public String org.legend.service.Impl.StudentServiceImpl.deleteStudentByName(..))")
    public void myAfter(JoinPoint jp, Object returningValue) {//1.JoinPoint必须放在第一位！ 2.注解形式实现aop时，通知的方法的参数不能多或少(与@AfterReturning中声明固定！)
        System.out.println("注释-后置通知:"  + "\n目标对象（切点）：" + jp.getTarget()
                + "\n目标对象的方法：" + jp.getSignature().getName() + "\n参数：" + Arrays.toString(jp.getArgs())
                + "\n返回值：" + returningValue);
    }
    //环绕通知
    @Around("execution(public void org.legend.service.Impl.StudentServiceImpl.addStudent(..))")
    public void myAround(ProceedingJoinPoint jp) {
        //前置通知
        System.out.println("注解-环绕前置通知："  + "\n目标对象（切点）：" + jp.getTarget()
                + "\n目标对象的方法：" + jp.getSignature().getName() + "\n参数：" + Arrays.toString(jp.getArgs()));
        try {
            //方法执行时
            jp.proceed();//1.抛出Throwable异常
            //后置通知
            System.out.println("注解-环绕后置通知："  + "\n目标对象（切点）：" + jp.getTarget()
                    + "\n目标对象的方法：" + jp.getSignature().getName() + "\n参数：" + Arrays.toString(jp.getArgs()));
        }catch(Throwable e) {//2.索性在此捕获Throwable异常
            //异常通知
            System.out.println("注解-环绕异常：" + e);
        }finally {
            //最终通知
            System.out.println("注解-环绕最终通知");
        }
    }
    //异常通知:如果只捕获特定类型的已存异常，则可以通过第二个参数实现：e
    @AfterThrowing(pointcut="execution(public void org.legend.service.Impl.StudentServiceImpl.addStudent(..))", throwing="e")
    public void myException(JoinPoint jp, ArrayIndexOutOfBoundsException e) {//只捕获指定的异常
        System.out.println("注解-异常通知：" + e.getMessage());
    }
    //最终通知
    @After("execution(public void org.legend.service.Impl.StudentServiceImpl.addStudent(..))")
    public void myAfter() {
        System.out.println("注解-最终通知");
    }
//
}
