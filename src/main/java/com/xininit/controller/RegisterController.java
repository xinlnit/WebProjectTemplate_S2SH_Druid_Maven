/**
 */
package com.xininit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xininit.pojo.Admin;
import com.xininit.pojo.Student;
import com.xininit.service.AdminServiceI;
import com.xininit.service.StudentServiceI;

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
	@Autowired
	private StudentServiceI studentService;
	
	private Admin admin;
	private Student student;
	
	/**
	 * 管理员注册
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月19日 下午9:45:48
	 */
	public String adminRegister(){
		String rtn = "register";
		if(this.adminService.addNewAdmin(admin)!=null){
				rtn = "success";
		}
		return rtn;
	}
	
	/**
	 * 学生注册
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月24日 上午1:11:50
	 */
	public String studentRegister(){
		String rtn = "register";
		if(this.studentService.addNewStudent(student)!=null){
				rtn = "success";
		}
		return rtn;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
