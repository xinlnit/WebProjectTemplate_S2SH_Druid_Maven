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
	private AdminDAOI adminDAOI;

	@Override
	public String addNewAdmin(String name, String account, String password) {
		Admin admin = new Admin(null,name,account,password);
		String id = (String) this.adminDAOI.save(admin);
		if(id!=null){
			return "添加成功";
		}else{
			return "添加失败";
		}
	}

	@Override
	public List<Admin> showAllAdmin() {
		return this.adminDAOI.getAll();
	}
	
	
}
