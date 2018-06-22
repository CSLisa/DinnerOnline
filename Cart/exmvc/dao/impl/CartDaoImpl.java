package exmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.util.impl.Page;
import exmvc.dao.CartDao;
import exmvc.entity.impl.Cart;
import mybatis.dao.impl.MyBatisDaoImpl;
@Repository
public class CartDaoImpl implements CartDao{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemlate;
	
	public SqlSessionTemplate getSqlSessionTemlate() {
		return sqlSessionTemlate;
	}

	public void setSqlSessionTemlate(SqlSessionTemplate sqlSessionTemlate) {
		this.sqlSessionTemlate = sqlSessionTemlate;
	}
	@Override
	public List<Cart> findAll(Cart condition) throws Exception {
		List<Cart> list=sqlSessionTemlate.getMapper(CartDao.class).findAll(condition);
		return list;
	}

	@Override
	public Cart findById(Cart condition) throws Exception {
		return sqlSessionTemlate.getMapper(CartDao.class).findById(condition);
	}

	@Override
	public int getRows(Cart condition) throws Exception {
		return sqlSessionTemlate.getMapper(CartDao.class).getRows(condition);
	}


	@Override
	public List<Cart> findByPaging(Page<Cart> page, Cart condition) throws Exception {
		//获取总记录数
		int rows=(int)getRows(condition);
		page.setTotalRecords(rows);
		//设置RowBounds(offset, limit)--offset当前页的起始数, limit页尺寸
		RowBounds rowBounds=new RowBounds(page.getFrom(), page.getPageSize());
		//查询分页数据
		List<Cart> list = findByPaging(condition, rowBounds);
		page.setDataList(list);
		return list;
	}

	@Override
	public int add(Cart condition) throws Exception {
		return sqlSessionTemlate.getMapper(CartDao.class).add(condition);
	}

	@Override
	public int update(Cart condition) throws Exception {
		return sqlSessionTemlate.getMapper(CartDao.class).update(condition);
	}

	@Override
	public int delete(Cart condition) throws Exception {
		return sqlSessionTemlate.getMapper(CartDao.class).delete(condition);
	}

	@Override
	public List<Cart> findByPaging(Cart condition, RowBounds rowBounds) {
		//逻辑分页
		return sqlSessionTemlate.getMapper(CartDao.class).findByPaging(condition, rowBounds);
	}

	@Override
	public Cart findByName(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
