package exmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.util.impl.Page;
import exmvc.dao.UsersDao;
import exmvc.entity.impl.Users;
import mybatis.dao.impl.MyBatisDaoImpl;
@Repository
public class UsersDaoImpl implements  UsersDao  {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Users> findAll(Users condition) throws Exception {
		return sqlSessionTemplate.getMapper(UsersDao.class).findAll(condition);
	}
	@Override
	public Users findById(Users condition) throws Exception {
		return sqlSessionTemplate.getMapper(UsersDao.class).findById(condition);
	}
	@Override
	public int getRows(Users condition) throws Exception {
		return sqlSessionTemplate.getMapper(UsersDao.class).getRows(condition);
	}
	@Override
	public List<Users> findByPaging(Page<Users> page, Users condition)
			throws Exception {
		   int rows=getRows(condition);
		   page.setTotalRecords(rows);
		   page.setCurrentPage(page.getCurrentPage());
		   RowBounds rowBounds=new RowBounds((int)page.getFrom(),(int)page.getPageSize());
		   return sqlSessionTemplate.getMapper(UsersDao.class).findByPaging(condition,rowBounds);
	}
	@Override
	public int add(Users condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(UsersDao.class).add(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public int update(Users condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(UsersDao.class).update(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public int delete(Users condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(UsersDao.class).delete(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public List<Users> findByPaging(Users condition, RowBounds rowBounds) {
		return null;
	}
	@Override
	public Users findByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.getMapper(UsersDao.class).findByNameAndPwd(name, pwd);
	}
	@Override
	public Users findByName(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.getMapper(UsersDao.class).findByName(condition);
	}
	
}
