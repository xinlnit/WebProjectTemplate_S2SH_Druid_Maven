/**
 */
package com.xininit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xininit.dao.AdminDAOI;
import com.xininit.pojo.AccountManage;
import com.xininit.pojo.Admin;
import com.xininit.service.AdminServiceI;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午12:43:40
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminServiceI {
	@Autowired
	private AdminDAOI adminDAO;

	@Override
	public String addNewAdmin(String name, String account, String password) {
		AccountManage accountManage = new AccountManage(null,account,password);
		Admin admin = new Admin(null,name,accountManage);
		return this.addNewAdmin(admin);
	}

	@Override
	public String addNewAdmin(Admin admin) {
		if(admin!=null && admin.getAccountManage()!=null && admin.getAccountManage().getAccount()!=null && admin.getAccountManage().getPassword()!=null && admin.getName()!=null){
			admin.getAccountManage().setAdmin(admin);
			String id = (String) this.adminDAO.save(admin);
			return id;
		}else {
			return null;
		}
	}

	@Override
	public List<Admin> showAllAdmin() {
		return this.adminDAO.showAll();
	}
	
}
