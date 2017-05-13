package com.me.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.Customer;

public class CustomerDAO extends DAO {
	
	   public Customer createCustomer(String role,String username, String password, String email, long phoneno) throws AdException{
		  
		try{
			Customer customer1;
		   begin();
           Customer customer = new Customer(role,username, password, email, phoneno);
           customer1 = customer;
           getSession().save(customer);
           commit();
           return customer1;
		   
             }
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create customer", e);
            throw new AdException("Exception while creating customer: " + e.getMessage());
        }

}
	   public Customer checkCustomer(String role,String username, String password) {
		   
		   begin();
			Query q = getSession().createQuery("FROM Customer where userName= :name AND password=:pass");
			q.setString("name", username);
			q.setString("pass", password);
			commit();
			Customer customer = (Customer)q.uniqueResult();
			if(customer==null){
				customer = new Customer("invalid","invalid", "invalid", "invalid", 889);
			}
			return customer;
		   
	   }
	   
	
	   public Customer checkusername(String uname){
		   
		  
			Query q = getSession().createQuery("FROM Customer where userName= :name");
			q.setString("name", uname);
			
		Customer cust = (Customer)q.uniqueResult();
		   
		   
		   return cust;
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
