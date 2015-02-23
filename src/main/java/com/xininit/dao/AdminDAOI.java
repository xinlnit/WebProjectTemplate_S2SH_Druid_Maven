/**
 */
package com.xininit.dao;

import java.util.List;

import com.xininit.pojo.Admin;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午12:42:31
 */
public interface AdminDAOI extends EntityBaseDAOI<Admin, String> {
	/**
	 * 查看所有管理员
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月19日 下午10:04:26
	 */
	public List<Admin> showAll();
	
}
