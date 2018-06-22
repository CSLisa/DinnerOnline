package exmvc.action.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.UsersAction;


import exmvc.entity.impl.Users;

import exmvc.service.UsersService;
import springmvc.action.impl.SpringMVCActionImpl;
@Controller
@RequestMapping("/users")
public class UersActionImpl extends SpringMVCActionImpl implements UsersAction{
     @Autowired
     private UsersService usersService;
     
    
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll() throws Exception {
		List<Users> usersList=usersService.findAll(null);
		//将List转为json数据
		String string=JSON.toJSONString(usersList, true).toString();
		
		System.out.println(string);
		//返回
		 return string;
	}

	@RequestMapping("/findByPaging")
	public String findByPaging() throws Exception {
		setModuleActionName();
		//VariableDeclaring
		Users users=RequestUtil.requestToBean(request, Users.class);
		Page<Users> page=RequestUtil.requestToBean(request, Page.class);
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findByPaging
		 List<Users> list=usersService.findByPaging(page,users);
		 page.setDataList(list);
		//保存list到request转发
		 request.setAttribute("users", users);
		 request.setAttribute("page", page);
		//返回
		return "users/list";
		
		
	}

	@RequestMapping("/findById")
	public String findById() throws Exception {
		setModuleActionName();
		//VariableDeclaring
		Users users=RequestUtil.requestToBean(request,Users.class);
		
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findById
		users=usersService.findById(users);
		//保存users到request转发
		request.setAttribute("users", users);
		
		return "detailsp";
		
	}

	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		//VariableDeclaring
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现(无)
		//返回
		return "users/operator";
	}

	@RequestMapping("/doAdd")
	public String doAdd() throws Exception {
		//VariableDeclaring
		Users users=RequestUtil.requestToBean(request,Users.class);
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现(无)
		int result=usersService.add(users);
		if(result>0){
			if (result>0) {
				message("添加成功", "/users/findByPaging.st");
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
		Users users=RequestUtil.requestToBean(request, Users.class);
		//InputChecking
		//InitAssign
		setModuleActionName();
		//业务逻辑实现
		users=usersService.findById(users);
		List<Users> usersList=usersService.findAll(null);
		
		request.setAttribute("usersList", usersList);
		request.setAttribute("users", users);
		
		return "users/operator";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		setModuleActionName();
		Users users=RequestUtil.requestToBean(request, Users.class);
		
		int rows=usersService.update(users);
		if (rows>0) {
			message("修改成功", "/users/findByPaging.st");
		}else {
			message("修改失败", "back");
		}
		return "message";
	}

	@RequestMapping("/delete")
	public String delete() throws Exception {
		setModuleActionName();
		Users users=RequestUtil.requestToBean(request, Users.class);
		System.out.println(users.toString());
		int rows=usersService.delete(users);
		if (rows>0) {
			message("删除成功", "/users/findByPaging.st");
		}else {
			message("删除失败", "back");
		}
		return "message";
	}
	
	/*@RequestMapping(value="/login.st",method=RequestMethod.POST)
    public ModelAndView login(String username,String password,ModelAndView mv,HttpSession session) {
        Users users = usersService.login(username, password);
        if(users!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("users", users);
            //转发到main请求
            mv.setView(new RedirectView("/smmbookapp/main"));
            mv.setViewName("index.jsp");
        }else {
            //登录失败，设置失败信息，并调转到登录页面
            
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        System.out.println("登陆的users"+users);
        return mv;
    }*/
	
	@RequestMapping("/login")
	public String login(@RequestParam(required=false, defaultValue="0")int flag, Users users, HttpSession session, Model model) throws Exception {
		model.addAttribute("users", usersService.findById(users));
		if(flag==-1) {
			flag = 6; // 登录页面
			return "index.jsp";
		}
		if(usersService.checkUser(users.getName(), users.getPwd())){
			session.setAttribute("users", usersService.findByName(users));
			return "redirect:index";
		} else {
			model.addAttribute("msg", "用户名或密码错误!");
			return "/index/login.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("order");
		return "/index.jsp";
	}
	
    
    /**
     * 跳转到用户注册页面
     */
    @RequestMapping(value="/add.do")
    public String registerpage() {
        
        return "users/add";
    }
    /**
     * 用户注册
     * @throws Exception 
     */
   /* @RequestMapping(value="/userregister.do",method=RequestMethod.POST)
    public String add(Users users) throws Exception {
        String name=users.getName();
        // 如果数据库中没有该用户，可以注册，否则跳转页面
        if (usersService.findByName(name)==null) {
            // 添加用户
            usersService.add(users);
            return "mainPage";
        }else {
            // 注册失败跳转到错误页面
            return "error";
        }
        
    }*/

    @RequestMapping("/findByName")
	public String findByName() throws Exception {
    	setModuleActionName();
		//VariableDeclaring
		Users users=RequestUtil.requestToBean(request,Users.class);
		
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findByName
		users=usersService.findByName(users);
		//保存users到request转发
		request.setAttribute("users", users);
		
		return "detailsp";
	}

    @RequestMapping("/findByNameAndPwd")
	public String findByNameAndPwd() throws Exception {
    	setModuleActionName();
		//VariableDeclaring
		Users users=RequestUtil.requestToBean(request,Users.class);
		String name = users.getName();
		String pwd = users.getPwd();
		
		//InputChecking
		//InitAssign
		//业务逻辑实现:执行findByNameAndPwd
		users=usersService.findByNameAndPwd(name, pwd);
		//保存users到request转发
		request.setAttribute("users", users);
		System.out.println(users);
		
		return "detailsp";
	}
	
	}


