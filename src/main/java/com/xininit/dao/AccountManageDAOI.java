package com.xininit.dao;

import com.xininit.pojo.AccountManage;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:29:53
 */
public interface AccountManageDAOI extends EntityBaseDAOI<AccountManage, String>{
	/**
	 * 根据账号和密码查询登陆用户
	 * @param account
	 * @param password
	 * @return 无返回null
	 * @author xin
	 * @version 1.0(xin) 2015年2月19日 下午10:04:37
	 */
	public AccountManage getByAccountAndPwd(String account,String password);
}
