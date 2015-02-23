/**
 */
package com.xininit.aop.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 全局异常管理
 * @author xin
 * @version 1.0(xin) 2015年2月22日 下午5:49:08
 */
@Aspect//注解该类为切面类
@Component//注入依赖
public class GloabExceptionHandler {
	
	public Object actionAround(ProceedingJoinPoint joinPoint) {    
		Object result = null;//返回值
        HttpServletRequest request = ServletActionContext.getRequest();
		try {  
			result = joinPoint.proceed();
			joinPoint.proceed(joinPoint.getArgs());
		}catch(SQLException e) {
			e.printStackTrace();
			result = "aspectError";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("SQLException");
		}catch(Exception e){
			e.printStackTrace();
			result = "aspectError";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Exception");
		}catch(Throwable e){
			e.printStackTrace();
			result = "aspectError";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Throwable");
		}  
		return result;
	}

}  