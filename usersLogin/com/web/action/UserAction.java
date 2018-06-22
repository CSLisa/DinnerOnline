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
			//获取客户输入的验证码
			String code = req.getParameter("code");
			//获得服务器随机的验证码
			String code2 = (String)req.getSession().getAttribute("code");
			if(code.equalsIgnoreCase(code2)){
				//验证码正确继续
				String username = req.getParameter("username");
				String userpwd = req.getParameter("userpwd");
				User user = userDao.findUserByUsernameAndUserpwd(username,userpwd);
				//用户名密码正确登录成功
				if(user!=null){
				 // 处理session
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(30);
				//处理cookie
//					Cookie cookie = new Cookie("username",username);
//					Cookie cookie2 = new Cookie("userpwd",userpwd);
					resp.sendRedirect("index.jsp");
				// 登录失败处理	
				} else {
					req.setAttribute("error2", "用户名或者密码错误");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				
			} else {
				//验证码错误
				req.setAttribute("error", "验证码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void exit(HttpServletRequest req,HttpServletResponse resp){
		//安全退出
		try {
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
