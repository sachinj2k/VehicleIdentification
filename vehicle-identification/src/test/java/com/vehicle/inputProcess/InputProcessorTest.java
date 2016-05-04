package com.vehicle.inputProcess;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.vehicle.xml.data.Vehicles;

public class InputProcessorTest {
	
	
	@Test
	public void parseInputXmlTest()
	{
		Vehicles vehicles = null;
		try {
			File file =  new File(InputProcessor.class.getResource( "/vehicles.xml" ).toURI());
			vehicles = InputProcessor.parseInputXml(file);
		} catch (Exception e) {
			System.exit(-1);
		}
		
		Assert.assertEquals(2, vehicles.getVehicles().size());
	}

}
