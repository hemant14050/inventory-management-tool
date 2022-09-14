package com.hemant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssuedProMaterial {
	
	@Id
	private int issueId;
	private String itemName;
	private int itemQuantity;
	private String issuerName;
	private int itemId;
	private String issueDate;
	
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public IssuedProMaterial(int issueId, String itemName, int itemQuantity, String issuerName, int itemId,
			String issueDate) {
		super();
		this.issueId = issueId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.issuerName = issuerName;
		this.itemId = itemId;
		this.issueDate = issueDate;
	}
	public IssuedProMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
