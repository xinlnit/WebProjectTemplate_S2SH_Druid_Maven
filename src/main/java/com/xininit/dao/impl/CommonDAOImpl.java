/**
 */
package com.xininit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xininit.dao.CommonDAOI;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午8:08:40
 */
@Repository("commonDAO")
public class CommonDAOImpl implements CommonDAOI {
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryList(Query q, Class<T> entityClass) {
		//TODO 转换成安全过程需要消耗资源，由于可能存在list大量数据，暂时还是采用注解取消警告的方式
		//return MyArrayListUtil.rtnSafeTypeList(q.list(), entityClass);
		return q.list();
	}

	@Override
	public Query initQueryPage(Query q, Integer page, Integer rows) {
		if(page!=null && rows!=null){
			q.setFirstResult((page-1)*rows)
			.setMaxResults(rows);
		}
		return q;
	}

	@Override
	public void initQueryParames(Query q, Object... param) {
		//在这种Object...能匹配绝大部分参数的情况

		//因此这种方法无法重载，由于param参赛仅存在几个中不同的处理方法，若针对这几个不同而去重命名方法
		//代码可读性降低，且每个上级方法还需要判断自身的参数及调用方法，造成更大的耦合

		//因此决定采用结构式编程的方式，此方法体内高度内聚，而对于上级方法，他只需要按约定规则传参:
		//1param参数从左至右存入q.Parameter
		//2识别到obj[]/list对象，会先进行遍历，将内容加入Parameter中，然后再处理后面的param
		//不用因参数类型去判断该用那个重名方法，达到解耦的效果
		if(param!=null){
			int num = 0;
			for(int i=0;i<param.length;i++){
				num = this.initQueryParame(q, num, param[i]);
			}
		}
	}
	
	/**
	 * 单个参数处理方法
	 * @param q
	 * @param num
	 * @param param
	 * @return
	 */
	private int initQueryParame(Query q,int num, Object param){
		if(param instanceof List){//集合类型参数处理
			List<?> paramList = (List<?>) param;
			//处理集合结果后返回最新的下标
			num = this.initQueryParameList(q, num, paramList);
		}else if(param instanceof Object[]){//数组类型
			Object[] objs =  (Object[]) param;
			num = this.initQueryParameObjects(q, num, objs);
		}else{
			q.setParameter(String.valueOf(num), param);
			num ++;
		}

		return num;
	}
	
	@Override
	public int initQueryParameList(Query q, int num, List<?> paramList) {
		if(paramList!=null){
			for(int i=0;i<paramList.size();i++){
				num = this.initQueryParame(q, num, paramList.get(i));
			}
		}
		return num;
	}

	@Override
	public int initQueryParameObjects(Query q, int num, Object[] paramObjs) {
		if(paramObjs!=null){
			for(int i=0;i<paramObjs.length;i++){
				num = this.initQueryParame(q, num, paramObjs[i]);
			}
		}
		return num;
	}

	@Override
	public List<Object[]> findByHQL(Session currentSession, String hql,
			Object... param) {
		return this.findPageByHQL(currentSession, hql, null, null, param);
	}

	@Override
	public List<Object[]> findPageByHQL(Session currentSession, String hql,
			Integer page, Integer rows, Object... param) {
		Query q = currentSession.createQuery(hql);
		this.initQueryParames(q, param); 
		this.initQueryPage(q, page, rows);
		return this.queryList(q, Object[].class);
	}
	
	

}
