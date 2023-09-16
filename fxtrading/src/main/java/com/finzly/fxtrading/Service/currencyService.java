package com.finzly.fxtrading.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Dao.currencyDao;
import com.finzly.fxtrading.Entity.currency;

@Service
public class currencyService {
	
	@Autowired
	currencyDao ccydao;

	public String addccy(currency ccy) {
		return ccydao.addccy(ccy);
	}

	public List<FxtradingApplication> getCcyInfo() {
		return ccydao.getCcyInfo();
	}

	public String updateccy(currency ccy) {
		return ccydao.updateccy(ccy);
	}

	public String deleteccy(currency ccy) {
		return ccydao.deleteccy(ccy);
	}

}
