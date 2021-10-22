# Spring - MyBatis

>思路：  
SqlSessionFactory -> SqlSession ->StudentMapper ->CRUD  
可以发现 ，MyBatis最终是通过SqlSessionFactory来操作数据库，  
Spring整合MyBatis 其实就是 将MyBatis的SqlSessionFactory 交给Spring  

## SM整合步骤：
1. jar包  
mybatis-spring.jar	spring-tx.jar	spring-jdbc.jar		spring-expression.jar
spring-context-support.jar	spring-core.jar		spring-context.jar
spring-beans.jar	spring-aop.jar	spring-web.jar	commons-logging.jar
commons-dbcp.jar	ojdbc.jar	mybatis.jar	log4j.jar	commons-pool.jar

2. 类-表
student.class
student表

3. MyBatis配置文件conf.xml

4. 通过mapper.xml将 类、表建立映射关系

5. 之前使用MyBatis:  conf.xml ->SqlSessionFacotry  
现在整合的时候，需要通过Spring管理SqlSessionFacotry ，因此 产生qlSessionFacotry 所需要的数据库信息 不在放入conf.xml  而需要放入spring配置文件中  
配置Spring配置文件（applicationContext.xml）  

6. 使用Spring-MyBatis整合产物开发程序  
目标：通过spring产生mybatis最终操作需要的 动态mapper对象(StudentMapper对象)
Spring产生 动态mapper对象 有3种方法：

- a.第一种方式  
DAO层实现类  继承 SqlSessionDaoSupport类

         SqlSessionDaoSupport类提供了一个属性 SqlSession


- b.第二种方式  
就是省略掉 第一种方式的 实现类  
直接MyBatis提供的 Mapper实现类：org.mybatis.spring.mapper.MapperFactoryBean  
缺点：每个mapper都需要一个配置一次

- c.第三种方式

    批量配置 实现类





















