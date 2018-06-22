package exmvc.service;

import org.apache.ibatis.annotations.Param;

import common.util.BaseService;
import exmvc.entity.impl.Users;

public interface UsersService extends BaseService<Users>{
	 //验证name
	//通过用户名和密码登陆
	Users login(String username, String password); 
	//根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
	Users findByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
	boolean checkUser(String name, String pwd);
}
