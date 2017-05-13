package com.me.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import com.me.spring.dao.BookCarDAO;
import com.me.spring.dao.CarDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.BookDetails;
import com.me.spring.pojo.Car;

@Controller
@RequestMapping("/bookCar.htm")
public class BookCarController {

	
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
		 	
			return "home";
		}
	
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String doSubmitAction(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException, AdException{
		 System.out.println("inside bookcar");
		 
          
         HttpSession session = request.getSession();
         if(session.getAttribute("customers")==null)
        	 return "Error";
         String name = (String) session.getAttribute("customers");
        
         System.out.println(name);
         String carname = request.getParameter("a");
		 String carmodel = request.getParameter("b");
		 String carnumber = request.getParameter("c");
		 String carzip = request.getParameter("d");
		 String carprice = request.getParameter("e");
		 
		 CarDAO cardao = new CarDAO();
		 Car c = new Car();
		 System.out.println("station id variable is  "+c.getStationId());
		 Car car = cardao.changeflag(carnumber);
		 
		 
		 BookCarDAO bookdao = new BookCarDAO();
         BookDetails bd = bookdao.bookCar(name,carname,carnumber,carmodel,carprice);
		 session.setAttribute("booklist", bd);
		 return "ViewBooking";
}
	
}
