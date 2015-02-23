package com.xininit.dao.impl;

import org.springframework.stereotype.Repository;

import com.xininit.dao.StudentDAOI;
import com.xininit.pojo.Student;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:33:45
 */
@Repository("studentDAO")
public class StudentDAOImpl extends EntityBaseDAOImpl<Student, Integer> implements StudentDAOI{

	@Override
	public Class<Student> getEntityClass() {
		return Student.class;
	}
	
}
