package com.me.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.CarDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.Admin;

@Controller

public class DropCarController {
	
			
		 @RequestMapping(value="drop.htm" ,method = RequestMethod.GET)
		 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
			 	
				return "cardrop";
			}
		  
		 @RequestMapping(value = "dropcar.htm", method = RequestMethod.POST)
		 public String doSubmitAction(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException, AdException{

		     
			 
	         HttpSession session = request.getSession();
	         if(session.getAttribute("customers")==null)
	        	 return "Error";
	         String name = (String) session.getAttribute("customers");
			 String number = request.getParameter("drop");
			 System.out.println("no to drop"+number);
			 CarDAO carDao = new CarDAO();
			 carDao.dropcar(number);
			 
			 
		 return "successregister";
		 
		 }
}
	