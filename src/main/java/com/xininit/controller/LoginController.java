/**
 */
package com.xininit.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 上午10:41:34
 */
public class LoginController extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	
	/**
	 * 登陆验证
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 上午10:58:42
	 * @return
	 */
	public String login(){
		if("admin".equals(account) && "admin".equals(password)){
			return "admin";
		}else{
			return "login";
		}
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
