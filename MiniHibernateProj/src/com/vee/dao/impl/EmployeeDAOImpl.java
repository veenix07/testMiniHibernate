package com.vee.dao.impl;

import com.vee.dao.BaseDAOImpl;
import com.vee.entity.Employee;

public class EmployeeDAOImpl extends BaseDAOImpl<Employee, Integer> {

	public EmployeeDAOImpl() {
		super(Employee.class);
	}
	
	@Override
	protected void printData(Employee e) {
		// TODO Auto-generated method stub
		
	}
}
