package exmvc.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.util.impl.JumpUtil;
import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.OrderDetailsAction;
import exmvc.entity.impl.Cart;
import exmvc.entity.impl.OrderDetails;
import exmvc.entity.impl.Orders;
import exmvc.service.OrderDetailsService;
import exmvc.service.OrderService;
import springmvc.action.impl.SpringMVCActionImpl;
@Controller(value="orderDetailsAction")
@RequestMapping("/orderDetails")
public class OrderDetailsActionImpl extends SpringMVCActionImpl implements OrderDetailsAction{
	@Autowired
	private OrderDetailsService orderDetailsService;
	@Autowired
	private OrderService orderService;
	
	
	/*
	 * 查询订单详情
	 */
	@Override
	@RequestMapping("/findAll")
	public String findAll() throws Exception {
		//Cart cart=RequestUtil.requestToBean(request, Cart.class);
		OrderDetails orderDetails=new OrderDetails(request.getParameter("p2_Order"));
		List<OrderDetails> cartList=orderDetailsService.findAll(orderDetails);
		Orders orders=orderService.findById(new Orders(orderDetails.getId()));
		//将List转为json数据
		//String string=JSON.toJSONString(cartList, true).toString();
	    //return string;
		request.setAttribute("lists", cartList);
		request.setAttribute("orders", orders);
		return "confirm_order";
	}

	@RequestMapping("/findByPaging")
	public String findByPaging() throws Exception {
		OrderDetails condtion=RequestUtil.requestToBean(request, OrderDetails.class);
		Page<OrderDetails> page=RequestUtil.requestToBean(request, Page.class);
		List<OrderDetails> list=orderDetailsService.findByPaging(page, condtion);
		setModuleActionName();
		page.setDataList(list);
		request.setAttribute("condtion", condtion);
		request.setAttribute("page", page);
		//request.getRequestDispatcher("/orderDetails/list.jsp").forward(request, response);
		return "orderDetails/confirm_order";
	}

	@RequestMapping("/findById")
	public String findById() throws Exception {
		OrderDetails condtion=RequestUtil.requestToBean(request, OrderDetails.class);
		Page<OrderDetails> page=RequestUtil.requestToBean(request, Page.class);
		setModuleActionName();
		List<OrderDetails> list=orderDetailsService.findAll(condtion);
		page.setDataList(list);
		request.setAttribute("condtion",condtion);
		request.setAttribute("page", page);
		//request.getRequestDispatcher("/orderDetails/list.jsp").forward(request, response);
		return "orderDetails/confirm_order";
	}
	
	
	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		setModuleActionName();
		//request.getRequestDispatcher("/orderDetails/toAdd.jsp").forward(request, response);
		return "orderDetails/toAdd";
	}

	@RequestMapping("/doAdd")
	public String doAdd() throws Exception {
		OrderDetails  condition=RequestUtil.requestToBean(request, OrderDetails.class);
		Page<OrderDetails > page=RequestUtil.requestToBean(request, Page.class);
		setModuleActionName();
		int rows=orderDetailsService.add(condition);
		if (rows>0) {
			JumpUtil.jsJump("jump", request, response, "添加成功","dept/findAll.st");
		}else {
			session.setAttribute("entity",condition);
			JumpUtil.jsJump("jump", request, response, "添加失败","/dept/toAdd.st");
		}
		request.setAttribute("rows", rows);
		//request.getRequestDispatcher("/orderDetails/doAdd.jsp").forward(request, response);
		//返回
		return "orderDetails/doAdd";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate() throws Exception {
		//变量声明及初始化赋值
		OrderDetails orderDetails = RequestUtil.requestToBean(request, OrderDetails.class);
		setModuleActionName();
		//查询OrderDetails orderDetails,将OrderDetails OrderDetails保存到request,
		orderDetails=orderDetailsService.findById(orderDetails);
		request.setAttribute("entity", orderDetails);
		//重定向跳转到list.jsp中
		//request.getRequestDispatcher("/dept/update.jsp").forward(request, response);
	   return "orderDetails/update";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		OrderDetails condition=RequestUtil.requestToBean(request,OrderDetails.class);
		setModuleActionName();
		int rows = orderDetailsService.update(condition);
		if(rows>0) 
	    	 JumpUtil.jsJump("jump",request, response, "修改成功", "orderDetails/findAll.st");
	     else{
	    	
	    	 JumpUtil.jsJump("jump",request, response, "修改失败", "orderDetails/toUpdate.st?id="+condition.getId());
	     }
		return null;
	}

	@RequestMapping("/delete")
	public String delete() throws Exception {
		OrderDetails condition=RequestUtil.requestToBean(request,OrderDetails.class);
		setModuleActionName();
		int rows = orderDetailsService.delete(condition);
		if(rows>0) 
	    	 JumpUtil.jsJump("jump",request, response, "删除成功", "orderDetails/findAll.st");
	     else{
	    	 JumpUtil.jsJump("jump",request, response, "删除失败", "orderDetails/delete.st?id="+condition.getId());
	     }
		request.setAttribute("rows", rows);
		return "orderDetails/delete";
	}

	public OrderDetailsService getOrderDetailsService() {
		return orderDetailsService;
	}

	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

}
