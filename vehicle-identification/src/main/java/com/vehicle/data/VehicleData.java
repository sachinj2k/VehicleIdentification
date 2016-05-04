package com.vehicle.data;

import java.util.List;

public class VehicleData {
	
	private String vehicleId;
	private String vehicleType;
	private String frame;
	private String powerTrain;
	private List<WheelData> wheels;
	
	public VehicleData(String frame, String powerTrain, List<WheelData> wheels) {
		this.frame = frame;
		this.powerTrain = powerTrain;
		this.wheels = wheels;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getFrame() {
		return frame;
	}
	
	public String getPowerTrain() {
		return powerTrain;
	}
	public List<WheelData> getWheels() {
		return wheels;
	}
	
	/*
	 * 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + ((powerTrain == null) ? 0 : powerTrain.hashCode());
		result = prime * result + ((wheels == null) ? 0 : (wheels).hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "VehicleData [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", frame=" + frame
				+ ", powerTrain=" + powerTrain + ", wheels=" + wheels + "]";
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleData other = (VehicleData) obj;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		if (powerTrain == null) {
			if (other.powerTrain != null)
				return false;
		} else if (!powerTrain.equals(other.powerTrain))
			return false;
		if (wheels == null) {
			if (other.wheels != null)
				return false;
		} else if (!compareLists(wheels,other.wheels))
			return false;
		return true;
	}
	
	public boolean compareLists(List<WheelData>list1,List<WheelData>list2 )
	{
		return (list1.containsAll(list2)&& list2.containsAll(list1));
	}
	
	
	
	
}
