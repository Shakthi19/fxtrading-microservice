package com.finzly.fxtrading.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class foreignexchange {
	@Id
	private int tradeNumber;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double exchangedamount;
    private double rate;
    
    foreignexchange(){
    	
    }

	public foreignexchange(int tradeNumber, String currencyPair, String customerName, double amount,
			double exchangedamount, double rate) {
		super();
		this.tradeNumber = tradeNumber;
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.exchangedamount = exchangedamount;
		this.rate = rate;
	}

	public int getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getExchangedamount() {
		return exchangedamount;
	}

	public void setExchangedamount(double exchangedamount) {
		this.exchangedamount = exchangedamount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
