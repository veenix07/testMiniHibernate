package com.vee.main;

import java.util.List;

import com.vee.onlinetest.daoimpl.CategoryDAOImpl;
import com.vee.onlinetest.daoimpl.QuestionDAOImpl;
import com.vee.onlinetest.entity.Category;
import com.vee.onlinetest.entity.Question;

public class MainOnlineTest {

	private static CategoryDAOImpl categoryDAO;
	private static QuestionDAOImpl questionDAO;
	
	private static CategoryDAOImpl getCategoryDAO(){
		if(categoryDAO!=null){
			return categoryDAO;
		}
		return new CategoryDAOImpl();
	}
	
	private static QuestionDAOImpl getQuestionDAO(){
		if(questionDAO!=null)
			return questionDAO;
		return new QuestionDAOImpl();
	}
	
	private static void listCategoryWithQuestions(){
		List<Category> categories = getCategoryDAO().list();
		for(Category category : categories){
			System.out.println(category.getCategoryName());
			for(Question question : category.getQuestionList()){
				System.out.println(question.getQuestionText());
			}
		}
	}
	
	private static void listObjectByCriteria(){
		List<Question> questions = getQuestionDAO().findByCriteria("questionID", "2");
		for(Question question : questions){
			System.out.println(question.getQuestionID() + " " + question.getQuestionText());
		}
	}
	
	public static void main(String[] args){
		listObjectByCriteria();
	}
}
