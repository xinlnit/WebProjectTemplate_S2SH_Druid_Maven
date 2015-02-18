/**
 */
package com.xininit.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * 实体的基础操作类
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午6:50:11
 * @param <T> 实体的类型
 * @param <PK> 主键的类型
 */
public interface EntityBaseDAOI<T extends Serializable,PK extends Serializable> {
	
	//执行操作
	
	/**
	 * 保存
	 * @param o
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:55:30
	 */
	public Serializable save(T o);	
	
	/**
	 * 批量保存
	 * @param collection
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:55:40
	 */
	public void saveCollection(Collection<T> collection);	
	
	/**
	 * 修改
	 * @param o
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:55:51
	 */
	public void update(T o);
		
	/**
	 * 批量修改
	 * @param collection
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:03
	 */
	public void updateColection(Collection<T> collection);
		
	/**
	 * 保存或修改
	 * @param o
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:17
	 */
	public void saveOrUpdate(T o);
		
	/**
	 * 批量保存或修改
	 * @param collection
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:28
	 */
	public void saveOrUpdateCollection(Collection<T> collection);
		
	/**
	 * 合并
	 * @param o
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:39
	 */
	public Object merge(T o);
		
	/**
	 * 根据实体删除对象
	 * @param o
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:47
	 */
	public void delete(T o);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:56:58
	 */
	public void deleteByKey(PK id);
		
	/**
	 * 批量删除
	 * @param ids
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:57:08
	 */
	public void deleteByKeys(PK[] ids);
		
	/**
	 * 批量删除
	 * @param collection
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:57:17
	 */
	public void deleteByCollection(Collection<T> collection);
		
	/**
	 * 执行HQL语句
	 * @param hql
	 * @return 查询的返回查询条数，执行的返回修改条数
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:57:26
	 */
	public Integer executeHQL(String hql);
		
	/**
	 * 强制立刻更新缓冲数据到数据库(否则仅在事务提交时才更新)
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:08:09
	 */
	public void flush();
		
	/**
	 * 清空缓存中的对象
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:08:54
	 */
	public void clear();
	
	//计算count	
	/**
	 * select count(*) from 类
	 * @param hql
	 * @param param
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:58:08
	 */
	public Long countByHQL(String hql,Object... param);
		
	//查询单条记录
	/**
	 * 获得一个对象
	 * @param id
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:58:19
	 */
	public T get(PK id);
	
	/**
	 * 获得一个对象
	 * @param id
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:58:29
	 */
	public T load(PK id);
	
	/**
	 * 获得一个对象
	 * @param hql
	 * @param param
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:58:40
	 */
	public T getByHQL(String hql,Object... param);

	/**
	 * 查找对象集合
	 * @param hql
	 * @param param
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:58:48
	 */
	public List<T> findByHQL(String hql,Object... param);
	
	//分页查询
	/**
	 * 查找对象集合，带分页(Object是所有对象的父类，包括int/list在内的一切数据类型和集合对象)<br>
	 * 虽然加入重载方法：findByHQL(String hql, int page, int rows, Object... param) 不会报错<br>
     * 但当调用(String hql, int page, int rows, Object... param)时，<br>
     * findByHQL(String hql, Object... param)也适用，编译器可能会使用这个方法而不使用上面的重载方法<br>
     * 所以不能重载，需要重新命名方法)
	 * @param hql
	 * @param page
	 * @param rows
	 * @param param
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:21:41
	 * @return
	 */
	public List<T> findPageByHQL(String hql,Integer page,Integer rows,Object... param);
}
