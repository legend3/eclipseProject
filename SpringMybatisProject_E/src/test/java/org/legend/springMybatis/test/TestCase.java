package org.legend.springMybatis.test;


import org.legend.springMybatis.entity.Student;
import org.legend.springMybatis.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestCase {
	@Test
    public void case01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService = (IStudentService)context.getBean("studentService") ;
        Student student = new Student();
        student.setStuAge(36);
        student.setStuName("仓颉"-女);
        student.setStuNo(6);
        studentService.addStudent(student);

    }
}
