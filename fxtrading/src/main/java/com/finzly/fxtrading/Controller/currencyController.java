package com.finzly.fxtrading.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Entity.currency;
import com.finzly.fxtrading.Service.currencyService;


@RestController
public class currencyController {
	
	@Autowired
	private currencyService currencyservice;
	
	
	List<FxtradingApplication> ForeignExchanges = new ArrayList<>();
	
	//Add currency pair
	@PostMapping("/add-ccy/{currencyPair}")
	public String addccy(@RequestBody currency ccy) {
		return currencyservice.addccy(ccy);

	}
	
	//View all currency pair
	@GetMapping("allcurrency")
	public List<FxtradingApplication> getCcyInfo() {
		return currencyservice.getCcyInfo();
	}

		
	//Update currency pair
	@PutMapping("updatecurrency")
	public String updateccy(@RequestBody currency ccy) {
		return currencyservice.updateccy(ccy);
	}
	
	//Delete currency pair
	@DeleteMapping("deletecurrency")
	public String deleteccy(@RequestBody currency ccy) {
			return currencyservice.deleteccy(ccy);
	}
	
	

}

