/**
 */
package com.xininit.aop.handler;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月22日 下午6:48:51
 */
@Aspect
@Component
public class RunTimeHandler {
	private static Logger logger = LoggerFactory.getLogger("org.apache.struts2");  

	@Pointcut(value="execution(public String *()) && !execution(public String toString())" + " && within(com.xininit.controller..*)")
	void timer() {  
	}  

	@Around(value="timer()")  
	public Object time(ProceedingJoinPoint joinPoint) throws Throwable {  

		String clazz = joinPoint.getTarget().getClass().getSimpleName();  
		String method = joinPoint.getSignature().getName();  

		StopWatch clock = new StopWatch();  
		clock.start();  
		Object result = joinPoint.proceed();  
		clock.stop();  

		String[] params = new String[] { clazz, method, clock.getTime() + "" };  
		logger.info(params[0]+"执行"+params[1]+"方法共消耗"+params[2]+"毫秒");  
		System.out.println(params[0]+"执行"+params[1]+"方法共消耗"+params[2]+"毫秒");
		return result;  
	}  
}
