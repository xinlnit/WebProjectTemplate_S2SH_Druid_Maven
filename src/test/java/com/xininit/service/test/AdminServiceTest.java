package com.xininit.service.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xininit.pojo.Admin;
import com.xininit.service.AdminServiceI;
import com.xininit.util.test.OpenSessionInApplicationUtil;


public class AdminServiceTest {
	public static void main(String[] args)throws Exception{
		/**
		 * Spring提供的读取配置文件方法,此处推荐使用ApplicationContext而非BeanFactory. 
		 * beans配置文件默认读取src根目录文件名相同的XML文件 
		 * 如果需要放在特殊的位置,那么需要指定具体路径，比如：com/bijian/xml/beans.xml 
		 */  
		ApplicationContext atcx = new ClassPathXmlApplicationContext("beans.xml");  
		SessionFactory sessionFactory;
		sessionFactory = (SessionFactory) atcx.getBean("sessionFactory");
		OpenSessionInApplicationUtil.before(sessionFactory);
		
		/**
		 * 获取LoginAccountService.java中利用@Service("AdminService")自动装载的bean 
		 *  
		 */   
		AdminServiceI adminService =  (AdminServiceI) atcx.getBean("AdminService");  
		System.out.println(adminService.addNewAdmin("adminName", "adminAccount", "adminPassword"));
		//下面的showAllAdmin执行时没有数据，原因是事务还没有提交，调用flush方法强制提交事务
		//sessionFactory.getCurrentSession().flush();配置后可以自动提交事务，因此不需要再调用flush方法
		List<Admin> adminList = adminService.showAllAdmin();
		for(Admin admin:adminList){
			System.out.println("输出"+admin.getName());
		}
		
		OpenSessionInApplicationUtil.after(sessionFactory);
		((ClassPathXmlApplicationContext)atcx).close();
	}
}
