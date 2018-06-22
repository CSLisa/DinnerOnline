package mybatis.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDaoImpl {
	protected static SqlSessionFactory factory=null;
	protected static SqlSession sqlSession=null;
	static{
		InputStream is=null; 
		 try {
			//1 获取mybatis-config.xml的输入流
			    is = Resources.getResourceAsStream("mybatis-config.xml");
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			    factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建sqlSession
			    sqlSession = factory.openSession();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}
	
 
}
