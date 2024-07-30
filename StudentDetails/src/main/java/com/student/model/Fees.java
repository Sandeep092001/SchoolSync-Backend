package com.student.model;

public class Fees {
	
	private Long s_id;
	
	private String January;
	private String February;
	private String March;
	private String April;
	private String May;
	private String June;
	private String July;
	private String August;
	private String September;
	private String October;
	private String November;
	private String December;
	
	public Long getS_id() {
		return s_id;
	}
	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}
	public String getJanuary() {
		return January;
	}
	public void setJanuary(String january) {
		January = january;
	}
	public String getFebruary() {
		return February;
	}
	public void setFebruary(String february) {
		February = february;
	}
	public String getMarch() {
		return March;
	}
	public void setMarch(String march) {
		March = march;
	}
	public String getApril() {
		return April;
	}
	public void setApril(String april) {
		April = april;
	}
	public String getMay() {
		return May;
	}
	public void setMay(String may) {
		May = may;
	}
	public String getJune() {
		return June;
	}
	public void setJune(String june) {
		June = june;
	}
	public String getJuly() {
		return July;
	}
	public void setJuly(String july) {
		July = july;
	}
	public String getAugust() {
		return August;
	}
	public void setAugust(String august) {
		August = august;
	}
	public String getSeptember() {
		return September;
	}
	public void setSeptember(String september) {
		September = september;
	}
	public String getOctober() {
		return October;
	}
	public void setOctober(String october) {
		October = october;
	}
	public String getNovember() {
		return November;
	}
	public void setNovember(String november) {
		November = november;
	}
	public String getDecember() {
		return December;
	}
	public void setDecember(String december) {
		December = december;
	}
	@Override
	public String toString() {
		return "Fees [s_id=" + s_id + ", January=" + January + ", February=" + February + ", March=" + March
				+ ", April=" + April + ", May=" + May + ", June=" + June + ", July=" + July + ", August=" + August
				+ ", September=" + September + ", October=" + October + ", November=" + November + ", December="
				+ December + "]";
	}
	
}