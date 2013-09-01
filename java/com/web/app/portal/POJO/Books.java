package com.web.app.portal.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

	@Id
	@Column(name="b_id")
	@GeneratedValue(generator="AUTO_SEQ")
    @SequenceGenerator(name="AUTO_SEQ",sequenceName="AUTO_SEQ", allocationSize=1)
	private int b_id;
	
	@Column(name="b_name")
	private String b_name;
	
	@Column(name="b_author")
	private String b_author;
	
	public String getPreviewLoc() {
		return previewLoc;
	}

	public void setPreviewLoc(String previewLoc) {
		this.previewLoc = previewLoc;
	}

	@Column(name="b_edition")
	private String b_edition;
	
	@Column(name="b_description")
	private String b_description;
	
	@Column(name="b_owner")
	private int b_owner;

	
	@Column(name="previewLoc")
	private String previewLoc;
	
	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_edition() {
		return b_edition;
	}

	public void setB_edition(String b_edition) {
		this.b_edition = b_edition;
	}

	public String getB_description() {
		return b_description;
	}

	public void setB_description(String b_description) {
		this.b_description = b_description;
	}

	public int getB_owner() {
		return b_owner;
	}

	public void setB_owner(int b_owner) {
		this.b_owner = b_owner;
	}
	
	
	
}
