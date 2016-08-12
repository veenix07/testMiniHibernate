package com.vee.onlinetest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions", catalog="onlinetestdb")
public class Question{

	private Integer questionID;
	private String questionText;
	private Category category;
	private Set<Answer> listAnswer = new HashSet<Answer>();
	
	public Question() {
	}
	
	public Question(Integer questionID, String questionText, Category category) {
		super();
		this.questionID = questionID;
		this.questionText = questionText;
		this.category = category;
	}

	@Id
	@Column(name="question_id")
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	@Column(name="question_text")
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="category_id", nullable=false)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="question")
	public Set<Answer> getListAnswer() {
		return listAnswer;
	}
	public void setListAnswer(Set<Answer> listAnswer) {
		this.listAnswer = listAnswer;
	}
}
