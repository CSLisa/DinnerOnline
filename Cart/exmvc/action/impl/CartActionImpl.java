package exmvc.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.CartAction;
import exmvc.entity.impl.Cart;
import exmvc.entity.impl.Dishes;
import exmvc.service.CartService;
import exmvc.service.DishesService;
import springmvc.action.impl.SpringMVCActionImpl;
@Controller
@RequestMapping("/cartAndPay/cart")
public class CartActionImpl extends SpringMVCActionImpl implements CartAction{
	@Autowired
	CartService cartService;
	@Autowired
	DishesService dishesService;
	public CartService getCartService(){
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	/*
	 * 查询购物车信息
	 */
	@SuppressWarnings("unused")
	@Override
	@RequestMapping("findAll")
	@ResponseBody
	public String findAll() throws Exception {
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		List<Cart> shoppingCartList=cartService.findAll(null);
		//将List转为json数据
		String string=JSON.toJSONString(shoppingCartList, true).toString();
	    return string;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String findByPaging() throws Exception {
		setModuleActionName();
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		Page<Cart> page=new Page<Cart>();
		page=RequestUtil.requestToBean(request, Page.class);
		
		String currentPage=request.getParameter("currentPage");
		//System.out.println(currentPage);
		//System.out.println(page.toString());
		
		List<Cart> cartList=cartService.findByPaging(page, cart);
		List<Cart> cartList2=cartService.findAll(null);
		for(Cart cart2 : cartList){
			for(Cart cart3 : cartList2){
				if(cart2.getOriginalPrice().equals(cart3.getId())){
					cart2.setOriginalPrice(cart3.getName());
					break;
				}
			}
		}
		request.setAttribute("page",page);
		request.setAttribute("cart", cart);
		//System.out.println(page.toString());
		//request.getRequestDispatcher("/company/list.jsp").forward(request, response);
		
		return "dishes/list";
	}

	@Override
	@RequestMapping("/findById")
	public String findById() throws Exception {
		setModuleActionName();
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		int quantity2=Integer.valueOf(cart.getQuantity()).intValue();
		Cart shoppingCart2=cartService.findById(cart);
		int result=0;
		if (shoppingCart2!=null&&!shoppingCart2.getId().trim().equals("")) {
			int quantity=Integer.valueOf(shoppingCart2.getQuantity()).intValue();
			
			quantity+=quantity2;
			shoppingCart2.setQuantity(""+quantity);
			result=cartService.update(shoppingCart2);
		}else {
			Dishes dishes=dishesService.findById(new Dishes(cart.getId()));
			cart.setName(dishes.getName());
			cart.setPrice(dishes.getPrice());
			cart.setOriginalPrice(dishes.getSalesPrice());
			cart.setQuantity(""+quantity2);
			result=cartService.add(cart);
			
		}
		String redirect;
		if (result>0) {
			//message("添加成功", "/cart.jsp");
			redirect="redirect:/cartAndPay/cart.jsp";
		}else {
			//message("添加失败", "back");
			redirect="redirect:/sysMsg/ErrorMessage.jsp";
		}
		return redirect;
	}

	/*
	 * 修改购物车内商品数量
	 */
	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		
		Cart cart1=RequestUtil.requestToBean(request, Cart.class);
		
		int quantity2=Integer.valueOf(cart1.getQuantity()).intValue();
		Cart cart2=cartService.findById(cart1);
		int result=0;
		if (cart2!=null&&!cart2.getId().trim().equals("")) {
			int quantity=Integer.valueOf(cart2.getQuantity()).intValue();
			
			quantity+=quantity2;
			cart2.setQuantity(""+quantity);
			result=cartService.update(cart2);
		}else {
			Dishes dishes=dishesService.findById(new Dishes(cart1.getId()));
			cart1.setName(dishes.getName());
			cart1.setPrice(dishes.getPrice());
			cart1.setOriginalPrice(dishes.getSalesPrice());
			cart1.setQuantity(""+quantity2);
			result=cartService.add(cart1);
			
		}
		String redirect;
		if (result>0) {
			redirect="redirect://cartAndPay/cart.jsp";
		}else {
			redirect="redirect:/sysMsg/ErrorMessage.jsp";
		}
		return redirect;
	}

	@Override
	public String doAdd() throws Exception {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	@RequestMapping("/toUpdate")
	public String toUpdate() throws Exception {
		setModuleActionName();
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		//System.out.println(cart);
		int result=cartService.update(cart);
		return null;
	}

	@Override
	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		//System.out.println(cart);
		int result=cartService.update(cart);
		//System.out.println(result);
		return null;
	}

	@Override
	@RequestMapping("/delete")
	public String delete() throws Exception {
		setModuleActionName();
		Cart cart=RequestUtil.requestToBean(request, Cart.class);
		//System.out.println(cart.toString());
		int rows=cartService.delete(cart);
		
		String redirect;
		if (rows>0) {
			redirect="redirect:/cart/findByPaging.do";
		}else {
			redirect="redirect:/sysMsg/ErrorMessage.jsp";
		}
		return redirect;
	}
		
}
