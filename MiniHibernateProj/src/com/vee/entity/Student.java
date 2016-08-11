package com.vee.entity;

public class Student {

	private String name;
	private String studentId;

	public Student(){}
	
	public Student(String studentId, String name) {
		super();
		this.name = name;
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
