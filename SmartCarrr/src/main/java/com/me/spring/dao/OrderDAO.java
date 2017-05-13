package com.me.spring.dao;

import org.hibernate.HibernateException;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.Orders;

public class OrderDAO extends DAO{
	
	
	public Orders OrderssubmitOrder(String personName,String carName,String carnumber,String carModel,String amount ) throws AdException{
	try{	
		
		
		System.out.println("amount is" +amount);
		Orders ord = new Orders(carName, carModel, amount, personName, carnumber);
		begin();
		getSession().save(ord);
        commit();
        return ord;
		}
	
	catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create advert", e);
        throw new AdException("Exception while creating car: " + e.getMessage());
    }
}
}