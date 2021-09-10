package com.ssafy.dto;

// DTO : Data Transfer Object
// VO : Value Object

public class EcoDto {

	private int idx;
	private String companyName;
	private String licenseNumber;
	private String businessCode;
	private String businessName;
	private String inspectionDate;
	private String agencyCode;
	private String agencyName;
	private String isDisposed;
	private String inspection;
	private String roadAddress;
	
	
	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public String getBusinessCode() {
		return businessCode;
	}


	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}



	public String getInspectionDate() {
		return inspectionDate;
	}


	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}


	public String getAgencyCode() {
		return agencyCode;
	}


	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}


	public String getAgencyName() {
		return agencyName;
	}


	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}


	public String getIsDisposed() {
		return isDisposed;
	}


	public void setIsDisposed(String isDisposed) {
		this.isDisposed = isDisposed;
	}


	public String getInspection() {
		return inspection;
	}


	public void setInspection(String inspection) {
		this.inspection = inspection;
	}


	public String getRoadAddress() {
		return roadAddress;
	}


	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}


	@Override
	public String toString() {
		return idx + "\t" + companyName + "\t" + licenseNumber
				+ "\t" + businessCode + "\t" + businessName
				+ "\t" + inspectionDate + "\t" + agencyCode + "\t" + agencyName
				+ "\t" + isDisposed + "\t" + inspection + "\t" + roadAddress ;
	}
	
	

	
}
