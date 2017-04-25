package com.zjj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * 
 * @author ZJJ-PC
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6495621052537489147L;
	private String username;
	private String userpwd;
	private int sex;
	private String birthday;
	private String identity;
	private String email;
	private String phone;
	private int addressid;
	private String headpic;

	public User() {

	}

	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}



	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public User(String username, String userpwd, int sex, String birthday,
			String identity, String email, String phone, int addressid, String headpic) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.phone = phone;
		this.addressid = addressid;
		this.headpic = headpic;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userpwd=" + userpwd + ", sex="
				+ sex + ", birthday=" + birthday + ", identity=" + identity
				+ ", email=" + email + ", phone=" + phone + ", addressid="
				+ addressid + ", headpic=" + headpic + "]";
	}

}
