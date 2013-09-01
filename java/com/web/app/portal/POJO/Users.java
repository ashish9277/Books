package com.web.app.portal.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {


	@Id
	@Column(name="u_id")
	@GeneratedValue(generator="AUTO_SEQ")
    @SequenceGenerator(name="AUTO_SEQ",sequenceName="AUTO_SEQ", allocationSize=1)
	private int u_id;
	
	@Column(name="u_name")
	private String u_name;
	
	@Column(name="u_password")
	private String u_password;
	

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
}
