package org.legend.aop;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 截取调用一个接口上的目标。. 这些嵌套的“上面”的目标。
 * 用户应该实现invoke(MethodInvocation)方法来修改原来的行为,下面的类实现了一个跟踪拦截器(跟踪了所有调用拦截方法)
 */

@Component("logAround")
public class LogAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try{
            //方法体1
            System.out.println("环绕-前置通知...");
//            System.out.println("method "+invocation.getMethod()+" is called on "+
//                    invocation.getThis()+" with args "+invocation.getArguments());
            //方法体2
            result = invocation.proceed();//控制着执行点(目标方法)的执行 addStudent()被调用,result为返回的结果
            //方法3
            System.out.println("环绕-后置通知...");
            System.out.println("目标对象：" + invocation.getThis() + "\n目标方法：" + invocation.getMethod() +
                    "\n目标方法参数的个数：" + invocation.getArguments().length
                    + "\n目标方法的返回值：" + result);//此时的result还是与addStudent(Student student)一致！
        }catch (Exception e) {
            System.out.println("环绕-异常通知");
            System.out.println("method "+invocation.getMethod()+" is called on "+
                    invocation.getThis()+" with args "+invocation.getArguments());
        }
        return result;//如果换成return "abc"，则会影响(原始的-logAfter)后置通知的返回结果("挑梁欢呼",迷惑了后置通知)；
                    //获取目标方法的全部控制权(影响前置、后置、异常...)！ 因此一般返回什么就return 什么
    }
}
