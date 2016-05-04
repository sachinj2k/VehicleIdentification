package com.vehicle.xml.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="wheel")
public class Wheel {
private String position;
private String material;
public String getPosition() {
	return position;
}
@XmlElement(name="position")
public void setPosition(String position) {
	this.position = position;
}
public String getMaterial() {
	return material;
}
@XmlElement(name="material")
public void setMaterial(String material) {
	this.material = material;
}

}
