package com.vehicle.inputProcess;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.vehicle.data.VehicleData;
import com.vehicle.xml.data.Vehicles;

public class InputProcessor {
	
	
	public static Vehicles parseInputXml(File file)throws Exception{
		
		Vehicles vehicles = null;
		try 
		{
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			vehicles = (Vehicles)jaxbUnmarshaller.unmarshal(file);
			
		 } catch (JAXBException e) 
		 {
			System.err.println("Problem parsing XML "+e.getMessage());
			throw e;
		 }
		return vehicles;
	}
	
  
  public static void identifyVehicle(List<VehicleData> inputVehicleList,Map<VehicleData,String> availableVehicles)
  {
	  System.out.println("inputList "+ inputVehicleList);
	  for(VehicleData vehicleData : inputVehicleList)
	  {
		  if(availableVehicles.containsKey(vehicleData))
		  {
			  System.out.println("VehicleID : " + vehicleData.getVehicleId()+ " VehicleType : "+availableVehicles.get(vehicleData));
		  }
	  }
  }
	
}
