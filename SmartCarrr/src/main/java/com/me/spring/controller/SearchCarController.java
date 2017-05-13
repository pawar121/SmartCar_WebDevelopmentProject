package com.me.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.spring.dao.CarDAO;
import com.me.spring.dao.CustomerDAO;
import com.me.spring.dao.StationDAO;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.Customer;

@Controller
@RequestMapping("/searchCar.htm")

public class SearchCarController {
	
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
		 	
			return "home";
		}
	
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String loadLocation(@ModelAttribute("Admin")Admin admin,Model model,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		 
		 System.out.println("inside controller"); 

		 String[] myJsonData = request.getParameterValues("zipdata");
			 
		 System.out.println("My jsonData is"+myJsonData);
		 CarDAO carDAO = new CarDAO();
		 List l =  carDAO.searchCars(myJsonData);
		 System.out.println(l.size());	 
		 
		 JSONObject obj = new JSONObject();
		 
		 obj.put("cars", l);
		 PrintWriter out = response.getWriter();
		 out.println(obj);
		 
		 return null;
}
	 
	 
}	 
	
	

	
	


