package exmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.util.impl.Page;
import exmvc.dao.DishesDao;
import exmvc.entity.impl.Dishes;
import mybatis.dao.impl.MyBatisDaoImpl;
@Repository
public class DishesDaoImpl  implements  DishesDao  {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Dishes> findAll(Dishes condition) throws Exception {
		return sqlSessionTemplate.getMapper(DishesDao.class).findAll(condition);
	}
	@Override
	public Dishes findById(Dishes condition) throws Exception {
		return sqlSessionTemplate.getMapper(DishesDao.class).findById(condition);
	}
	@Override
	public int getRows(Dishes condition) throws Exception {
		return sqlSessionTemplate.getMapper(DishesDao.class).getRows(condition);
	}
	@Override
	public List<Dishes> findByPaging(Page<Dishes> page, Dishes condition)
			throws Exception {
		   int rows=getRows(condition);
		   page.setTotalRecords(rows);
		   page.setCurrentPage(page.getCurrentPage());
		   RowBounds rowBounds=new RowBounds((int)page.getFrom(),(int)page.getPageSize());
		   return sqlSessionTemplate.getMapper(DishesDao.class).findByPaging(condition,rowBounds);
	}
	@Override
	public int add(Dishes condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(DishesDao.class).add(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public int update(Dishes condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(DishesDao.class).update(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public int delete(Dishes condition) throws Exception {
		int rows=sqlSessionTemplate.getMapper(DishesDao.class).delete(condition);
		sqlSessionTemplate.commit();
		return rows;
	}
	@Override
	public List<Dishes> findByPaging(Dishes condition, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dishes findByName(Dishes condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
