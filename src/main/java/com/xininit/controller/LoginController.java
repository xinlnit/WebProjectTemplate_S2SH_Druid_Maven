/**
 */
package com.xininit.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xininit.pojo.Admin;
import com.xininit.service.AdminServiceI;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 上午10:41:34
 */
/*
 * @Controller:控制器（注入服务）用于标注控制层组件（如struts中的action）,默认首字母小写
 */
@Controller
/*
  @RequestMapping("/user.do")//访问名，因为打算使用struts2配置，所以不使用 
  RequestMapping是一种通过匹配URL路径来访问相应页面的，分为类级别的和方法级别的
    属性
  value:value="...str...",指定请求的实际地址，指定的地址可以是URI Template模式,使用@RequestMapping("...str...")默认为value值
  method:method = RequestMethod.POST,指定请求的method类型，GET/POST/PUT/DELETE等
  
  consumes:consumes="application/json",指定处理请求的提交内容类型(Content-type)，例如application/json，text/html
  produces:produces="application/json"),指定返回的内容类型,仅当request请求头中的(Accept)类型中包含该指定类型才返回
  
  params:指定request中必须包含某些参数值是，才让该方法处理。
  		例如：params="myParam=myValue"，仅处理请求中包含了名为myParam,值为myValue的请求
  headers:指定request中必须包含某些指定的header值,才能让该方法处理请求。
  		例如： headers="Referer=http://www.ifeng.com/"),仅处理request的header中包含了指定“Refer”请求头和对应值为“http://www.ifeng.com/”的请求
 
  */

@Scope("prototype")
/*
  Spring默认scope是单列模式,struts2是要求每次访问都对应不同的Action，scope=”prototype”可以保证当有请求的时候，都创建一个Action对象
 (注意：单列模式只会创建一个Action对象，如果struts2的Action采用单列模式，那么每次访问都是同一个Action对象，数据不安全，而且单例模式bean在spring加载时实例化，这时候ServletActionContext还没有创建，使用会报null错误)
  
  Scope的5种属性
  singleton:表示在spring容器中的单例，通过spring容器获得该bean时总是返回唯一的实例
  prototype:表示每次获得bean都会生成一个新的对象
  request:表示在一次http请求内有效(只适用于Web应用)
  session:表示在一个用户会话内有效(只适用于Web应用)
  globalSession:表示在全局会话内有效(只适用于Web应用)
 */
public class LoginController extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminServiceI adminService;
	
	private Admin admin;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
		
	private String account;
	private String password;
	
	private Date myDate;//用于英文环境下返回2015-01-01的异常测试(未解决)
	
	/**
	 * 登陆验证
	 * @author xin
	 * @version 1.0(xin) 2015年2月18日 上午10:58:42
	 * @return
	 */
	public String login(){	
		//com.opensymphony.xwork2.DefaultActionInvocation
		admin = this.adminService.loginAdmin(account, password);
		if(admin!=null){
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("loginName", admin.getName());
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

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
}
