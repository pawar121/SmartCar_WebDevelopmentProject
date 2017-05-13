/*package com.me.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.AdminDAO;
import com.me.spring.pojo.Admin;


@Controller
@RequestMapping("/admin.htm")
public class AdminController {
	

	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		String[] allowedFields = {"username","password"}; 
	binder.setAllowedFields(allowedFields);

	}	
	
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
		 	
			return "home";
		}
	 
	 
	@RequestMapping(value={"admin.htm"}, method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("admin") Admin admin, BindingResult result) throws Exception{
		
	  AdminDAO adminDAO = new AdminDAO();
		
		String user = admin.getUsername();
		String password = admin.getPassword();
		
	//	AdminDAO admin1 = createAdmin(user,password);
		return "home";
		
	}
	
	

}
*/