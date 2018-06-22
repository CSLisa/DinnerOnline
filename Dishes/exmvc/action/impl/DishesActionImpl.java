package exmvc.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.DishesAction;


import exmvc.entity.impl.Dishes;

import exmvc.service.DishesService;
import springmvc.action.impl.SpringMVCActionImpl;
@Controller
@RequestMapping("/dishes")
public class DishesActionImpl extends SpringMVCActionImpl implements DishesAction{
     @Autowired
     private DishesService dishesService;
     
    
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll() throws Exception {
		List<Dishes> dishesList=dishesService.findAll(null);
		//将List转为json数据
		String string=JSON.toJSONString(dishesList, true).toString();
		
		//System.out.println(string);
		//返回
		 return string;
	}

	@RequestMapping("/findByPaging")
	public String findByPaging() throws Exception {
		setModuleActionName();
		//VariableDeclaring
		Dishes dishes=RequestUtil.requestToBean(request, Dishes.class);
		Page<Dishes> page=RequestUtil.requestToBean(request, Page.class);
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findByPaging
		 List<Dishes> list=dishesService.findByPaging(page,dishes);
		 page.setDataList(list);
		//保存list到request转发
		 request.setAttribute("dishes", dishes);
		 request.setAttribute("page", page);
		//返回
		return "dishes/list";
		
		
	}

	@RequestMapping("/findById")
	public String findById() throws Exception {
		setModuleActionName();
		//VariableDeclaring
		Dishes dishes=RequestUtil.requestToBean(request,Dishes.class);
		
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findById
		dishes=dishesService.findById(dishes);
		//保存dishes到request转发
		request.setAttribute("dishes", dishes);
		
		return "/dishes/detailsp";
		
	}

	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		//VariableDeclaring
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现(无)
		//返回
		return "dishes/operator";
	}

	@RequestMapping("/doAdd")
	public String doAdd() throws Exception {
		//VariableDeclaring
		Dishes dishes=RequestUtil.requestToBean(request,Dishes.class);
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现(无)
		int result=dishesService.add(dishes);
		if(result>0){
			if (result>0) {
				message("添加成功", "/dept/findByPaging.st");
			}else {
				message("添加失败", "back");
			}
			return "message";
		}
		return null;
	}

	@RequestMapping("/toUpdate")
	public String toUpdate() throws Exception {
		//VariableDeclaring
		Dishes dishes=RequestUtil.requestToBean(request, Dishes.class);
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现
		dishes=dishesService.findById(dishes);
		List<Dishes> dishesList=dishesService.findAll(null);
		
		request.setAttribute("dishesList", dishesList);
		request.setAttribute("dishes", dishes);
		
		return "dishes/operator";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		setModuleActionName();
		Dishes dishes=RequestUtil.requestToBean(request, Dishes.class);
		
		int rows=dishesService.update(dishes);
		if (rows>0) {
			message("修改成功", "/dept/findByPaging.st");
		}else {
			message("修改失败", "back");
		}
		return "message";
	}

	@RequestMapping("/delete")
	public String delete() throws Exception {
		setModuleActionName();
		Dishes dishes=RequestUtil.requestToBean(request, Dishes.class);
		//System.out.println(dishes.toString());
		int rows=dishesService.delete(dishes);
		if (rows>0) {
			message("删除成功", "/dept/findByPaging.st");
		}else {
			message("删除失败", "back");
		}
		return "message";
	}
	}


