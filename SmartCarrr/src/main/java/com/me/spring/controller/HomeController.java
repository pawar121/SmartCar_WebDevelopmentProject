package com.me.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.me.spring.dao.AdminDAO;
import com.me.spring.dao.CustomerDAO;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.Car;
import com.me.spring.pojo.Customer;



@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("Admin")Admin admin,@ModelAttribute("car")Car car,
			@ModelAttribute("customer")Customer customer,Model model) {
		return "home";
	}

	@RequestMapping(value = "/error.htm", method = RequestMethod.GET)
	public String home(@ModelAttribute("Admin")Admin admin,@ModelAttribute("Customer")Customer customer) {
		return "home";
	}

	
	@RequestMapping(value = "/gotosignup.htm", method = RequestMethod.GET)
	public String home3(@ModelAttribute("Admin")Admin admin,@ModelAttribute("customer")Customer customer) {
		return "Signup";
	}
	@RequestMapping(value = "/customer.htm", method = RequestMethod.GET)
	public String home1(@ModelAttribute("Admin")Admin admin,@ModelAttribute("Customer")Customer customer) {
		return "home";
	}

	
	@RequestMapping(value="logout.htm",method = RequestMethod.POST)
	public String logOut(@ModelAttribute("Admin")Admin admin,HttpServletRequest req, HttpServletResponse resp){
		HttpSession sessn = req.getSession();
		sessn.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/admin.htm",method = RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("Admin") Admin admin,@ModelAttribute("car") Car car,
			BindingResult result,@ModelAttribute("Customer") Customer customer, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		AdminDAO adminDAO = new AdminDAO();

		String user = admin.getUsername();
		String password = admin.getPassword();
	    String role = admin.getRole();
		System.out.println(user);
		
		Admin admin1 = adminDAO.checkAdmin(user, password);
	    System.out.println(admin1.getAdminID());	
	    
	    		    
		  HttpSession session = req.getSession();
		  session.setAttribute("ad", admin1.getUsername());
          if (admin1.getUsername() != "fake"){
		  return "AddCar";
		  }
          
          CustomerDAO customerDAO = new CustomerDAO();	
          Customer customer1 = customerDAO.checkCustomer(role,user, password);
          System.out.println(customer1.getPhoneno());    
          if(customer1.getUserName()=="invalid")
            {
        	   session.setAttribute("customers", "invalid");
        	   return "Error"; 
	    	}
               System.out.println(customer1.getPhoneno());
               session.setAttribute("customers",customer1.getUserName());
        	   return "home";
	    }
      
//	@RequestMapping(value = "/customer.htm",method = RequestMethod.POST)
//	public String doSubmitAction(@ModelAttribute("customer") Customer customer,
//			BindingResult result,HttpServletRequest req, HttpServletResponse resp)
//			throws Exception {
//		CustomerDAO customDAO = new CustomerDAO();
//
//		String user = customer.getUserName();
//		String password = customer.getPassword();
//	  
//		System.out.println(user);
////		
////		Admin admin1 = adminDAO.checkAdmin(user, password);
////	    System.out.println(admin1.getAdminID());	
////	    
////		  HttpSession session = req.getSession();
////		  session.setAttribute("ad", admin1.getUsername());
////          if (admin1.getUsername() != "asd"){
////		  return "AddCar";
////		  }
//          
//	 	  return "home";
//          
//	}
		
}
