package com.me.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Station")
public class Station {
	
	@Id
	@Column(name="Station_ID", unique = true, nullable = false)
	private int station_id;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="station")
	private Set<Car> cars = new HashSet<Car>();

	@Column(name="zip_code")
	private String zip_code;
	
	@Column(name="StationName")
	private String StationName;

	Station(){
		
	}
	
	public Station(String Stationname, String zipcode){
		this.StationName=Stationname;
		this.zip_code = zipcode;
		
	}
	
	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}
	
}
