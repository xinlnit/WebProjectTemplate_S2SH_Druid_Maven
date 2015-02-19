/**
 */
package com.xininit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xininit.pojo.Admin;
import com.xininit.service.AdminServiceI;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月19日 下午9:32:00
 */
@Controller("registerController")
@Scope("prototype")
public class RegisterController extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdminServiceI adminService;
	
	private Admin admin;
	
	/**
	 * 管理员注册
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月19日 下午9:45:48
	 */
	public String adminRegister()throws Exception{
		String rtn = "register";
		if(admin!=null && admin.getAccount()!=null && admin.getPassword()!=null && admin.getName()!=null){
			if(this.adminService.addNewAdmin(admin)!=null){
				rtn = "success";
			}
		}
		return rtn;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
}
