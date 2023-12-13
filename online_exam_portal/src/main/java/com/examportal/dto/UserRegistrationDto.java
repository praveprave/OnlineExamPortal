package com.examportal.dto;



public class UserRegistrationDto {
	
	private int userId;
	//@NotBlank(message ="UserName cannot be blank")
	private String UserName;
	private String userMail;
	private long mobileNo;
	private String userPassword;
	private String userAddress;
	public UserRegistrationDto() {}
	public UserRegistrationDto(int userId, String userName, String userMail, long mobileNo, String userPassword,
			String userAddress) {
		super();
		this.userId = userId;
		UserName = userName;
		this.userMail = userMail;
		this.mobileNo = mobileNo;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	

}
