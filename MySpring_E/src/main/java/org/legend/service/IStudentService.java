package org.legend.service;

import org.legend.entity.Student;

/**
 * Service，业务逻辑层存在的意义：
 * 在数据库访问层定义了对于数据库最基本的CURD操作，比如查询一个用户信息，比如：find（） insert（） update（） delete（），功能比较单一，显然这样方法不能完成一些比较复杂的操作， 那么这些方法可以在业务逻辑层去组合成一些复杂的功能。这样就可以使dao层方法的复用性大大增强
 */
public interface IStudentService {
    void addStudent(Student student);
    String deleteStudentByName(String stuName);
}
