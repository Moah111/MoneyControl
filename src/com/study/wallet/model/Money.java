package com.study.wallet.model;

import java.util.Date;

public class Money {
	private float petroCost;
	private float itemsCost;
	private float incurredCost;
	private float bonusMoney;
	private Date date;

	public Money() {

	}


	public float getPetroCost() {
		return petroCost;
	}
	public void setPetroCost(float petroCost) {
		this.petroCost = petroCost;
	}
	public float getItemsCost() {
		return itemsCost;
	}
	public void setItemsCost(float itemsCost) {
		this.itemsCost = itemsCost;
	}
	public float getIncurredCost() {
		return incurredCost;
	}
	public void setIncurredCost(float incurredCost) {
		this.incurredCost = incurredCost;
	}
	public float getBonusMoney() {
		return bonusMoney;
	}
	public void setBonusMoney(float bonusMoney) {
		this.bonusMoney = bonusMoney;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Money(float petroCost, float itemsCost, float incurredCost,
			float bonusMoney, Date date) {
		super();
		this.petroCost = petroCost;
		this.itemsCost = itemsCost;
		this.incurredCost = incurredCost;
		this.bonusMoney = bonusMoney;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Money [petroCost=" + petroCost + ", itemsCost=" + itemsCost
				+ ", incurredCost=" + incurredCost + ", bonusMoney="
				+ bonusMoney + ", date=" + date + "]";
	}
	
	

}

//This project will be complete between 22 November  to 23nov.