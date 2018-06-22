package exmvc.test;

import java.util.List;

import exmvc.dao.DishesDao;
import exmvc.dao.impl.DishesDaoImpl;
import exmvc.entity.impl.Dishes;

public class Test {
 
	public static void main(String[] args) throws Exception {
		DishesDao dishesDao=new DishesDaoImpl();
		Dishes dishes=new Dishes();
		//findAll
		List<Dishes> list=dishesDao.findAll(null);
		System.out.println(list);
		
		
	}
}
