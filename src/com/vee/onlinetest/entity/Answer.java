package com.vee.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answers", catalog="onlinetestdb")
public class Answer {
	
	private Integer answerID;
	private String answerText;
	private boolean answerBool;
	private Question question;

	public Answer() {
	}
	
	public Answer(Integer answerID, String answerText, boolean answerBool, Question question) {
		super();
		this.answerID = answerID;
		this.answerText = answerText;
		this.answerBool = answerBool;
		this.question = question;
	}

	@Id
	@Column(name="answer_id")
	public Integer getAnswerID() {
		return answerID;
	}
	public void setAnswerID(Integer answerID) {
		this.answerID = answerID;
	}
	@Column(name="answer_text")
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	@Column(name="answer_bool")
	public boolean isAnswerBool() {
		return answerBool;
	}
	public void setAnswerBool(boolean answerBool) {
		this.answerBool = answerBool;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question_id")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
