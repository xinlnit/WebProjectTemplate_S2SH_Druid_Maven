package com.xininit.service;

import com.xininit.pojo.Student;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:39:34
 */
public interface StudentServiceI {
	/**
	 * 添加一名新的学生
	 * @param student
	 * @return
	 * @author xin
	 * @version 1.0(xin) 2015年2月24日 上午1:14:46
	 */
	public Integer addNewStudent(Student student);
}
