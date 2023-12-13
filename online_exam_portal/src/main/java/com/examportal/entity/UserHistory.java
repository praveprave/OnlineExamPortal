package com.examportal.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userhistory")
public class UserHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userHistoryId;
	@Column(name="test_score")
	private int testScore;
	@Column(name="test_date")
	private Date testDate;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="test_id")
	private TestManagement testManagement;
	public UserHistory() {
		
	}
	
	public UserHistory(int userHistoryId, int testScore, Date testDate, User user, TestManagement testManagement) {
		super();
		this.userHistoryId = userHistoryId;
		this.testScore = testScore;
		this.testDate = testDate;
		this.user = user;
		this.testManagement = testManagement;
	}

	
	public int getUserHistoryId() {
		return userHistoryId;
	}

	public void setUserHistoryId(int userHistoryId) {
		this.userHistoryId = userHistoryId;
	}

	public int getTestScore() {
		return testScore;
	}
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	public User getUsers() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TestManagement getTestManagement() {
		return testManagement;
	}
	public void setTestManagement(TestManagement testManagement) {
		this.testManagement = testManagement;
	}
	

}
