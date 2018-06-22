package exmvc.dao;

import org.apache.ibatis.annotations.Param;

import common.util.BaseDao;
import exmvc.entity.impl.Users;
import mybatis.dao.Mybatisdao;

public interface UsersDao extends BaseDao<Users>,Mybatisdao<Users>{
	//根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
	Users findByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
}
