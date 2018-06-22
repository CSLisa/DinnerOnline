package exmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.impl.Page;
import exmvc.dao.OrderDetailsDao;
import exmvc.entity.impl.OrderDetails;
import exmvc.service.OrderDetailsService;
@Service(value="orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{
	@Autowired
	private OrderDetailsDao orderDetails;

	@Override
	public List<OrderDetails> findAll(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return orderDetails.findAll(condition);
	}

	@Override
	public OrderDetails findById(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return orderDetails.findById(condition);
	}

	@Override
	public List<OrderDetails> findByPaging(Page<OrderDetails> page, OrderDetails condition) throws Exception {
	
		return orderDetails.findByPaging(page, condition);
	}

	@Override
	public int add(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return orderDetails.add(condition);
	}

	@Override
	public int update(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return orderDetails.update(condition);
	}

	@Override
	public int delete(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return orderDetails.delete(condition);
	}

	public OrderDetailsDao getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetailsDao orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public OrderDetails findByName(OrderDetails condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
