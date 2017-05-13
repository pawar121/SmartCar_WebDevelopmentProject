package com.me.spring.dao;

import com.me.spring.pojo.Car;
import com.me.spring.pojo.Station;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.spring.exception.AdException;

public class CarDAO extends DAO{
	
	
	
	public Car addCars(long carno,String carname,String carmodel,Station station, String price, Boolean car_In_Use) throws AdException{
		
		try{
			begin();
			Car car = new Car(carno, carname, carmodel, station,price,car_In_Use);
            getSession().save(car);
            commit();
 			return car;
		}
		
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating car: " + e.getMessage());
        }
		
}
	
	
	
	
	public Car changeflag(String carno)
	{
		begin();
		Query q1 = getSession().createQuery("update Car c set c.car_In_Use= true where c.car_No= :carnumbers");
		q1.setString("carnumbers", carno);
		commit();
		 int res = q1.executeUpdate();
		 System.out.println("updated row"+res);		
		return null;		
	}
	

	public String dropcar(String num)
	{
		begin();
		System.out.println("mera number "+num);
		
		Query q1 = getSession().createQuery("update Car c set c.car_In_Use=false  where c.car_No= :carnumbers");
		q1.setLong("carnumbers", Long.parseLong(num));
		commit();
		int res = q1.executeUpdate();
		 System.out.println("drop car updated row"+res);		

		return "abc";
	}
	
	public List searchCars(String[] myJsonData){
		
		System.out.println("Inside DAO");
		begin();
		Query q = getSession().createQuery(" Select c.carName,c.carModel,c.car_No,s.zip_code,c.price from Car c, Station s where c.station.station_id = s.station_id AND c.car_In_Use= false AND s.zip_code in (:ids)").setParameterList("ids", myJsonData);
		//Query q = getSession().createQuery(" Select c.carName, from Car c, Station s where c.station.station_id = s.station_id AND s.zip_code in (:ids)").setInteger("ids", 2120);

		List l = q.list();
	
		return l;
	}
	public List getList() throws Exception {
        try {
            
            Query q = getSession().createQuery("from Car");
            List list = q.list();
            
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the cars", e);
        }
    }
	public void save(Car car)throws Exception{
		try{
			begin();
			getSession().update(car);
			commit();
	}catch(HibernateException e){
		rollback();
		throw new AdException("Could not list cars ",e);
	}
	}

}