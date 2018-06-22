package exmvc.action;

import common.util.BaseAction;
import exmvc.entity.impl.Users;

public interface UsersAction extends BaseAction<Users> {
	String findByName() throws Exception; 
	String findByNameAndPwd() throws Exception;
}
