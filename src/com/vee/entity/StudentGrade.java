package com.vee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student", catalog="testdb")
public class StudentGrade extends Student {

	private int grade;

	@Column(name="grade")
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
