package common.util.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.BaseAction;

public abstract class BaseActionImpl<T> implements BaseAction<T> {
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	public BaseActionImpl(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public void message(String msg,String url) throws ServletException, IOException {
		request.setAttribute("message", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
