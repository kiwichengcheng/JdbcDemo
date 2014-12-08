package com.reuters.cc.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS_ONE_TO_ONE")
public class UserDetailsOneToOne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="USER_NAME")
	private String username;
	
	/*@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	*
	*/
	
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"),
				name="USER_VEHICLE"
			)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();


	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
