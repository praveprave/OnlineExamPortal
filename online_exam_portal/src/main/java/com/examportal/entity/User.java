package com.examportal.entity;



import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="user_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;

	@NotBlank(message = "UserName is required")
    @Size(min = 3, max = 50, message = "UserName must be between 3 and 50 characters")
	@Column(name="user_name")
	private String userName;
    @NotBlank(message ="Email is required")
    @Email(message = "Invalid email format")
	@Column(name="user_mail")
	private String userMail;
	@Column(name="mobile_no")
	@NotNull(message = "Mobile number cannot be null")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be a 10-digit number")
	//@Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits")
	private Long mobileNo;
	@Column(name="password")
	@NotBlank(message="Should have password")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String userPassword;
	@Column(name="address")
	@NotBlank(message="Address should not be empty")
	private String userAddress;
	
	/*@OneToOne
	private  UserAddress userAddress;*/
	
	 
	public User() {
		
	}

	public User(int userId, String userName, String userMail, long mobileNo, String userPassword, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
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
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
