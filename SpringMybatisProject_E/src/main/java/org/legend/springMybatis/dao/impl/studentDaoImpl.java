package org.legend.springMybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.legend.springMybatis.entity.Student;
import org.legend.springMybatis.mapper.StudentMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class studentDaoImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public void addStudent(Student student) {
        SqlSession session = super.getSqlSession();
        StudentMapper stuDao = session.getMapper(StudentMapper.class);
        stuDao.addStudent(student);
    }
}
