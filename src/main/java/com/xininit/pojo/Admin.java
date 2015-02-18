/**
 */
package com.xininit.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author xin
 * @version 1.0(xin) 2015年2月18日 上午10:37:17
 */
@Entity(name="Admin") //表明当前类是一个持久类,name定义bean名，默认与类名完全相同，所以也可以写成@Entity
@Table(name="admin")
/* table,默认与类的名字相同，当数据库表名与实体类名不一致时，可以用它来指定实体类对应的数据库表名
 * @Table(name = "admin",catalog="my_tmp_db")表示my_tmp_db数据库中的admin表
 */

/*
	@MappedSuperclass
	可以将超类的JPA注解传递给子类,使子类能够继承超类的JPA注解
 */
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String account;
	private String password;
	
	public Admin(){
		
	}
	
	public Admin(String id,String name,String account,String password){
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
	}
	

	/*
	 * 注解也可以写在实体类的字段上面，但是不推荐这么做，字段是设置为private的，若直接使用注解，
	 * 则说明hibernate可以直接获得这些属性，破坏了面向对象的封装性
	 * 
	 * 基于属性（property-based）和基于字段（field-based）的注解的区别
	 * 
	 * ------------------------------------------------------------------
	 *               |         长处              |             短处
	 * ------------------------------------------------------------------
	 *   Field       | 无需定义Accesso——特  | 封锁少，非默认支持，映射更烦
	 *               | 别是setter方法锁        |
	 * -------------------------------------------------------------------
	 *   Property    | 封装，Accessor可转换 | 必须定义Accessor(但可以为private)
	 *               | 值，默认支持                 |
	 *               | 
	 * -------------------------------------------------------------------
	 * 
	 * */
	
	@Id//标记为主键
	@Column(name = "id", unique = true, nullable = false)
	/*
	  name:对应的列名，默认与属性对应的字段名相同
	  unique:唯一约束，默认false
	  nullable:允许为空，默认true
	  length:表示该字段的大小，仅对String类型的字段有效
	  insertable:表示在ORM框架插入操作时，该字段是否应该出现在INSETRT语句中，默认为true
	  updateable:表示在ORM框架执行更新操作时,该字段是否应该出现在UPDATE语句中,默认为true。
	   			  对于一经创建就不可以更改的字段,该属性非常有用,如对于birthday字段.
	  columnDefinition:表示该字段在数据库中的实际类型.通常ORM框架可以根据属性类型自动判断数据库中字段的类型,
	  			  但是对于Date类型仍无法确定数据库中字段类型究竟是DATE,TIME还是TIMESTAMP.此外,String的默认
	  			  映射类型为VARCHAR,如果要将String类型映射到特定数据库的BLOB或TEXT字段类型,该属性非常有用.
	  			  
	   如果字段名相同，不唯一且允许为空，可以直接使用@Column
	*/
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")  
	/*
	 * generator:表示主键生成器的名称，这个属性通常与ORM框架相关
	 * strategy:表示主键生成测量
	      其他主键生成方式
	   1)主键由程序控制
     hibernate用法：
     		@GeneratedValue(generator = "paymentableGenerator")  
	   		@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	   JPA标准用法：
	   		@Id
	   		@GeneratedValue(strategy = GenerationType.AUTO)
	   
	   2)主键的生成工作交由数据库完成（主要用于自增）
	   hibernate用法：nateve——根据数据库自动采取，oracle采用Sequence方式(建立和hibernate_sequence的sequence)，MySql和Sql Server采用identify方式
	   		@GeneratedValue(generator = "paymentableGenerator")  
	   		@GenericGenerator(name = "paymentableGenerator", strategy = "native") 	  	   		 
	   JPA标准用法：
	   		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 * */
	public String getId() {
		return id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "account", unique = true, nullable = false)
	public String getAccount() {
		return account;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
