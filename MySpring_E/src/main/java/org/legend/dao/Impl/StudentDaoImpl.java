package org.legend.dao.Impl;

import org.legend.dao.IStudentDao;
import org.legend.entity.Student;
import org.springframework.stereotype.Repository;

/*
 * <bean id="studentDao" class="org.legend.dao.impl.StudentDaoImpl"></bean>
 */
@Repository("studentDao")
public class StudentDaoImpl implements IStudentDao{

    @Override
    public void addStudent(Student student) {
        System.out.println("增加学生:" + student.getStuName());
    }
}
