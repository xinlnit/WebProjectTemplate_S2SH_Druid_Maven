/**
 */
package com.xininit.service;


import java.util.List;

import com.xininit.pojo.Admin;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午12:43:22
 */
public interface AdminServiceI {
	
	/**
	 * 添加一个新的管理员
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午12:54:43
	 * @param name
	 * @param account
	 * @param password
	 * @return
	 */
	public String addNewAdmin(String name,String account,String password);
	
	/**
	 * 显示所有的管理员
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 下午12:54:59
	 * @return
	 */
	public List<Admin> showAllAdmin();
}
