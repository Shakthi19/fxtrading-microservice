package com.finzly.fxtrading.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class currency {
	@Id
	private int id;
	private String currencyPair;
	private double rate;
	
	currency(){
		
	}

	public currency(int id, String currencyPair, double rate) {
		super();
		this.id = id;
		this.currencyPair = currencyPair;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ccyData [id=" + id + ", currencyPair=" + currencyPair + ", rate=" + rate + "]";
	}

		
}
