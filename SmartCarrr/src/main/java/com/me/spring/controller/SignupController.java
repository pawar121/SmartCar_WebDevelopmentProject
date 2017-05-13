package com.me.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.spring.dao.CustomerDAO;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.Customer;

@Controller
@RequestMapping("/signup.htm")
public class SignupController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
     
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("customer")Customer customer,BindingResult result) {
		 	
			return "Signup";
		}
	
	 @RequestMapping(method = RequestMethod.POST)
	 protected String doSubmitAction(@ModelAttribute("customer")Customer customer,BindingResult result) 
	 throws Exception
	 {
		validator.validate(customer, result);
			if(result.hasErrors()){
				return "Signup";
			}
			
//		ModelAndView mv = new ModelAndView();
//		Admin admin = new Admin();
//		mv.addObject("Admin",admin);
		
		CustomerDAO customerDAO = new CustomerDAO();
		String username = customer.getUserName();
		String password = customer.getPassword();	
		String email = customer.getEmail();
		long phoneno = customer.getPhoneno();
		//String role = customer.getRole();
		Customer customer1 = customerDAO.createCustomer("Customer",username,password,email,phoneno);
		System.out.println(customer1.getPassword());
		
		return	"successregister";
	}	


	 
	 
}
