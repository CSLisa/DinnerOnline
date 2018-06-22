package exmvc.dao;

import common.util.BaseDao;
import exmvc.entity.impl.Dishes;
import mybatis.dao.Mybatisdao;

public interface DishesDao extends BaseDao<Dishes>,Mybatisdao<Dishes>{
	
}