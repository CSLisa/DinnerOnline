package com.dao;

import com.po.User;

public interface UserDao {

	User findUserByUsernameAndUserpwd(String username, String userpwd);

}
