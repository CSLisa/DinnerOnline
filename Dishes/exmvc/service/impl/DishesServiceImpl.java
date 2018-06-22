package exmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.impl.Page;
import exmvc.dao.DishesDao;
import exmvc.entity.impl.Dishes;
import exmvc.service.DishesService;
@Service
public class DishesServiceImpl implements DishesService{
    @Autowired
    private DishesDao dishesDao;
	@Override
	public List<Dishes> findAll(Dishes condition) throws Exception {
		
		return dishesDao.findAll(condition);
	}

	@Override
	public Dishes findById(Dishes condition) throws Exception {
		
		return dishesDao.findById(condition);
	}

	@Override
	public List<Dishes> findByPaging(Page<Dishes> page, Dishes condition) throws Exception {
		
		return dishesDao.findByPaging(page, condition);
	}

	@Override
	public int add(Dishes condition) throws Exception {
		
		return dishesDao.add(condition);
	}

	@Override
	public int update(Dishes condition) throws Exception {
		
		return dishesDao.update(condition);
	}

	@Override
	public int delete(Dishes condition) throws Exception {
		
		return dishesDao.delete(condition);
	}

	@Override
	public Dishes findByName(Dishes condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
