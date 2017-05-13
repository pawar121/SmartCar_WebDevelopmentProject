package com.me.spring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.me.spring.dao.CarDAO;
import com.me.spring.dao.StationDAO;
import com.me.spring.pojo.Car;
import com.me.spring.pojo.Station;

@Controller
@RequestMapping("/addCar.htm")
public class AddCarController{
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public String initializeForm(@ModelAttribute("car")Car car,Model model) {
		 	
			return "AddCar";
		}
	 
	 @RequestMapping(method=RequestMethod.POST)
	 protected String doSubmitAction(@ModelAttribute("car")Car car, Model model)
	 throws Exception {

		 StationDAO stationDAO = new StationDAO();
		 
		 long carno = car.getCar_No();
	     String carname = car.getCarName();
	     String carmodel = car.getCarModel();
	     int stationId = car.getStationId();
	     String price = car.getPrice();
	     Boolean car_in_use = car.getCar_In_Use();
	     
	     Station stat = stationDAO.get(stationId);
	     
	     System.out.println(stat.getStation_id());
		 CarDAO carDAO = new CarDAO();
		 Car car1 = carDAO.addCars(carno, carname, carmodel, stat,price,false);
		 
		 

		 System.out.println(car1.getCarModel());
		
         return "AddCar";
          
	}	 
}
