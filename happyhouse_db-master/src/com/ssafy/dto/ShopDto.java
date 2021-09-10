package com.ssafy.dto;

// DTO : Data Transfer Object
// VO : Value Object

public class ShopDto {

	private String dongcode;
	private String shopName;
	private String shopkind;
	private String shopAddress;
	

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopkind() {
		return shopkind;
	}

	public void setShopkind(String shopkind) {
		this.shopkind = shopkind;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	@Override
	public String toString() {
		return dongcode + "\t\t" + shopName + "\t\t" + shopkind
				+ "\t\t" + shopAddress;
	}

}
