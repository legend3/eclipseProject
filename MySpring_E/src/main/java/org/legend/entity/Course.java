package org.legend.entity;

public class Course {
    private String courseName;
    private int courseHour;
    private Teacher teacher;//授课老师，依赖于Teacher

    //3.不是构造方法注入时起作用,容器创建bean时都需要无参构造器！
    public Course() {
    }

    public Course(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course(String courseName, int courseHour, Teacher teacher) {
        this.courseName = courseName;
        this.courseHour = courseHour;
        this.teacher = teacher;
    }

    public void setCourseName(String courseName) {
//        System.out.println("setCourseName......");//验证set方式注入是否调用了set方法
        this.courseName = courseName;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void showInfo() {
        System.out.println(this.getCourseName() + "," + this.getCourseHour() + "," + this.getTeacher().getName());
    }
}
