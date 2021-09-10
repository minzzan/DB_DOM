package com.ssafy.dto;

// DTO : Data Transfer Object
// VO : Value Object

public class FavoriteDto {

	private String user_id;
	private String dongcode;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	@Override
	public String toString() {
		return user_id + "\t\t" + dongcode;
	}

}
