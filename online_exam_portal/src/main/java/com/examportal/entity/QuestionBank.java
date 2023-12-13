package com.examportal.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="question_bank")
public class QuestionBank {
	@Id
	@Column(name="question_bank_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionBankId;
	//@OneToMany(mappedBy="test_id")
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="test_id")
	private List <TestManagement> testId=new ArrayList<>();
	@Column(name="question_id")
	private int questionId;
	
	
	public QuestionBank() {
		
	}


	
}
