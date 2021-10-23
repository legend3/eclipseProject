package org.legend.entity;

import org.legend.factory.CourseFactory;
import org.legend.newInstance.HtmlCourse;
import org.legend.newInstance.ICourse;
import org.legend.newInstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
    private int stuNo;
    private String stuName;
    private int stuAge;

    public int getStuNo() {
        return stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    //学习Java课程
    public void learnJava(){
        ICourse course = new JavaCourse();
        course.learn();
    }
    public void learnHtml(){
        ICourse course = new HtmlCourse();
        course.learn();
    }

    public void learnCourse(String name) {
//        ICourse course = CourseFactory.getCourse(name);//通过工厂获取(learnCourseWithFactory)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICourse course = (ICourse) context.getBean(name);//拿(learnCourseWithIoc)
        course.learn();
    }

}
