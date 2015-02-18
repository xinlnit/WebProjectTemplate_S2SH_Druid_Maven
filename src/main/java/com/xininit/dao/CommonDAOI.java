/**
 */
package com.xininit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午7:40:31
 */
public interface CommonDAOI {
	
	/**
	 * 设置分页参数
	 * @param q
	 * @param page
	 * @param rows
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:41:23
	 */
	public Query initQueryPage(Query q,Integer page,Integer rows);

	/**
	 * 存储参数
	 * @param q 
	 * @param param
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:42:39
	 */
	public void initQueryParames(Query q,Object... param);
	
	/**
	 * 存储集合类型的参数
	 * @param q
	 * @param num
	 * @param paramList
	 * @return 处理集合结果后返回最新的下标值
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:45:56
	 */
	public int initQueryParameList(Query q,int num,List<?> paramList);

	/**
	 * 存储数组obj[]类型的参数
	 * @param q
	 * @param num
	 * @param paramObjects
	 * @return 处理集合结果后返回最新的下标值
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午7:50:57
	 */
	public int initQueryParameObjects(Query q,int num,Object[] paramObjs);
	

	//查询方法[独立出EntityBase的原因有3个：
    //1是该查询并不针对任一实体，可能是返回id,name,pwd三列数据,也可能使返回user/student/class等任意一个实体或多个实体,最后也是以obj[0]obj[1]obj[2]...的方式读取数据，并非实体的方式
    //2如果在base中，会与原findBySQL冲突，无法实现重载(返回值不属于重载范畴，而使用了Object...，使得无法通过不同的变量类型进行重载)，必须重命名方法
    //3非常用的方法，很多实体类不需要使用这种查询
	/**
	 * HQL查询，返回多列或多个实体
	 * @param currentSession
	 * @param hql
	 * @param param
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午8:14:25
	 */
	public List<Object[]> findByHQL(Session currentSession,String hql,Object... param);
	
	/**
	 * HQL分页查询，返回多列或多个实体
	 * @param currentSession
	 * @param hql
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午8:14:50
	 */
	public List<Object[]> findPageByHQL(Session currentSession,String hql,Integer page,Integer rows,Object... param);
}
