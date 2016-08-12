package com.vee.onlinetest.daoimpl;

import com.vee.dao.BaseDAOImpl;
import com.vee.onlinetest.entity.Category;

public class CategoryDAOImpl extends BaseDAOImpl<Category, Integer> {

	public CategoryDAOImpl() {
		super(Category.class);
	}
	
	@Override
	protected void printData(Category e) {
		// TODO Auto-generated method stub
		
	}

}
