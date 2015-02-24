package com.xininit.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月24日 上午12:07:01
 */
@Entity
@Table(name = "account_manage")
public class AccountManage implements Serializable{

	private static final long serialVersionUID = 1L;
	//使用hibernate方式，将主键的生成工作交由数据库完成（主要用于自增）
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "paymentableGenerator")  
	@GenericGenerator(name = "paymentableGenerator", strategy = "native") 
	private Integer id;
	@Column(name = "account", length = 50, nullable = true, unique = true)
	private String account;
	@Column(name = "password", length = 100, nullable = true)
	private String password;
	@OneToOne(mappedBy = "accountManage",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Admin admin;
	@OneToOne(mappedBy = "accountManage",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Student student;
	
	public AccountManage(){}
	
	public AccountManage(Integer id,String account,String password){
		this.id = id;
		this.account = account;
		this.password = password;
	}
	
	public AccountManage(Integer id,String account,String password,Admin admin,Student student){
		this.id = id;
		this.account = account;
		this.password = password;
		this.admin = admin;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
