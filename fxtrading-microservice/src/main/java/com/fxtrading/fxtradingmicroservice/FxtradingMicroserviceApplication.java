package com.fxtrading.fxtradingmicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/fxtrading")

public class FxtradingMicroserviceApplication {
	private int tradeNumber;
    private String currencyPair;
    private String customerName;
    private double amount;
    private static  double rate = 66.00;
    private static int tradeCount = 0;
	private static String message;
	private static String displaymsg;
    private String rateAnswer;
   
    

     FxtradingMicroserviceApplication(){
    	 
     }
	public FxtradingMicroserviceApplication(int tradeNumber, String currencyPair, String customerName, double amount,
			String rateAnswer, String bookDetail, List<FxtradingMicroserviceApplication> foreignExchanges) {
		super();
		this.tradeNumber = tradeNumber;
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rateAnswer = rateAnswer;
		
		ForeignExchanges = foreignExchanges;
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
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		FxtradingMicroserviceApplication.rate = rate;
	}
	public static int getTradeCount() {
		return tradeCount;
	}
	public static void setTradeCount(int tradeCount) {
		FxtradingMicroserviceApplication.tradeCount = tradeCount;
	}
	public static String getMessage() {
		return message;
	}
	public static void setMessage(String message) {
		FxtradingMicroserviceApplication.message = message;
	}
	public static String getDisplaymsg() {
		return displaymsg;
	}
	public static void setDisplaymsg(String displaymsg) {
		FxtradingMicroserviceApplication.displaymsg = displaymsg;
	}
	public String getRateAnswer() {
		return rateAnswer;
	}
	public void setRateAnswer(String rateAnswer) {
		this.rateAnswer = rateAnswer;
	}
	
	public List<FxtradingMicroserviceApplication> getForeignExchanges() {
		return ForeignExchanges;
	}
	public void setForeignExchanges(List<FxtradingMicroserviceApplication> foreignExchanges) {
		ForeignExchanges = foreignExchanges;
	}
	
	
	
	@Override
	public String toString() {
		return "FxtradingMicroserviceApplication [tradeNumber=" + tradeNumber + ", currencyPair=" + currencyPair
				+ ", customerName=" + customerName + ", amount=" + amount + ", rateAnswer=" + rateAnswer + "]";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(FxtradingMicroserviceApplication.class, args);
		
	}
	@GetMapping("/fxtradingoption")
	@ResponseBody
	public String launch() {
		message="\nOptions:\n1. Book Trade\n2. Print Trade\n3. Exit\nEnter your choice: ";
		return message;
	}
List<FxtradingMicroserviceApplication> ForeignExchanges = new ArrayList<>();
	
	@PostMapping("1/booktrade")
	public String receivetrade(@RequestBody FxtradingMicroserviceApplication f) {
	f.bookTrade(f);
	ForeignExchanges.add(f);
	return "Trade Status: " +f.display();
	}
        public void bookTrade(FxtradingMicroserviceApplication f) {
		
    	 double inrAmount = amount * rate;

            if (currencyPair.equals("USDINR") && rateAnswer.equalsIgnoreCase("Yes")) {
               displaymsg="You are transferring INR"+(int) inrAmount+" to "+customerName+ ". Assuming that rate was (" + rate + ")";
               displaymsg = "Trade for USDINR has been booked with rate " + rate + ". The amount of Rs " +
            		   (int) inrAmount + " will be transferred in 2 working days to " + customerName + ".";
                tradeCount ++;


            }
            else {
                displaymsg="Invalid input. You can only book trades for USDINR with rate information.";
            }
        }
	public String display() {
		return displaymsg;
	}
	@GetMapping("2/printtrades")
    public List<FxtradingMicroserviceApplication> getTrades(){
    	return ForeignExchanges;}
	
	@GetMapping("3/exitProgram")
	@ResponseBody
	
	public String getInput(@RequestParam(required=false) String ans) {
		message= "Do you really want to exit (y/n): "+ans;
		if (ans.equalsIgnoreCase("Y")) {
            message="Bye! Have a good day.";
            }
		return message;
	}

}
