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

import com.me.spring.dao.BookCarDAO;
import com.me.spring.dao.OrderDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.BookDetails;
import com.me.spring.pojo.Orders;

@Controller
@RequestMapping("/order.htm")
public class OrderController {


	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
		 	
			return "home";
		}
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String doSubmitAction(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException, AdException{
		 System.out.println("inside bookcar");
		 
            
         HttpSession session = request.getSession();
         String name = request.getParameter("name");
         String carname = request.getParameter("carname");
		 String carmodel = request.getParameter("carmodel");
		 String carnumber = request.getParameter("carnumber");
		 String carprice = request.getParameter("amount");
		    
		 OrderDAO orderdao = new OrderDAO();
         Orders o = orderdao.OrderssubmitOrder(name, carname, carnumber, carmodel, carprice);
         System.out.println(o.getAmount());
		 session.setAttribute("orderList", o);
		 return "orderSummary";
}	
}
