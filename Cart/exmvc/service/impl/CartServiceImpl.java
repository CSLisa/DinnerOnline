package exmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.impl.Page;
import exmvc.dao.CartDao;
import exmvc.entity.impl.Cart;
import exmvc.service.CartService;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	
	public CartDao getCartdao() {
		return cartDao;
	}

	public void setCartdao(CartDao cartdao) {
		this.cartDao = cartdao;
	}

	@Override
	public List<Cart> findAll(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.findAll(condition);
	}

	@Override
	public Cart findById(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.findById(condition);
	}
	

	@Override
	public List<Cart> findByPaging(Page<Cart> page, Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.findByPaging(page,condition);
	}

	@Override
	public int add(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.add(condition);
	}

	@Override
	public int update(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.update(condition);
	}

	@Override
	public int delete(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.delete(condition);
	}

	@Override
	public Cart findByName(Cart condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
