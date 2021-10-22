package org.legend.springMybatis.mapper;

import org.legend.springMybatis.entity.Student;

/**
 * 本来是IStudentDao，为了和mybatis更加紧密改名字为StudentMapper，放入和mapper文件放一起
 */
public interface StudentMapper {
    void addStudent(Student student);
}
