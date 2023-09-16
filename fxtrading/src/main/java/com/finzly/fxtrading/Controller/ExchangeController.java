package com.finzly.fxtrading.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Entity.foreignexchange;
import com.finzly.fxtrading.Entity.currency;
import com.finzly.fxtrading.Service.ExchangeService;

@RestController
public class ExchangeController {
	
	@Autowired
	private ExchangeService exchangeservice;
		
	
	List<foreignexchange> ForeignExchanges = new ArrayList<>();
	List<currency> Currency=new ArrayList<>();
	
	//Exchange currency 
	@PostMapping("/exchange")
	public String exchange(foreignexchange foreignExchanges,currency curRency) {
		return exchangeservice.exchange(foreignExchanges,curRency);

	}
	
	//View all exchanges
	@GetMapping("allexchange")
	public List<FxtradingApplication> getExchangeInfo(foreignexchange foreignExchanges) {
		return exchangeservice.getExchangeInfo(foreignExchanges);
	}

}
