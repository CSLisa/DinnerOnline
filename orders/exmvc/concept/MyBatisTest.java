package exmvc.concept;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exmvc.dao.OrderDao;
import exmvc.entity.impl.Orders;

public class MyBatisTest {
	
	public static void main(String[] args) throws Exception {
		/*ApplicationContext tx = new ClassPathXmlApplicationContext("applicationContext_orders.xml");
		   OrderDao orderDao = (OrderDao) tx.getBean("OrderDaoImpl");
		   Orders condition = new Orders("","");
		   List<Orders> list = orderDao.findAll(condition);
		   System.out.println(list);*/
		
		 //1 获取mybatis-config.xml的输入流
	    //2 创建SqlSessionFactory对象，完成对配置文件的读取
	    //3 创建sqlSession
	    //4 执行增删改查
		     InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		     SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		     SqlSession sqlSession=factory.openSession();
		     Orders condition2= new Orders("1", "1","","","","","");
	     //2>findAll
		     int list2=sqlSession.getMapper(OrderDao.class).add(condition2);
		     System.out.println(list2);
		     sqlSession.commit();
	}
   
	     
	}

