package exmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.impl.Page;
import exmvc.dao.OrderDao;
import exmvc.entity.impl.Orders;
import exmvc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Orders> findAll(Orders condition) throws Exception {
		return orderDao.findAll(condition);
	}

	@Override
	public Orders findById(Orders condition) throws Exception {
		return orderDao.findById(condition);
	}

	@Override
	public List<Orders> findByPaging(Page<Orders> page, Orders condition) throws Exception {
		return orderDao.findByPaging(page, condition);
	}

	@Override
	public int add(Orders condition) throws Exception {
		return orderDao.add(condition);
	}

	@Override
	public int update(Orders condition) throws Exception {
		return orderDao.update(condition);
	}

	@Override
	public int delete(Orders condition) throws Exception {
		return orderDao.delete(condition);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Orders findByName(Orders condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
