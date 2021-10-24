package org.legend.servlet;

import org.legend.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 总结：三者执行的顺序
一、当客户端发送请求：比如在游览器（提交表单）
二、服务器会接收到信息， 通过表单的action="定位servlet地址"  找到servlet
三、然后默认会去找：public修饰的service()方法：
	1、当重写了(父类)HttpServlet的public修饰的service方法时：
			只执行（重写的service方法的内容）
			
    2、当(没有)重写了(父类)HttpServlet的public修饰的service方法时:
    	会自动调用HttpServlet中的service()方法, 这个方法最终会调用：HttpServlert中的
    	protected service(HttpServletRequest req, HttpServletResponse resp)方法，
        进而会依次找doGet()、doPost()方法	
四、当提交表单时
	1、若使用get方式提交， 若没有重写doGet()方法， 那么会报错。
	2、若使用post方式提交，若没有重写doPost()方法，那么也会报错。

五、所以很多（老师）推荐：
		1、不去重写（父类public修饰的）service（）方法,直接写doGet()、doPost()方法。
		2、因为（不重写）public修饰的service()方法，
				会（先调用）（HttpService抽象类的) public的service()方法
				(在调用)其protected 修饰的 service()方法。	
 *
 */

public class QueryStudentByIdServlet extends HttpServlet {
    private static final long serialVersionUID = -2011846173471546715L;
    private IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void init() throws ServletException {
//        super.init();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        studentService = (IStudentService) ac.getBean("stuService");
    }

    public QueryStudentByIdServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
//        IStudentService stuService = new IStudentServiceImpl();
        String name = studentService.Query();
        System.out.println("名字：" + name);
        req.setAttribute("name", name);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
