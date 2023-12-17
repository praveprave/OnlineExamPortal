package com.examportal.dto;

public class AdminLoginDto{

	private int adminId;
	private char adminName;
	private String adminAddress;
	private String adminMail;	
	private String adminPassword;
	public AdminLoginDto(int adminId, char adminName, String adminAddress, String adminMail, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminMail = adminMail;
		this.adminPassword = adminPassword;
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
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}