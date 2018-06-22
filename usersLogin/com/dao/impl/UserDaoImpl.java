package com.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dao.UserDao;
import com.po.User;
import com.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsernameAndUserpwd(String username, String userpwd) {
		try {
			QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from users where username? and userpwd=?";
			User user = queryRunner.query(sql, new BeanHandler<User>(User.class),username,userpwd);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
