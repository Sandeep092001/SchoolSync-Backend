package com.fees.model;

public class FeesSubmissionDetails {
  
	private Long s_id;
	private String month;
	private String payment_status;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Long getS_id() {
		return s_id;
	}
	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	@Override
	public String toString() {
		return "FeesSubmissionDetails [s_id=" + s_id + ", month=" + month + ", payment_status=" + payment_status + "]";
	}
	
	
	
}
