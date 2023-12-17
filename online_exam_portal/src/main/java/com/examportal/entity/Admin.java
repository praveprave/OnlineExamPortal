package com.examportal.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="admin_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	@Column(name="admin_name")
	private char adminName;
	@Column(name="admin_address")
	private String adminAddress;
	@Column(name="admin_mail")
	private String adminMail;
	
	/*@OneToMany
	private List<Users>users= new ArrayList<>();
	@OneToOne
	private TestManagement testManagement;*/
	
	
	public Admin() {
		
	}

	public Admin(int adminId, char adminName, String adminAddress, String adminMail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminMail = adminMail;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public char getAdminName() {
		return adminName;
	}

	public void setAdminName(char adminName) {
		this.adminName = adminName;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getAdminPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
