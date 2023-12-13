package com.examportal.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="test_mgmt")
public class TestManagement {
	@Id
	@Column(name="test_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int testId;
	@Column(name="courestype")
	private char couresType;
	/*@OneToMany(mappedBy="test_mgmt")
	private List <Result> result;*/
	
	public TestManagement() {
		
	}

}
