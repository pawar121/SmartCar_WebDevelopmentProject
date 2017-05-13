package com.me.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.spring.pojo.Customer;


public class UserValidator implements Validator{

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONE_PATTERN = "^[0-9]";
	public boolean supports(Class<?> aClass)
    {
        //return aClass.equals(Customer.class);
		return Customer.class.equals(aClass);
    }

    public void validate(Object obj, Errors errors)
    {
        Customer customer = (Customer) obj;
        //String phoneNum = String.valueOf(user.getPhoneNum());
        if(!customer.getEmail().matches(EMAIL_PATTERN)) {   
        	errors.rejectValue("email","valid.invalid.email","Email Not Correct");
        }
        /*if(!phoneNum.matches(PHONE_PATTERN)){
        	errors.rejectValue("phoneNum","valid..invalid.phoneNum","Phone Number Incorrect");
        }*/
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneno","error.invalid.phoneno", "Phone Number Required");
    }
}

