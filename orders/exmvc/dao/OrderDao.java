package exmvc.dao;


import common.util.BaseDao;
import exmvc.entity.impl.Orders;
import mybatis.dao.Mybatisdao;

public interface OrderDao extends BaseDao<Orders>,Mybatisdao<Orders>{
	
}