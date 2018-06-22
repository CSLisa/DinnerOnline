package exmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import common.util.impl.Page;
import exmvc.dao.OrderDetailsDao;
import exmvc.entity.impl.OrderDetails;
import mybatis.dao.impl.MyBatisDaoImpl;
@Repository(value="orderDetailsDao")
public class OrderDetailsDaoImpl implements OrderDetailsDao {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemlate;
	
	public SqlSessionTemplate getSqlSessionTemlate() {
		return sqlSessionTemlate;
	}
	public List<OrderDetails> findAll(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemlate.getMapper(OrderDetailsDao.class).findAll(condition);
	}
	@Override
	public OrderDetails findById(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemlate.getMapper(OrderDetailsDao.class).findById(condition);
	}
	@Override
	public int getRows(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemlate.getMapper(OrderDetailsDao.class).getRows(condition);
	}

	@Override
	public List<OrderDetails> findByPaging(Page<OrderDetails> page, OrderDetails condition) throws Exception {
		//总记录数
		int  totalRecords=getRows(condition);
		page.setTotalRecords(totalRecords);
		//设置当前页
		page.setCurrentPage(page.getCurrentPage());
		RowBounds rowBounds=new RowBounds(page.getFrom(),page.getPageSize());
		return sqlSessionTemlate.getMapper(OrderDetailsDao.class).findByPaging(condition, rowBounds);
	}

	@Override
	public int add(OrderDetails condition) throws Exception {
		int rows=sqlSessionTemlate.getMapper(OrderDetailsDao.class).add(condition);
		return rows;
	}

	@Override
	public int update(OrderDetails condition) throws Exception {
		int rows=sqlSessionTemlate.getMapper(OrderDetailsDao.class).update(condition);
		return rows;
	}

	@Override
	public int delete(OrderDetails condition) throws Exception {
		int rows=sqlSessionTemlate.getMapper(OrderDetailsDao.class).delete(condition);
		return rows;
	}

	@Override
	public List<OrderDetails> findByPaging(OrderDetails condtion, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		OrderDetailsDao orderDetailsDao=new OrderDetailsDaoImpl();
		//findAll
		OrderDetails condition=new OrderDetails("","","","","","");
		int rows=0;
		
		List<OrderDetails> list=orderDetailsDao.findAll(condition);
		System.out.println(list);
		//findById
		
		/*OrderDetails condition=new OrderDetails("10","","","","","");
		OrderDetails orderDetails=orderDetailsDao.findById(condition);
		System.out.println(orderDetails);*/
        //findByPaging
		/*OrderDetails condition=new OrderDetails("","","","","","");
    	Page<OrderDetails> page=new Page<OrderDetails>();
        List<OrderDetails> list=orderDetailsDao.findByPaging(page,condition);
        System.out.println(list);*/
        //add
    	/*condition=new OrderDetails("22","1800","巡检8组","","","");
    	rows=orderDetailsDao.add(condition);
    	System.out.println(rows);*/
    	//update
		/*condition=new OrderDetails("22","1800","巡检9组","","","");
    	  rows=orderDetailsDao.update(condition);
    	System.out.println(rows);*/
    	//delete
    	/*condition=new OrderDetails("22","1800","巡检9组","","","");
    	rows=orderDetailsDao.delete(condition);
    	System.out.println(rows);*/
    	//sqlSession.commit();
	}

	@Override
	public OrderDetails findByName(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
