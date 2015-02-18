/**
 */
package com.xininit.dao.impl;

import java.io.Serializable;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xininit.dao.AdminDAOI;
import com.xininit.pojo.Admin;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午12:42:46
 */
@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAOI{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		//return sessionFactory.openSession();
		//openSession和CurrentSession的区别
		//采用getCurrentSession()创建的session会绑定到当前线程中，而采用openSession()创建的session则不会
		//采用getCurrentSession()创建的session在commit或rollback时会自动关闭，而采用openSession()创建的session必须手动关闭 
		
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public Serializable save(Admin admin) {
		return this.getCurrentSession().save(admin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAll() {
		String hql = " from Admin ";
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

}
