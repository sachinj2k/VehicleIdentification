package com.vehicle.xml.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vehicle")
public class Vehicle {
 private String id;
 private Vehicle.Frame frame;
 private Vehicle.Wheels wheels;
 private String powerTrain;
 
 public String getId() {
	return id;
}
@XmlElement(name="id") 
public void setId(String id) {
	this.id = id;
}
public Vehicle.Frame getFrame() {
	return frame;
}
@XmlElement(name="frame")
public void setFrame(Vehicle.Frame frame) {
	this.frame = frame; 
}
public Vehicle.Wheels getWheels() {
	return wheels;
}
@XmlElement(name="wheels")
public void setWheels(Vehicle.Wheels wheels) {
	this.wheels = wheels;
}
public String getPowerTrain() {
	return powerTrain;
}
@XmlElement(name="powertrain")
public void setPowerTrain(String powerTrain) {
	this.powerTrain = powerTrain;
}
public static class Frame
 {
	private String material;

	public String getMaterial() {
		return material;
	}
    @XmlElement(name="material")
	public void setMaterial(String material) {
		this.material = material;
	}
	 
 }
 public static class Wheels
 {
	 
	 private List<Wheel> wheel;
	 
	 @XmlElement(name="wheel")
	 public List<Wheel> getWheel() {
         if (wheel==null) {
             wheel=new ArrayList<Wheel>();
         }
         return this.wheel;
     }

	public void setWheel(List<Wheel> wheel) {
		this.wheel = wheel;
	}
 }
}
