package com.vee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student", catalog="testdb")
public class Student {

	private String name;
	private String studentId;

	public Student(){}
	
	public Student(String studentId, String name) {
		super();
		this.name = name;
		this.studentId = studentId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@Column(name="studentId")
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
