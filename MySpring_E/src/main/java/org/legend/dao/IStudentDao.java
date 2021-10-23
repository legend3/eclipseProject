package org.legend.dao;

import org.legend.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * 增加接口
 */
public interface IStudentDao {
    public void addStudent(Student student);
}
