package com.vehicle.inputProcess;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.vehicle.data.VehicleData;
import com.vehicle.util.AppUtil;
import com.vehicle.xml.data.Vehicles;

public class MainExecutionClass {

	public static void main(String[] args) {
		
		processAndFindResult();

	}
   /**
    * 	
    */
	private static void processAndFindResult()
	{
		Vehicles vehicles = null;
		try {
			File file =  new File(MainExecutionClass.class.getResource( "/vehicles.xml" ).toURI());
			vehicles = InputProcessor.parseInputXml(file);
		} catch (Exception e) {
			System.exit(-1);
		}
		List<VehicleData> inputVehicleList = AppUtil.populateVehicleData(vehicles);
		Map<VehicleData,String> availableVehicles = AppUtil.getAvailableVehicleTypes();
		InputProcessor.identifyVehicle(inputVehicleList,availableVehicles);

	}

}
