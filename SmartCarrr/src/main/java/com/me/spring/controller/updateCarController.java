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

import com.me.spring.dao.CarDAO;
import com.me.spring.pojo.Admin;
import com.me.spring.pojo.Car;
import com.me.spring.pojo.Station;


@Controller
@RequestMapping(value="/updateCar.htm")
public class updateCarController {
	
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("Admin")Admin admin,Model model) {
		 	
			return "AddCar";
		}
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String loadLocation(@ModelAttribute("Admin")Admin admin,
			 @ModelAttribute("car")Car car,
			 Model model,HttpSession session,
			 HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 System.out.println("inside controller"); 
		 System.out.println("ButtonValue" +request.getParameter("button"));
		 System.out.println("Car" +car.getCar_No());
		 System.out.println(String.valueOf(car.getCar_In_Use()));
		 System.out.println(car.getCarModel());
		 System.out.println(car.getCarName());
		 System.out.println(car.getPrice());
		 //System.out.println(car.getStation().getStation_id());
		 CarDAO dao = new CarDAO();
		 @SuppressWarnings("unchecked")
		 List<Car>carrr = (List<Car>) session.getAttribute("cars");
		 Car upd = new Car();
		 for(Car c : carrr)
		 {
			 if(c.getCar_No()==car.getCar_No()){
				 System.out.println("I am inside");
				 upd = c;
				 System.out.println("UPDATED " +c.getStation().getStation_id());
				 upd.setStationId(c.getStation().getStation_id());
			 }
				 
		 }
		 System.out.println("StationID:"+upd.getStationId());
		 car.setStationId(upd.getStationId());
		 System.out.println("Car Station ID:" +car.getStationId());
		 dao.save(car);
		 return "AddCar";
}

}
