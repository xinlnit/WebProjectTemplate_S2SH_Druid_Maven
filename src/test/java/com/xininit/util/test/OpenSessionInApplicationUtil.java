package com.xininit.util.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/*
 * 为了自动提交事务，决定dao那里还是使用getCurrentSession()，但这样做会导致2个问题：
 * 1 调用Dao.save时出现异常： Could not obtain transaction-synchronized Session for current thread
 * 2 使用懒加载的时候出现异常： could not initialize proxy - no Session
 * 原因：在提交和访问数据之前，session已经关闭了
 * 解决思路：
 * 1sessionFactory创建了session的时候，getCurrentSession()会沿用session，只有没有session的时候再新建
 * 2参考openSessionInView.java的doFilterInternal方法，其主要作用将一个Hibernate Session和一次完整的请求过程对应的线程相绑定.
 * 3在getCurrentSession()方法之前，先创建session,并将其与Application绑定
 */
/**
 * 
 * 
 * 把Hibernate Session和Application相绑定
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午2:42:09
 */
public class OpenSessionInApplicationUtil {
	/**
	 * 开启和绑定session
	 * @param sessionFactory
	 */
	public static void before(SessionFactory sessionFactory){
		//手动编码打开session
		Session session = sessionFactory.openSession();
		//将session保存在sessionHolder，并由TransactionSynchronizationManager进行管理
		//保存
		SessionHolder sessionHolder = new SessionHolder(session);
		//管理，绑定到本地线程
		TransactionSynchronizationManager.bindResource(sessionFactory, sessionHolder);
		
	}
	
	/**
	 * 解除绑定和关闭session
	 */
	public static void after(SessionFactory sessionFactory){
		SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session session = sessionHolder.getSession();
		//清除
		session.flush();
		//从本地线程中取消绑定
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		//关闭连接
		SessionFactoryUtils.closeSession(session);
	}
}
