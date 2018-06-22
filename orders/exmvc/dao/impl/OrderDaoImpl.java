package exmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.util.impl.Page;
import exmvc.dao.OrderDao;
import exmvc.entity.impl.Orders;
import mybatis.dao.impl.MyBatisDaoImpl;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate ;
	@Override
	public List<Orders> findAll(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).findAll(condition);
	}

	@Override
	public Orders findById(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).findById(condition);
	}

	@Override
	public int getRows(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).getRows(condition);
	}

	@Override
	public List<Orders> findByPaging(Page<Orders> page, Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).findByPaging(page, condition);
	}

	@Override
	public int add(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).add(condition);
	}

	@Override
	public int update(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).update(condition);
	}

	@Override
	public int delete(Orders condition) throws Exception {
		return sqlSessionTemplate.getMapper(OrderDao.class).delete(condition);
	}

	@Override
	public List<Orders> findByPaging(Orders condition, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findByName(Orders condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
