package com.vehicle.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vehicle.data.VehicleData;
import com.vehicle.xml.data.Vehicle;
import com.vehicle.xml.data.Vehicles;
import com.vehicle.xml.data.Wheel;

public class AppUtilTest {
	
	Vehicle vehicle = null;
	Vehicles vehicles = null; 
	List<Wheel> wheelList = null;
	List<Vehicle> vehicleList = null;
	
	@Before
	public void setUp()
	{
		vehicle = new Vehicle();
		Vehicle.Frame frame = new Vehicle.Frame();
		frame.setMaterial("testFrame");
		vehicle.setFrame(frame);
		vehicle.setPowerTrain("testPowerTrain");
		vehicle.setId("1234");
		Wheel wheel = new Wheel();
		wheel.setMaterial("testMaterial");
		wheel.setPosition("testPosition");
		wheelList = new ArrayList<>();
		wheelList.add(wheel);
		Vehicle.Wheels wheels = new Vehicle.Wheels();
		wheels.setWheel(wheelList);
		vehicle.setWheels(wheels);
		vehicleList = new ArrayList<>();
		vehicleList.add(vehicle);
		vehicles = new Vehicles();
		vehicles.setVehicles(vehicleList);
	}
	
	@Test
	public void populateVehicleDataTest()
	{
		List<VehicleData> vehicleDataList = AppUtil.populateVehicleData(vehicles);
		Assert.assertEquals(1, vehicleDataList.size());
		
	}
	
	@Test
	public void populateVehiclesTest()
	{
		VehicleData vehicleData = AppUtil.populateVehicles("test123", "testTerrain","plastic","left rear","plastic","right rear","plastic","front");
		Assert.assertEquals(3, vehicleData.getWheels().size());
		
	}

}
