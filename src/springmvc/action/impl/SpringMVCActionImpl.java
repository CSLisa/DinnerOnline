package springmvc.action.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller(value="springMVCActionImpl")
//@Aspect
public class SpringMVCActionImpl {
	@Autowired  
	protected  HttpServletRequest request;
	@Autowired  
	protected  HttpSession session;
	@Autowired  
	protected  HttpServletResponse response;
	//@Before(value="execution(* execution(* exmvc.service.impl.DeptServiceImpl.*(..))")
	protected void setModuleActionName(){
	  	  String uri=request.getRequestURI();  
	  	  System.out.println(uri);
	  	  String[] action=uri.substring(uri.indexOf("/",1)+1,uri.indexOf(".")).split("/");
	  	  
	  	  //保存到session中，以后使用
	  	   session.setAttribute("action", action);
	  	   //System.out.println(Arrays.deepToString(array));
	}
	
	//message
	public void message(String msg,String url) throws ServletException, IOException {
		request.setAttribute("message", msg);
		request.setAttribute("url", url);
	}
}
