package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.IUserDao;
import com.zpark.pageutil.PageBean;
import com.zpark.web.pojo.Department;
import com.zpark.web.pojo.Role;
import com.zpark.web.pojo.User;
import com.zpark.web.querybean.QueryVO;

@Service("userService")
/**
 * 分别是配置隔离级别(isolation)、传播机制(propagation)、只读
 * */
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserService implements IUserService{
	@Resource(name="userDao")
	private IUserDao userDao;
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	public void sava(User user) {
		userDao.sava(user);
	}
	@Override
	public void findByName() {
		userDao.findByName();
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public User login(User user) {
		User loginResult = userDao.login(user);
		return loginResult;
	}
	@Override
	public List<User> findAllUser(QueryVO queryVO,PageBean pageBean) {
		//判断条件查询对象queryVO是否为空，为空的情况下查询方式赋值为0，不对criteria操作，dao层执行全部查询；不为空的情况提取queryWay做判断
		String type=queryVO.getQueryWay()==null?"0":queryVO.getQueryWay();
		String queryContent = queryVO.getQueryContent();
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		//在员工列表中只显示在职员工，为逻辑删除做准备
		criteria.add(Restrictions.eq("is_used", "1"));
		if(type.equals("1")){
			criteria.add(Restrictions.like("user_name", "%"+queryContent+"%"));
		}else if(type.equals("2")){
			/**
			 * 使用criteria进行联表关联查询时
			 * */
			criteria.createAlias("dept", "d");//创建别名
			criteria.add(Restrictions.like("d.department_name", "%"+queryContent+"%"));
		}else if(type.equals("3")){
			criteria.createAlias("role", "r");
			criteria.add(Restrictions.like("r.role_name", "%"+queryContent+"%"));
		}else if(type.equals("4")){
			criteria.add(Restrictions.like("user_diploma", "%"+queryContent+"%"));
		}
		List<User> list = userDao.findAllUser(criteria,pageBean);
		return list;
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public boolean userInfoUpdate(User user) {
		Integer department_id = user.getDepartment_id();
		Integer role_id = user.getRole_id();
		
		Role role = new Role();
		role.setRole_id(role_id);
		Department department = new Department();
		department.setDepartment_id(department_id);
		
		user.setDept(department);
		user.setRole(role);
		
		return userDao.userInfoUpdate(user);
	}
	@Override
	public Integer getUserId(User user) {
		return userDao.getUserId(user);
	}
	@Override
	public User findById(Integer user_id) {
		return userDao.findById(user_id);
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public boolean userInfoDelete(User user) {
		boolean flag=userDao.userInfoDelete(user);
		return flag;
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public boolean addEmployee() {
		
		return userDao.addEmployee();
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public List<User> queryLimited(QueryVO queryVO) {
		if(queryVO==null){
			return null;
		}else if(queryVO.getQueryContent().equals("")){
			/**
			 * 查询条件为空时默认查询所有员工信息
			 * */
			//return userDao.findAllUser(new PageBean());
			return null;
		}else{
			String queryContent = queryVO.getQueryContent();
			String queryWay = queryVO.getQueryWay();
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			if(queryWay.equals("1")){
				criteria.add(Restrictions.like("user_name", "%"+queryContent+"%"));
			}else if(queryWay.equals("2")){
				/**
				 * 使用criteria进行联表关联查询时
				 * */
				criteria.createAlias("dept", "d");//创建别名
				criteria.add(Restrictions.like("d.department_name", "%"+queryContent+"%"));
			}else if(queryWay.equals("3")){
				criteria.createAlias("role", "r");
				criteria.add(Restrictions.like("r.role_name", "%"+queryContent+"%"));
			}else if(queryWay.equals("4")){
				criteria.add(Restrictions.like("user_diploma", "%"+queryContent+"%"));
			}else{
				return null;
			}
			return userDao.queryLimited(criteria);
		}
	}
	
}
