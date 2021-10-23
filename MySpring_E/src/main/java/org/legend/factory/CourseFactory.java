package org.legend.factory;

import org.legend.newInstance.HtmlCourse;
import org.legend.newInstance.ICourse;
import org.legend.newInstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseFactory {
   //根据名称获取课程
    public static ICourse getCourse(String name) {
        //获取ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        if(name.equals("java")) {
            return (ICourse) context.getBean("javaCourse");
        }else {
            return (ICourse) context.getBean("htmlCourse");
        }
    }
}
