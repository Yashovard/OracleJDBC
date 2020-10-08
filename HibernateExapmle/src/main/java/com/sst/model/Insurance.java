package com.sst.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insureance")
public class Insurance {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "insurance_name")
	private String insuranceName;
	@Column(name = "invested_amount")
	private long investedAmount;
	@Column(name = "investement_date")
	private Date InvestedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public long getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(long investedAmount) {
		this.investedAmount = investedAmount;
	}

	public Date getInvestedDate() {
		return InvestedDate;
	}

	public void setInvestedDate(Date investedDate) {
		InvestedDate = investedDate;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", insuranceName=" + insuranceName + ", investedAmount=" + investedAmount
				+ ", InvestedDate=" + InvestedDate + "]";
	}
}
