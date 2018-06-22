package com.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.po.User;
import com.utils.CodeUtils;

@WebServlet("/page/login/userAction.action")
public class UserAction extends BasicAction {
	private UserDao userDao = new UserDaoImpl();
	public void getCode(HttpServletRequest req,HttpServletResponse resp){
		CodeUtils.getCodeWirter(req, resp);
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//��ȡ�ͻ��������֤��
			String code = req.getParameter("code");
			//��÷������������֤��
			String code2 = (String)req.getSession().getAttribute("code");
			if(code.equalsIgnoreCase(code2)){
				//��֤����ȷ����
				String username = req.getParameter("username");
				String userpwd = req.getParameter("userpwd");
				User user = userDao.findUserByUsernameAndUserpwd(username,userpwd);
				//�û���������ȷ��¼�ɹ�
				if(user!=null){
				 // ����session
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(30);
				//����cookie
//					Cookie cookie = new Cookie("username",username);
//					Cookie cookie2 = new Cookie("userpwd",userpwd);
					resp.sendRedirect("index.jsp");
				// ��¼ʧ�ܴ���	
				} else {
					req.setAttribute("error2", "�û��������������");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				
			} else {
				//��֤�����
				req.setAttribute("error", "��֤�����");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void exit(HttpServletRequest req,HttpServletResponse resp){
		//��ȫ�˳�
		try {
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
