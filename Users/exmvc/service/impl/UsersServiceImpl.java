package exmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.SafeUtil;

import common.util.impl.Page;

import exmvc.dao.UsersDao;
import exmvc.dao.impl.UsersDaoImpl;
import exmvc.entity.impl.Users;
import exmvc.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	@Override
	public List<Users> findAll(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.findAll(condition);
	}

	@Override
	public Users findById(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.findById(condition);
	}

	@Override
	public List<Users> findByPaging(Page<Users> page, Users condition)
			throws Exception {
		
		return usersDao.findByPaging(page, condition);
	}

	@Override
	public int add(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.add(condition);
	}

	@Override
	public int update(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.update(condition);
	}

	@Override
	public int delete(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.delete(condition);
	}

	public UsersDao getUsersDaoImpl() {
		return usersDao;
	}

	public void setUsersDaoImpl(UsersDaoImpl usersDaoImpl) {
		this.usersDao = usersDaoImpl;
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return usersDao.findByNameAndPwd(username, password);
	}

	@Override
	public Users findByName(Users condition) throws Exception {
		// TODO Auto-generated method stub
		return usersDao.findByName(condition);
	}

	@Override
	public Users findByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return usersDao.findByNameAndPwd(name, pwd);
	}

	@Override
	public boolean checkUser(String name, String pwd){
		return usersDao.findByNameAndPwd(name, SafeUtil.encode(pwd)) != null;
	}

	
/*public PageBean findPageBean(int currentPage,int currentCount) throws Exception  {
		
		//目的：就是想办法封装一个PageBean 并返回
		PageBean pageBean = new PageBean();
		//1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//3、总条数private int totalCount;
		int totalCount = (int) usersDaoImpl.rows(null);
		pageBean.setTotalCount(totalCount);
		//4、总页数private int totalPage;
		
		 * 总条数		当前页显示的条数	总页数
		 * 10		4				3
		 * 11		4				3
		 * 12		4				3
		 * 13		4				4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5、每页显示的数据private List<T> productList = new ArrayList<T>();
		
		 * 页数与limit起始索引的关系
		 * 例如 每页显示4条
		 * 页数		其实索引		每页显示条数
		 * 1		0			4
		 * 2		4			4
		 * 3		8			4
		 * 4		12			4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 
		int index = (currentPage-1)*currentCount;
		
		List<Users> userList = usersDaoImpl.findUserListForPageBean(index,currentCount);
		pageBean.setUserList(userList);
		return pageBean;
	}*/
	

}
