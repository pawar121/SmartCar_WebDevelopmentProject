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
@Table(name="BookDetails")
public class BookDetails {
	
		
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="BookDetailId", unique = true, nullable = false)
	    private long bookId;
		
		@Column(name="Book_Car_Name")
		private String carName;
		
		@Column(name="Book_Car_Model")
		private String carModel;
		
		@Column(name="Book_Car_Price")
		private String carPrice;
		
		@Column(name="Book_Person_Name")
		private String personName;
		
		@Column(name="CarNumber")
		private String carnumber;
		
	
		public BookDetails(){
			
			
		}
		public BookDetails(String carName, String carModel, String carPrice,String personName,String carnumber){
			
		   this.carName=carName;
		   this.carModel=carModel;
		   this.carPrice=carPrice;
		   this.personName=personName;
		   this.carnumber=carnumber;
			
			
		}
		public long getBookId() {
			return bookId;
		}
		public void setBookId(long bookId) {
			this.bookId = bookId;
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
		public String getCarPrice() {
			return carPrice;
		}
		public void setCarPrice(String carPrice) {
			this.carPrice = carPrice;
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
