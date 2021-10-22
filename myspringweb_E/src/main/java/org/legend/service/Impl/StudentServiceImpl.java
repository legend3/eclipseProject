package org.legend.service.Impl;

import org.legend.dao.IStudentDao;
import org.legend.dao.Impl.StudentDaoImpl;
import org.legend.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
    IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String queryStudentById() {
        return studentDao.queryStudentbyId();
    }
}
