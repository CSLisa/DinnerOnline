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
			// �õ���ǰ�������ֽ���
			Class clazz = this.getClass();
			//�õ���ǰ��ķ���
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class );
			// �õ�ǰ��ִ�и÷���
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

