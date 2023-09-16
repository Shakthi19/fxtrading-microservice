package com.finzly.fxtrading.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Dao.ExchangeDao;
import com.finzly.fxtrading.Entity.currency;
import com.finzly.fxtrading.Entity.foreignexchange;
import com.finzly.fxtrading.exception.InvalidCurrencyException;
import com.finzly.fxtrading.exception.InvalidException;

@Service
public class ExchangeService {

	@Autowired
	ExchangeDao exchangeDao;

	public List<FxtradingApplication> getExchangeInfo(foreignExchanges) {
		return exchangeDao.getExchangeInfo();
	}

	public String exchange(foreignexchange foreignExchanges, currency curRency) {
		List<FxtradingApplication> list = exchangeDao.getExchangeInfo(foreignExchanges);
		if (foreignExchanges.getAmount() == 0.0 || foreignExchanges.getCurrencyPair() == null) {
			throw new InvalidException("Not a valid input data" + HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			double exchangedamount;
			String currencyPair = foreignExchanges.getCurrencyPair();
			double amount = foreignExchanges.getAmount();
			String name = foreignExchanges.getCustomerName();
			double rate = 0.0;
			boolean exchange = false;
			int target = 0;
			for (currency c : list) {
				if (c.getCurrencyPair().equalsIgnoreCase(currencyPair)) {
					exchangedamount = c.getRate() * amount;
					rate = c.getRate();
					exchange = true;

				}
			}
			if (!exchange) {
				throw new InvalidCurrencyException("Invalid currency pair");
			} else {
				foreignexchange fx = new foreignexchange();
				fx.setCurrencyPair(currencyPair);
				fx.setAmount(amount);
				fx.setCustomerName(name);
				fx.getExchangedamount(exchangedamount);
				exchangeDao.saveforeignexchange(fx);
				return "Exchanged amount successfully";

			}
		}

	}

	public List<FxtradingApplication> getExchangeInfo(foreignexchange foreignExchanges) {
		return exchangeDao.getExchangeInfo(foreignExchanges);
	}
