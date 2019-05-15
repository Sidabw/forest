package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zpark.pageutil.PageBean;
import com.zpark.web.pojo.User;
import com.zpark.web.querybean.QueryVO;
@Repository("userDao")
public class UserDao extends HibernateDaoSupport implements IUserDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	public void sava(User u){
/*		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(new User(null,"brew",""));
		tx.commit();*/
		getHibernateTemplate().save(u);
/*		getHibernateTemplate().delete(u);
		getHibernateTemplate().update(u);*/
	}
	public User findByName(){
		
		//方式一
		//类似于开启一段线程的写法，
/*		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();*/
		getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where name=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, "sss");
				User u = (User) query.uniqueResult();
				System.out.println(u);
				return null;
			}
		});
		
		//方式二
/*		DetachedCriteria criteria =DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.like("name","%s%"));
		List<User> list = (List<User>)getHibernateTemplate().findByCriteria(criteria);
		for(User user:list){
			System.out.println(user);
		}*/
		return null;
	}
	@Override
	public User login(User user) {
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_num", user.getUser_num()));
		criteria.add(Restrictions.eq("user_pw", user.getUser_pw()));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list.size()==0?null:list.get(0);
	}
	@Override
	public List<User> findAllUser(DetachedCriteria criteria,PageBean pageBean) {
		
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		//将总条数赋值给pageBean 为在页面显示做准备
		pageBean.setRowCount(list.size());
		System.out.println(pageBean+"-------------------"+pageBean.getStartRow()+"----------"+pageBean.getRowCount());
		List<User>list2=(List<User>)super.getHibernateTemplate().findByCriteria(criteria,pageBean.getStartRow(),pageBean.getSize());
		//员工列为为空时返回null
		return list2.size()==0?null:list2;
	}
	@Override
	public boolean userInfoUpdate(User user) {
		getHibernateTemplate().update(user);
		return true;
	}
	@Override
	public Integer getUserId(User user) {
		DetachedCriteria criteria =DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_name", user.getUser_name()));
		criteria.add(Restrictions.eq("user_mobile", user.getUser_mobile()));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list.size()==0?null:list.get(0).getUser_id();
	}
	@Override
	public User findById(Integer user_id) {
		DetachedCriteria criteria =DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list.size()==0?null:list.get(0);
	}
	//进行逻辑删除
	@Override
	public boolean userInfoDelete(User u) {
		u.setIs_used("0");
		System.out.println(u.getUser_id());
		getHibernateTemplate().update(u);
		return true;
	}
	
	public boolean addEmployee(){
		
		
		
		//一次添加100个员工
	/*	HibernateTemplate ht = getHibernateTemplate();
		for(int i=0;i<100;i++){
			User user = new User(null,1,1,null,"Brew","男","234567890",31,"山东淄博",
					"brew","123","4787656781","3500874567890","689687658@qq.com",null,
					"罗蕾",null,"未修改","very much","本科","09876545678966","汉族","已婚","1");
			user.setUser_name("Brew"+i);
			Department dept = new Department();
			Role role = new Role();
			dept.setDepartment_id(1);
			role.setRole_id(1);
			user.setDept(dept);
			user.setRole(role);
			ht.save(user);
		}*/
		return true;
	}
	//方法放弃
	@Override
	public List<User> queryLimited(DetachedCriteria criteria) {

		List<User> list = (List<User>)getHibernateTemplate().findByCriteria(criteria);
		return list.size()==0?null:list;
	}
}
