package org.legend.dao.Impl;

import org.legend.dao.IStudentDao;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public String queryStudentbyId() {
        //模拟通过JDBC查询数据
        System.out.println("1 legend 23");
        return "legend";
    }
}
