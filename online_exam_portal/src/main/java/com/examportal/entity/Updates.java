package com.examportal.entity;

import java.time.LocalTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="updates")
public class Updates {
	@Id
	@Column(name="update")
	private int updateId;
	@Column(name="time_stamp")
	private LocalTime timeStamp;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id")
	Admin admin;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="test_id")
	TestManagement testManagement;
	public Updates() {}

}
