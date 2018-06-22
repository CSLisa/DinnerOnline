package exmvc.action.impl;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.OrderAction;
import exmvc.entity.impl.Cart;
import exmvc.entity.impl.OrderDetails;
import exmvc.entity.impl.Orders;
import exmvc.service.CartService;
import exmvc.service.OrderDetailsService;
import exmvc.service.OrderService;
import springmvc.action.impl.SpringMVCActionImpl;

@Controller
@RequestMapping("/orders")
public class OrderActionImpl extends SpringMVCActionImpl implements OrderAction{
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	
	@RequestMapping("/findAll")
	public String findAll() throws Exception {
		Orders condition = RequestUtil.requestToBean(request, Orders.class);
		Page<Orders> page = RequestUtil.requestToBean(request, Page.class);
		List<Orders> list = orderService.findAll(condition);
		page.setDataList(list);
		request.setAttribute("page", page);
		return "user_orderlist";
	}

	@Override
	public String findByPaging() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 购物车转向订单添加
	 * 
	 * 添加订单，同时添加订单详情和删除购物车
	 */
	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		String[] dishesId=request.getParameterValues("newslist");
		String redirect;
		if (dishesId!=null&&dishesId.length>0&&dishesId[0]!=null&&!dishesId[0].trim().equals("")) {
			
			//生成订单号
			Calendar  date = Calendar.getInstance();   
			date.get(Calendar.HOUR_OF_DAY);
			String df = new SimpleDateFormat("yyyyMMddHHmmss").format(date.getTime());
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
			String id=df+"001";
			
			//保存订单 
			Orders orders=new Orders(id, "", "", "", time, "未支付", "");
			
			
			double totalPrice=0;
			
			//从购物车转订单详情
			for (int i = 0; i < dishesId.length; i++) {
				System.out.println(dishesId[i]);
				Cart cart=new Cart();
				cart.setId(dishesId[i]);
				cart=cartService.findById(cart);
				
				double quantity= Double.valueOf(cart.getQuantity()).doubleValue();
				double price= Double.valueOf(cart.getPrice()).doubleValue();
				totalPrice+=quantity*price;
				
				OrderDetails orderDetails=new OrderDetails();
				orderDetails.setId(""+id);
				orderDetails.setName(""+cart.getName());
				orderDetails.setPrice(""+cart.getPrice());
				orderDetails.setQuantity(""+cart.getQuantity());
				orderDetails.setSubtotal(""+(quantity*price));
				orderDetails.setStatus("");
				int resul=orderDetailsService.add(orderDetails);
				if (resul>0) {
					cartService.delete(cart);
				}
			}
			
			
			//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

			orders.setAmount(""+totalPrice);
			int result=0;
			result=orderService.add(orders);
			if (result>0) {
				//response.sendRedirect(basePath+"/lists/findAll.do?p2_Order="+orders.getId());
				redirect="redirect:/orderDetails/findAll.do?p2_Order="+orders.getId();
			}else {
				redirect="redirect:/ErrorMessage.jsp";
			}
		}else {
			message("请选择结算的商品", "back");
			redirect="message";
		}

		return redirect;
	}

	@Override
	public String doAdd() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toUpdate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * 支付成功修改订单状态
	 * 转发到支付成功页面
	 */
	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		
		Orders condition = RequestUtil.requestToBean(request, Orders.class);
		Orders orders=orderService.findById(condition);
		if (orders!=null) {
			//需要支付返回为order
			//应有密钥加解密(略)
			orders.setStatus1(condition.getStatus1());
			orderService.update(orders);
			request.setAttribute("orders", orders);
			//通知后厨
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			URL url = new URL(basePath);
		    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		    httpURLConnection.setDoInput(true);
		    httpURLConnection.setDoOutput(true);        // 设置该连接是可以输出的
		    httpURLConnection.setRequestMethod("POST"); // 设置请求方式
		    httpURLConnection.setRequestProperty("charset", "utf-8");

		    PrintWriter pw = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));
		    pw.write("name=welcome");                   // 向连接中输出数据（相当于发送数据给服务器）
		    pw.write("&age=14");
		    pw.flush();
		    pw.close();
		}
		return "paySuccess";
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
