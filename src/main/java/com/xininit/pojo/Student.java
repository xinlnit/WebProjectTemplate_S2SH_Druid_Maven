package com.xininit.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:06:04
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String name;
	
	private AccountManage accountManage;
	
	public Student(){}
	@Id
	//使用JPA方式，主键的生成工作交由数据库完成（主要用于自增）
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_manage_id")
	public AccountManage getAccountManage() {
		return accountManage;
	}

	public void setAccountManage(AccountManage accountManage) {
		this.accountManage = accountManage;
	}
	
	
}
