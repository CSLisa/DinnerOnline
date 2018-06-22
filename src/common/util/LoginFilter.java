package common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 登录验证过滤器类
 * @author ZHQL
 */
@WebFilter({"*.do","*.*"})
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
		/*HttpSession session = req.getSession();
		if(uri.endsWith("login.jsp")
		 ||uri.endsWith("register.jsp")
		 ||uri.endsWith("sys_login.do")
		 ||uri.endsWith("sys_register.do")
		 ||uri.endsWith("sys_logout.do")
		 ||uri.endsWith(req.getContextPath()+"/")
		 ){
			fc.doFilter(request, response);//特殊资源，不登录也可以访问
		}else if(session.getAttribute("users")!=null){
			fc.doFilter(request, response);//放行
		}else{
			System.out.println("被拦截的路径:" + uri);
			request.setAttribute("msg","你未登录，没有操作权限");
			//请求转发
			req.getRequestDispatcher("/users/login.jsp")
			.forward(req, resp);
		}		*/
		
		HttpSession session = req.getSession();
		if(uri.endsWith("cart.jsp")
		 ||uri.endsWith("confirm_order.jsp")
		 ||uri.endsWith("reserver.do")
		 ||uri.endsWith(req.getContextPath()+"/")
		 &&(session.getAttribute("users")==null)
		 ){
			System.out.println("被拦截的路径:" + uri);
			request.setAttribute("msg","你未登录，没有操作权限");
			//请求转发
			req.getRequestDispatcher("/users/login.jsp")
			.forward(req, resp);
		}else{
			fc.doFilter(request, response);//特殊资源，不登录也可以访问
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	@Override
	public void destroy() {

	}
}
