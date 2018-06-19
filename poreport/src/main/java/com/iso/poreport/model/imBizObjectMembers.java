package com.iso.poreport.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class imBizObjectMembers {
	@Id
	@GeneratedValue
	@Column(name = "rel_id")
	private Integer relId;
	@Column(name = "percentage")
	private BigDecimal percentage;
	public Integer getRelId() {
		return relId;
	}
	public void setRelId(Integer relId) {
		this.relId = relId;
	}
	public BigDecimal getPercentage() {
		return percentage;
	}
	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	
	public imBizObjectMembers() {
		super();
	}
	@Override
	public String toString() {
		return "imBizObjectMembers [relId=" + relId + ", percentage=" + percentage + "]";
	}
	
	

}
