package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String username;
	private String email;
	private String unit;
	private String sex;
	private int userid;
	private String Phone;
	private String IDcard;
	
	
	public User(String username,int userid,String sex,String unit,String email,String IDcard,String Phone) {
		super();
		this.username= username;
		this.userid=userid;
		this.sex = sex;
		this.unit = unit;
		this.email = email;
		this.IDcard=IDcard;
		this.Phone=Phone;
	}
	public User() {};
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String IDcard) {
		this.IDcard=IDcard;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone=Phone;
	}
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid=userid;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}