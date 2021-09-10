package com.ssafy.dto;

// DTO : Data Transfer Object
// VO : Value Object

public class HouseDealDto {

	private int no;
	private String dong;
	private String aptName;
	private String code;
	private String dealAmount;
	private String buildYear;
	private String lat;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String jibun;
	private String type;
	private String rentMoney;
	private String dongCode;
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getAptName() {
		return aptName;
	}


	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDealAmount() {
		return dealAmount;
	}


	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}


	public String getBuildYear() {
		return buildYear;
	}


	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getDealYear() {
		return dealYear;
	}


	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}


	public String getDealMonth() {
		return dealMonth;
	}


	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}


	public String getDealDay() {
		return dealDay;
	}


	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getJibun() {
		return jibun;
	}


	public void setJibun(String jibun) {
		this.jibun = jibun;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRentMoney() {
		return rentMoney;
	}


	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	
	public String getDongCode() {
		return dongCode;
	}


	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	
	@Override
	public String toString() {
		return no + "\t" + dong + "\t" + aptName + "\t" + code + "\t"
				+ dealAmount + "\t" + buildYear + "\t" + lat + "\t" + dealYear + "\t"
				+ dealMonth + "\t" + dealDay + "\t" + area + "\t" + floor + "\t" + jibun
				+ "\t" + type + "\t" + rentMoney + "\t" + dongCode;
	}

	
}
