package com.xininit.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xininit.pojo.Admin;
import com.xininit.service.AdminServiceI;


public class AdminService {
	public static void main(String[] args)throws Exception{
		/**
		 * Spring提供的读取配置文件方法,此处推荐使用ApplicationContext而非BeanFactory. 
		 * beans配置文件默认读取src根目录文件名相同的XML文件 
		 * 如果需要放在特殊的位置,那么需要指定具体路径，比如：com/bijian/xml/beans.xml 
		 */  
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");  
		/**
		 * 获取LoginAccountService.java中利用@Service("AdminService")自动装载的bean 
		 *  
		 */  
		AdminServiceI adminService =  (AdminServiceI) ctx.getBean("AdminService");  
		System.out.println(adminService.addNewAdmin("adminName", "adminAccount", "adminPassword"));
		List<Admin> adminList = adminService.showAllAdmin();
		for(Admin admin:adminList){
			System.out.println("输出"+admin.getName());
		}
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
