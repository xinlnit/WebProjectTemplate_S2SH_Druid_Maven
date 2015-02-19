/**
 */
package com.xininit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xininit.dao.AdminDAOI;
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
		Admin admin = new Admin(null,name,account,password);
		return this.addNewAdmin(admin);
	}

	@Override
	public String addNewAdmin(Admin admin) {
		if(admin!=null && admin.getAccount()!=null && admin.getName()!=null && admin.getPassword()!=null){
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

	@Override
	public Admin loginAdmin(String account, String password) {
		return this.adminDAO.getByAccountAndPwd(account, password);
	}
	
	
}
