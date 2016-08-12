package com.vee.onlinetest.daoimpl;

import com.vee.dao.BaseDAOImpl;
import com.vee.onlinetest.entity.Question;

public class QuestionDAOImpl extends BaseDAOImpl<Question, Integer> {

	public QuestionDAOImpl() {
		super(Question.class);
	}
	
	@Override
	protected void printData(Question question) {
		// TODO Auto-generated method stub
		
	}

}
