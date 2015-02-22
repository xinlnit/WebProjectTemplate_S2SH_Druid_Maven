/**
 */
package com.xininit.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：用于设置action异常返回result，默认error
 * @author xin
 * @version 1.0(xin) 2015年2月22日 下午5:46:54
 */
/*
 * @Target表示支持注解的程序元素的种类，一些可能的值有TYPE, METHOD, CONSTRUCTOR, FIELD等等。
 * 如果Target元注解不存在，那么该注解就可以使用在任何程序元素之上
 */
@Target(ElementType.METHOD)
/*
 * @Retention表示注解类型保留时间的长短，它接收RetentionPolicy参数，可能的值有SOURCE, CLASS, 以及RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StrutsResult {
	/*
	 * 注解方法不能有参数。
	 * 注解方法的返回类型局限于原始类型，字符串，枚举，注解，或以上类型构成的数组。
	 * 注解方法可以包含默认值。
	 * 注解可以包含与其绑定的元注解，元注解为注解提供信息，有四种元注解类型
	 */
	/**
	 * 异常发生后返回的result的值，默认是error
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月22日 下午11:22:01
	 */
	public String error()default "error";
}
