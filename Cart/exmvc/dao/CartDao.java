package exmvc.dao;

import common.util.BaseDao;
import exmvc.entity.impl.Cart;
import mybatis.dao.Mybatisdao;

public interface CartDao extends BaseDao<Cart>,Mybatisdao<Cart>{
	//具体业务逻辑--除了增删改插
}
