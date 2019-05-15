package com.Java.bak.middle.sshBak.SSH.src.com.zpark.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.zpark.web.pojo.User;
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
}
