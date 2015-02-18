package com.xininit.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xininit.dao.CommonDAOI;
import com.xininit.dao.EntityBaseDAOI;


/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午7:25:01
 */
@Repository("entityBaseDAO")
public abstract class EntityBaseDAOImpl<T extends Serializable,PK extends Serializable> implements EntityBaseDAOI<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CommonDAOI commonDAO;
	
	public abstract Class<T> getEntityClass();
	
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	@Override
	public void saveCollection(Collection<T> collection) {
		int i = 0;
		for(T o:collection){
			this.save(o);
			if(i>=100){//单次批量操作的数目为100
				i = 0;
				this.flush();//清理缓存，执行批量插入20条记录的SQL insert语句
				this.clear();//清空缓存中的T对象
			}else{
				i++;
			}
		}
	}

	@Override
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	@Override
	public void updateColection(Collection<T> collection) {
		for(T o:collection){
			this.update(o);
		}
	}

	@Override
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public void saveOrUpdateCollection(Collection<T> collection) {
		for(T o:collection){
			this.saveOrUpdate(o);
		}
	}

	@Override
	public Object merge(T o) {
		return this.getCurrentSession().merge(o);
	}

	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	@Override
	public void deleteByKey(PK id) {
		this.delete(this.load(id));
	}

	@Override
	public void deleteByKeys(PK[] ids) {
		for(PK id:ids){
			this.deleteByKey(id);
		}
	}

	@Override
	public void deleteByCollection(Collection<T> collection) {
		for(T o:collection){
			delete(o);
		}
	}

	@Override
	public Integer executeHQL(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public void flush() {
		this.getCurrentSession().flush();
	}

	@Override
	public void clear() {
		this.getCurrentSession().flush();
	}

	@Override
	public Long countByHQL(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (long)((BigInteger)q.uniqueResult()).intValue();
	}

	@Override
	public T get(PK id) {
		return (T) this.getCurrentSession().get(this.getEntityClass(), id);
	}

	@Override
	public T load(PK id) {
		return (T) this.getCurrentSession().load(this.getEntityClass(), id);
	}

	@Override
	public T getByHQL(String hql, Object... param) {
		List<T> l = this.findPageByHQL(hql, 0, 1, param);  
		if (l != null && l.size() > 0) {  
			return (T) l.get(0);  
		}else{
			return null;  
		}
	}

	@Override
	public List<T> findByHQL(String hql, Object... param) {
		return this.findPageByHQL(hql, null, null, param);
	}

	@Override
	public List<T> findPageByHQL(String hql, Integer page, Integer rows,
			Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);  
		commonDAO.initQueryParames(q, param);
		commonDAO.initQueryPage(q, page, rows);
		return q.list();
	}
	
}
