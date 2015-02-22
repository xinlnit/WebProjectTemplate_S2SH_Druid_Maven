/**
 */
package com.xininit.aop.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
	/*
	 * @Around:环绕通知(Around advice):包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。可以在方法的调用前后完成自定义的行为，也可以选择不执行。
	 * @Before:前置通知(Before advice):在某连接点(JoinPoint)之前执行的通知
	 * @After:后置通知(After advice):当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
	 * @AfterReturning:返回后通知(After return advice):在某连接点正常完成后执行的通知，不包括抛出异常的情况。
	 * @AfterThrowing:抛出异常后通知(After throwing advice):在方法抛出异常退出时执行的通知。
	 */
	@Around("execution(public * com.xininit.controller..*Controller.*(..))")//匹配所有com.xininit.controller包及其子包下的所有以Controller结尾的类的所有方法
	/*
	 * execution(modifier-pattern? ret-type-pattern declaring-type-pattern?  name-pattern(param-pattern) throws-pattern?) 
	 * execution(* *(..)) 表示匹配所有方法
	 * @annotation(com.xininit.aop.annotation.StrutsResult) 表示匹配使用了StrutsResult注解的方法
	 */
	public Object actionAround(ProceedingJoinPoint joinPoint) {    
		Object result = null;//返回值
        HttpServletRequest request = ServletActionContext.getRequest();
		try {  
			result = joinPoint.proceed();
			joinPoint.proceed(joinPoint.getArgs());
		}catch(SQLException e) {
			e.printStackTrace();
			result = "error";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("SQLException");
		}catch(Exception e){
			e.printStackTrace();
			result = "error";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Exception");
		}catch(Throwable e){
			e.printStackTrace();
			result = "error";
			request.setAttribute("exception", e);
			request.setAttribute("exceptionStack", e.getStackTrace());
			System.out.println("Throwable");
		}  
		return result;
	}

}  