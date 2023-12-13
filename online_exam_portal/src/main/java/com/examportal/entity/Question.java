package com.examportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int questionId;
private String optionA;
private String optionB;
private String optionC;
private String optionD;
@ManyToOne
@JoinColumn(name="question_bank_id")
private QuestionBank questionBank;

public Question() {}

public Question(int questionId, String optionA, String optionB, String optionC, String optionD,
		QuestionBank questionBank) {
	super();
	this.questionId = questionId;
	this.optionA = optionA;
	this.optionB = optionB;
	this.optionC = optionC;
	this.optionD = optionD;
	this.questionBank = questionBank;
}

public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public String getOptionA() {
	return optionA;
}
public void setOptionA(String optionA) {
	this.optionA = optionA;
}
public String getOptionB() {
	return optionB;
}
public void setOptionB(String optionB) {
	this.optionB = optionB;
}
public String getOptionC() {
	return optionC;
}
public void setOptionC(String optionC) {
	this.optionC = optionC;
}
public String getOptionD() {
	return optionD;
}
public void setOptionD(String optionD) {
	this.optionD = optionD;
}
public QuestionBank getQuestionBank() {
	return questionBank;
}
public void setQuestionBank(QuestionBank questionBank) {
	this.questionBank = questionBank;
}



}
