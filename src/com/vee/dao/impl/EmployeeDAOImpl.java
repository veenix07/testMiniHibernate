package com.vee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.vee.dao.BaseDAOImpl;
import com.vee.entity.Department;
import com.vee.entity.Employee;

public class EmployeeDAOImpl extends BaseDAOImpl<Employee, Integer> {

	public EmployeeDAOImpl() {
		super(Employee.class);
	}
	
	@Override
	protected void printData(Employee e) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Employee> findByDepartment(Department dept){
		EntityManager em = getSessionFactory().createEntityManager();
		CriteriaBuilder critBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = critBuilder.createQuery(type);
		Root<Employee> from = criteriaQuery.from(Employee.class);
		TypedQuery<Employee> typedQuery = em.createQuery(criteriaQuery.select(from));
		
		return typedQuery.getResultList();
	}
}
