package com.vehicle.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vehicle.data.VehicleData;
import com.vehicle.data.WheelData;
import com.vehicle.xml.data.Vehicle;
import com.vehicle.xml.data.Vehicles;
import com.vehicle.xml.data.Wheel;

public class AppUtil {
	
	/**
	 * 
	 * @param vehicles
	 * @return
	 */
	 public static List<VehicleData> populateVehicleData(Vehicles vehicles)
	 {
		 List<VehicleData> vehicleDataList = new ArrayList<VehicleData>();
		 if(vehicles!=null)
		 {
			 if(vehicles.getVehicles()!=null && !vehicles.getVehicles().isEmpty())
			 {
				 for(Vehicle vehicle:vehicles.getVehicles())
				 {
					 List<WheelData> wheelsDataList = new ArrayList<WheelData>();
					 for(Wheel wheel: vehicle.getWheels().getWheel())
					 {
						 WheelData wheelData = new WheelData();
						 wheelData.setMaterial(wheel.getMaterial().trim());
						 wheelData.setPosition(wheel.getPosition().trim());
						 wheelsDataList.add(wheelData);
					 }
					 Collections.sort(wheelsDataList);
					VehicleData vehicleData = new VehicleData(vehicle.getFrame().getMaterial().trim(),vehicle.getPowerTrain().trim(),wheelsDataList);
					vehicleData.setVehicleId(vehicle.getId());
					vehicleDataList.add(vehicleData);
				 }
				 
			 }
		 }
		 return vehicleDataList;
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public static Map<VehicleData,String>  getAvailableVehicleTypes()
	 {
		 Map<VehicleData,String> vehicleMap = new HashMap<>();
		 VehicleData bigWheel = populateVehicles("plastic","human","plastic","left rear","plastic","right rear","plastic","front");
		 vehicleMap.put(bigWheel,"Big Wheel");
		 VehicleData bicycle = populateVehicles("metal","human","metal","rear","metal","front");
		 vehicleMap.put(bicycle,"Bicycle");
		 VehicleData motorCycle = populateVehicles("metal","Internal Combustion","metal","rear","metal","front");
		 vehicleMap.put(motorCycle,"Motorcycle");
		 VehicleData hangGlider = populateVehicles("Hang Glider", "plastic","Bernoulli");
		 vehicleMap.put(hangGlider,hangGlider.getVehicleType());
		 VehicleData car = populateVehicles("Car", "metal","Internal Combustion","metal","left rear","metal","right rear","metal","left front","metal","right front");
		 vehicleMap.put(car,car.getVehicleType());
		 return vehicleMap;
	 }
	 
	 /**
	  * 
	  * @param frame
	  * @param terain
	  * @param values
	  * @return
	  */
	 public static VehicleData populateVehicles(String frame, String terain,String ...values)
	 {
		 //VehicleData vehicle = new
		  List<WheelData> wheels = new ArrayList<>();
		 for (int i=0; i<values.length-1;i++)
		 {
			 WheelData wheel = new WheelData();
			 wheel.setMaterial(values[i]);
			 wheel.setPosition(values[i+1]);
			 wheels.add(wheel);
			 i++;
		 }
		 Collections.sort(wheels);
		 return new VehicleData(frame,terain,wheels);
	 }

}
