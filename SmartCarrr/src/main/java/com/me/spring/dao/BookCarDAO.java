package com.me.spring.dao;

import org.hibernate.HibernateException;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.BookDetails;

public class BookCarDAO extends DAO {

	
	
	public BookDetails bookCar(String username, String carname, String carnumber, String carmodel, String price) throws AdException
	{
		try{
		begin();
		BookDetails bookdetails = new BookDetails(carname, carmodel, price, username,carnumber);
		 getSession().save(bookdetails);
         commit();
		return bookdetails ;
	}
	
	
	catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create advert", e);
        throw new AdException("Exception while creating bookdetails: " + e.getMessage());
    }
	}
	
}
