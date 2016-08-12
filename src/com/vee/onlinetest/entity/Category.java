package com.vee.onlinetest.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class Category {
	private Integer categoryID;
	private String categoryName;
	private Set<Question> questionList;
	
	public Category() {
	}

	public Category(Integer categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	@Id
	@Column(name="category_id")
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
	public Set<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}
}
