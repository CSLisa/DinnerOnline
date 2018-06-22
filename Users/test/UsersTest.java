package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import exmvc.dao.UsersDao;
import exmvc.entity.impl.Users;


public class UsersTest {

	public static void main(String[] args) throws Exception{
		  InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
	        //2 创建SqlSessionFactory对象，完成对配置文件的读取
	             SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	        //3 创建sqlSession
	            SqlSession sqlSession = factory.openSession();
	        //4 执行增删改查  
	            Users users=new Users("2",null,null);
	            users= sqlSession.getMapper(UsersDao.class).findById(users);
	            List<Users> list=sqlSession.getMapper(UsersDao.class).findAll(null);
	            System.out.println(list);
	}
}
