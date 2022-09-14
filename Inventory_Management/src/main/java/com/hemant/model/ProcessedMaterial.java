package com.hemant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProcessedMaterial {
	
	@Id
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private String itemUnit;
	private int costPerUnit;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public ProcessedMaterial(int itemId, String itemName, int itemQuantity, String itemUnit, int costPerUnit) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemUnit = itemUnit;
		this.costPerUnit = costPerUnit;
	}
	public ProcessedMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
