package com.finzly.fxtrading.Dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.finzly.fxtrading.FxtradingApplication;
import com.finzly.fxtrading.Entity.currency;

@Repository
public class currencyDao {
	
	@Autowired
	SessionFactory factory;

	public String addccy(currency ccy) {
		Session session = factory.openSession();
		session.save(ccy);
		session.beginTransaction().commit();
		return "Currency pair is added";
	}

	public List<FxtradingApplication> getCcyInfo() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(currency.class);
		return criteria.list();
	}

	public String updateccy(currency ccy) {
		Session session = factory.openSession();
		session.update(ccy);
		session.beginTransaction().commit();
		return "Currency pair is updated";
	}

	public String deleteccy(currency ccy) {
		Session session = factory.openSession();
		session.update(ccy);
		session.beginTransaction().commit();
		return "Currency pair is deleted";
	}

}
