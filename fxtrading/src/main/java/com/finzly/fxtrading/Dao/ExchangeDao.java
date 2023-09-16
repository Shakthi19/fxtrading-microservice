package com.finzly.fxtrading.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Entity.currency;
import com.finzly.fxtrading.Entity.foreignexchange;

@Repository
public class ExchangeDao {
	
	@Autowired
	SessionFactory factory;
	

	public List<FxtradingApplication> getExchangeInfo(foreignexchange foreignExchanges) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(foreignexchange.class);
		return criteria.list();
	}

}
