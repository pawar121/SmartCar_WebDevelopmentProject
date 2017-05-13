package com.me.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Car")

public class Car {
	
	@Id 
	@Column(name="Car_No", unique = true, nullable = false)
    private long car_No;
	
	@Column(name="Car_Name")
	private String carName;
	
	@Column(name="Car_Model")
	private String carModel;
	
	@Column(name="Price")
	private String price;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Station_ID")
	private Station station;
	
    @Transient
    private int stationId;
    
    
    @Column(name="Car_In_Use")
    private Boolean car_In_Use;
    
	public Car(){
		
		
	}
	
	public Car(long Car_No,String carName, String carModel, Station station,String price, Boolean car_In_Use)
	
	{
		this.car_No = Car_No;
		this.carName = carName;
		this.carModel = carModel;
		this.station= station;
		this.price=price;
		this.car_In_Use = car_In_Use;
	}
	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public long getCar_No() {
		return car_No;
	}

	public void setCar_No(long car_No) {
		this.car_No = car_No;
	}

	public Boolean getCar_In_Use() {
		return car_In_Use;
	}

	public void setCar_In_Use(Boolean car_In_Use) {
		this.car_In_Use = car_In_Use;
	}

	
	
	
}
