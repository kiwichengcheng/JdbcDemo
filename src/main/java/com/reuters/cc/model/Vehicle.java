package com.reuters.cc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Vehicle {

	@Id @GeneratedValue
	private int vehiclId;
	
	private String vehicleName;

	public int getVehiclId() {
		return vehiclId;
	}

	public void setVehiclId(int vehiclId) {
		this.vehiclId = vehiclId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}
