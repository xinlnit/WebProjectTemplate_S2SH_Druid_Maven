package com.xininit.service;

import com.xininit.pojo.AccountManage;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:40:34
 */
public interface AccountManageServiceI {
	/**
	 * 用户登陆
	 * @param account
	 * @param password
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月19日 下午10:09:24
	 */
	public AccountManage login(String account,String password);
	
}
