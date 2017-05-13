package com.me.spring.dao;


import org.hibernate.Query;

import com.me.spring.pojo.Admin;

public class AdminDAO extends DAO{
	
	public Admin checkAdmin(String user, String password){
		
		
			begin();
			Query q = getSession().createQuery("FROM Admin where username= :name AND password=:pass");
			q.setString("name", user);
			q.setString("pass", password);
			commit();
			Admin admin = (Admin)q.uniqueResult();
			if(admin==null){
				admin = new Admin(2,"fake","fake","fake");
			}
			return admin;
		
		
	}
	
	

}
