package com.kgate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
	@Id
	private long phoneNumber;

	private String feedback;
	private String duration;
	private String dateTime;
	private String percentage;
	private Long noOfAttempts;

	// @OneToMany
//	@JoinTable(name = "user_question", joinColumns = { @JoinColumn(name = "phoneNumber") }, inverseJoinColumns = {
//			@JoinColumn(name = "mobile") })
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "phoneNumber")
	private List<Question> questions = new ArrayList<>();

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Long noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "UserInfo [phoneNumber=" + phoneNumber + ", feedback=" + feedback + ", duration=" + duration
				+ ", dateTime=" + dateTime + ", percentage=" + percentage + ", noOfAttempts="
				+ noOfAttempts + ", questions=" + questions + "]";
	}
}
