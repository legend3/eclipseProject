package org.legend.springMybatis.service.impl;


import org.legend.springMybatis.entity.Student;
import org.legend.springMybatis.mapper.StudentMapper;
import org.legend.springMybatis.service.IStudentService;

public class studentServiceImpl implements IStudentService {
    private StudentMapper studentMapper ;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public void addStudent(Student student) {
        //调用Dao层
        studentMapper.addStudent(student);
    }
}
