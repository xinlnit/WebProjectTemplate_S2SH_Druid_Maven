/**
 */
package com.xininit.pojo;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 上午10:37:17
 */
public class Admin {

	private String id;
	private String name;
	private String account;
	private String password;
	
	public Admin(){
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
