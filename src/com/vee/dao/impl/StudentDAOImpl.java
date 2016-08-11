package com.vee.dao.impl;

import com.vee.dao.BaseDAOImpl;
import com.vee.entity.Student;

public class StudentDAOImpl extends BaseDAOImpl<Student,String> {

	public StudentDAOImpl() {
		super(Student.class);
	}
	
	@Override
	protected void printData(Student e) {
		System.out.println("-------- Student Data ------------");
		System.out.println("Student ID : "+ e.getStudentId());
		System.out.println("Name : " + e.getName());
	}

}
