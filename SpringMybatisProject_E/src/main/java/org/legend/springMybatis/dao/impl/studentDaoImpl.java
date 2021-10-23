package org.legend.springMybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.legend.springMybatis.entity.Student;
import org.legend.springMybatis.mapper.StudentMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * studentDaoImpl实现接口中完成SqlSession的创建
 * @author Administrator
 *
 */
public class studentDaoImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public void addStudent(Student student) {
		/*
		 * 2.studentDaoImpl继承SqlSessionDaoSupport;
		 * 让studentDaoImpl具有sqlSessionFactory属性(在bean中完成属性值注入); 
		 * 从而能创建SqlSession对象
		 */
        SqlSession session = super.getSqlSession();
        StudentMapper stuDao = session.getMapper(StudentMapper.class);
        stuDao.addStudent(student);//接口映射会根据映射文件中sql自动实现接口方法
    }
}
