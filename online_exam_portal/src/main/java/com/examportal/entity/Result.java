package com.examportal.entity;



import java.sql.Date;
import java.util.List;

//import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="result")
public class Result {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="result_id")
	private int resultId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="test_id")
	private TestManagement testManagement;
	@Column(name="question_id")
	private int questionId;
	@Column(name="exam_date")
	private Date examDate;
	@Column(name="exam_score")
	private int examScore;
	
	public Result() {
		
	}

	public Result(int resultId, User user, TestManagement testManagement, int questionId, Date examDate,
			int examScore) {
		super();
		this.resultId = resultId;
		this.user = user;
		this.testManagement = testManagement;
		this.questionId = questionId;
		this.examDate = examDate;
		this.examScore = examScore;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public User getUser() {
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

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getExamScore() {
		return examScore;
	}

	public void setExamScore(int examScore) {
		this.examScore = examScore;
	}

	
}
