package org.legend.entity;

public class Teacher {
    private String name;
    private int age;

    //非构造方法注入时起作用
    public Teacher() {
    }

    /*
            4.无论是String还是Int/short/long...（8个基本类型+String），在赋值时都是value="值"
            因此建议此种情况需要配合name/type进行区分
         */
    public Teacher(String name) {//区别属性类型
        this.name = name;
    }

    public Teacher(int age) {//区别属性类型
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
