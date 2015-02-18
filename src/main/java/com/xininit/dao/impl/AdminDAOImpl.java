/**
 */
package com.xininit.dao.impl;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xininit.dao.AdminDAOI;
import com.xininit.pojo.Admin;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 下午12:42:46
 */
@Repository("adminDAO")
public class AdminDAOImpl extends EntityBaseDAOImpl<Admin, String> implements AdminDAOI{

	@Override
	public Class<Admin> getEntityClass() {
		return Admin.class;
	}


}
