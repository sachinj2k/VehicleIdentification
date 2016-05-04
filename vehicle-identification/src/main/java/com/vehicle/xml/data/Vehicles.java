package com.vehicle.xml.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vehicles")
public class Vehicles {

	List<Vehicle> vehicles;
	
	@XmlElement( name = "vehicle" )
	public void setVehicles( List<Vehicle> vehicles )
	{
	    this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	
}
