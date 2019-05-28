package com.kgate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mobile;
	private String objective;
	private String qNo;
	private String question;
	private String options;
	private String result;
	private String type;

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getqNo() {
		return qNo;
	}

	public void setqNo(String qNo) {
		this.qNo = qNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Question [mobile=" + mobile + ", objective=" + objective + ", qNo=" + qNo + ", question="
				+ question + ", options=" + options + ", result=" + result + ", type=" + type
				+ "]";
	}
}
