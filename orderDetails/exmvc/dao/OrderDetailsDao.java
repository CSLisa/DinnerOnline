package exmvc.dao;

import common.util.BaseDao;
import exmvc.entity.impl.OrderDetails;
import mybatis.dao.Mybatisdao;

public interface OrderDetailsDao extends BaseDao<OrderDetails>,Mybatisdao<OrderDetails>{
   
}