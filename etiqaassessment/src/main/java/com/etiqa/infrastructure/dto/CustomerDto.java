package com.etiqa.infrastructure.dto;

import java.sql.Timestamp;

public class CustomerDto {

	private Long custId;

	private String custFirstName;

	private String custLastName;

	private String custMobNo;

	private String custEmail;

	private Boolean custStatus;

	private Timestamp custCreatedDate;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustMobNo() {
		return custMobNo;
	}

	public void setCustMobNo(String custMobNo) {
		this.custMobNo = custMobNo;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Boolean getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(Boolean status) {
		this.custStatus = custStatus;
	}

	public Timestamp getCustCreatedDate() {
		return custCreatedDate;
	}

	public void setCustCreatedDate(Timestamp custCreatedDate) {
		this.custCreatedDate = custCreatedDate;
	}

}
