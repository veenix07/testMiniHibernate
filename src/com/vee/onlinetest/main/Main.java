package com.vee.onlinetest.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vee.onlinetest.daoimpl.AnswerDAOImpl;
import com.vee.onlinetest.daoimpl.CategoryDAOImpl;
import com.vee.onlinetest.daoimpl.QuestionDAOImpl;
import com.vee.onlinetest.entity.Answer;
import com.vee.onlinetest.entity.Category;
import com.vee.onlinetest.entity.Question;

public class Main {
	
	public static void removeCategoriesData(){
		CategoryDAOImpl cdao = new CategoryDAOImpl();
		List<Category> categories = cdao.list();
		for(Category cat : categories){
			cdao.delete(cat);
		}
	}

	public static Category createCategory(Integer id, String categoryName){
		return new Category(id, categoryName);
	}
	
	public static void printOutCategoryData(){
		CategoryDAOImpl cdao = new CategoryDAOImpl();
		List<Category> categories = cdao.list();
		for(Category cat : categories){
			System.out.println("---------"+cat.getCategoryName()+"---------");
			if(cat.getQuestionList().size()>0){
				for(Question q : cat.getQuestionList()){
					System.out.println("------" + q.getQuestionText());
					if(q.getListAnswer().size()>0){
						for(Answer ans : q.getListAnswer()){
							System.out.println("------> "+ans.getAnswerText()+" - "+ans.isAnswerBool() );
						}
					}
				}
			}
		}
	}
	
	public static void testOne(){
		CategoryDAOImpl cdao = new CategoryDAOImpl();
		Category categoryMath = createCategory(3, "Mathematics 101");
		Question q1 = new Question(1, "1 + 1 =", categoryMath);
		Question q2 = new Question(2, "1 / 3 =", categoryMath);
		Set<Question> questionList = new HashSet<Question>();
		questionList.add(q1);
		questionList.add(q2);
		categoryMath.setQuestionList(questionList);
		cdao.create(categoryMath);
		
		QuestionDAOImpl qdao = new QuestionDAOImpl();
		for(Question q : questionList){
			qdao.create(q);
		}
	}
	
	public static void main(String[] args){
		printOutCategoryData();
	}
}
