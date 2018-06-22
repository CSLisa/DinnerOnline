package com.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			
			String methodName =req.getParameter("method")==null?"table"
					:req.getParameter("method");
			// 得到当前操作类字节码
			Class clazz = this.getClass();
			//拿到当前类的方法
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class );
			// 让当前类执行该方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

