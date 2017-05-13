package com.me.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Orders")
public class Orders {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderId", unique = true, nullable = false)
    private long orderId;
	
	@Column(name="Car_Name")
	private String carName;
	
	@Column(name="Car_Model")
	private String carModel;
	
	@Column(name="Total_Amount")
	private String amount;
	
	@Column(name="Book_Person_Name")
	private String personName;
	
	@Column(name="CarNumber")
	private String carnumber;
	
	public Orders(){
		
	}
	
	public Orders(String carName,String carModel,String amount, String personName, String carnumber){
	  	this.carName=carName;
	  	this.carModel=carModel;
	  	this.personName=personName;
	  	this.carnumber=carnumber;	
	  	this.amount=amount;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	
}
