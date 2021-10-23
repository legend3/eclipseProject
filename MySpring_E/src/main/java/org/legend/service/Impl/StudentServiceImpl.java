package org.legend.service.Impl;

import org.legend.dao.IStudentDao;
import org.legend.entity.Student;
import org.legend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * <bean id="studentDao" class="org.legend.dao.impl.StudentDaoImpl">
 *  <property name="studentDao" ref="studentDao"></property>
 * </bean>
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired//自动装配， byType
    @Qualifier("studentDao")//byName(byId),要与@Autowired一起连用，类似byName；也类似类似@Resource(name="studentDao")
    IStudentDao studentDao;//交给spring来new

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }
    /**
     * --课程五
     * 声明事务:声明后，保证addsStudent方法要么全成功，要么全失败
     * readOnly: 只读，= false完全能增删改查操作
     * REQUIRED 是常用的事务传播行为，如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中
     * rollbackFor：根据异常类型回滚
     * rollbackForClassName: 根据异常名称回滚{'SQLException', 'ArithmeticException'}
     * isolation:事务的隔离级别；READ_COMMITTED：提交后才能查看，防"脏读".
     */
    @Transactional(
                    readOnly = false,
                    propagation = Propagation.REQUIRED,
                    rollbackFor = {SQLException.class, ArithmeticException.class})//,
//                  isolation = Isolation.READ_COMMITTED)
    @Override
    public void addStudent(Student student) {
        //if(该学生是否存在)
        //增加其他....
//        studentDao = null;//测试aop异常通知时用
        int[] nums = new int[2];//越界异常
        nums[1] = 2;//下标没有2，只有0，1
        studentDao.addStudent(student);
    }

    @Override
    public String deleteStudentByName(String stuName) {
        System.out.println("删除学生");
        int[] nums = new int[2];//越界异常
        nums[1] = 2;//下标没有2，只有0，1
        return stuName;
    }
}
