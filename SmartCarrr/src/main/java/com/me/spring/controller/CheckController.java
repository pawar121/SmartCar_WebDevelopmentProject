package com.me.spring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.CarDAO;
import com.me.spring.dao.CustomerDAO;
import com.me.spring.dao.StationDAO;
import com.me.spring.pojo.Car;
import com.me.spring.pojo.Customer;
import com.me.spring.pojo.Station;

@Controller
@RequestMapping(value="/checkuser.htm")
public class CheckController {

	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("car")Car car,Model model) {
		 	
			return "AddCar";
		}
	 
	 @RequestMapping(method=RequestMethod.POST)
	 protected String doSubmitAction(@ModelAttribute("car")Car car, Model model,HttpServletRequest request,HttpServletResponse response)
	 throws Exception {

            
		 String name = request.getParameter("username"); 
		 CustomerDAO customerdao = new CustomerDAO();
		 Customer customer = customerdao.checkusername(name);
		 
		 if(!customer.equals(null)){
			 
			 JSONObject obj = new JSONObject();
			  obj.put("abc", customer);
			  PrintWriter out = response.getWriter();
			out.println(obj);
			 
		 }
		 
		 
         return "null";
          
	}	 
	
	
	
	
	
	
	
	
	
	
	
}
