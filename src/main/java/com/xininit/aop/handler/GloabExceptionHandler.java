/**
 */
package com.xininit.aop.handler;

import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.xininit.aop.annotation.StrutsResult;

/**
 * 全局异常管理
 * @author xin
 * @version 1.0(xin) 2015年2月22日 下午5:49:08
 */
@Aspect
@Component
public class GloabExceptionHandler {
	@Around("@annotation(com.xininit.aop.annotation.StrutsResult)")
	public Object actionAround(ProceedingJoinPoint joinPoint) {    
		StrutsResult sr = obtainStrutsResultAnnotation(joinPoint.getSignature() , joinPoint.getTarget());  
		Object result = null;//返回值
		
		HttpServletRequest request = ServletActionContext.getRequest();
		try {  
			result = joinPoint.proceed();
			joinPoint.proceed(joinPoint.getArgs());
		}catch(SQLException e) {
			e.printStackTrace();
			result = sr.error();
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("SQLException");
		}catch(Exception e){
			e.printStackTrace();
			result = sr.error();
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Exception");
		}catch(Throwable e){
			e.printStackTrace();
			result = sr.error();
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Throwable");
		}  
		return result;
	}  


	/** 
	 * 获取StrutsResult对象，根据方法签名
	 * @return 
	 */  
	public StrutsResult obtainStrutsResultAnnotation(Signature sig , Object target){  
		try {  
			String methodName = sig.getName();  
			Method method = target.getClass().getMethod(methodName) ;  
			StrutsResult sr = method.getAnnotation(StrutsResult.class);  
			return sr ;  
		} catch (NoSuchMethodException e) {  
			e.printStackTrace();  
		} catch (SecurityException e) {  
			e.printStackTrace();  
		}  
		return null ;  
	}  

}  