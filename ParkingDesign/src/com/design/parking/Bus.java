package com.design.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class Bus extends Vehicle {
	private int charges = 100;
	LocalDateTime dateTime;
	
	public Bus(String np , color c) 
	{
		noPlate = np;
		dateTime = LocalDateTime.now();
	}

	public long getCarges()
	{
		LocalDateTime now = LocalDateTime.now();
		long hrs = Duration.between(dateTime, now).toHours();
		long charge = charges * hrs;
		
		return charge;
	}
}
