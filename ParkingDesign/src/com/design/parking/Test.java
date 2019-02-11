package com.design.parking;

import com.design.parking.Vehicle.color;
import com.design.parking.Vehicle.vehicleType;

public class Test {

	public static void main(String[] args) {
		
		ParkingSlot ps = new ParkingSlot(10);
		//ps.createParkingLot(10);
		
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.BUS, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.BIKE, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);
		ps.park("12345",vehicleType.CAR, color.BLUE);		
		ps.park("12345",vehicleType.BIGCAR, color.BLUE);
		
		ps.unpark(5);
		
		
		/*
		 * Map<vehicleType,Integer> lotsMap = new HashMap<>();
		 * lotsMap.put(vehicleType.BIKE, 10); lotsMap.put(vehicleType.CAR, 10);
		 * lotsMap.put(vehicleType.BIGCAR, 10); lotsMap.put(vehicleType.BUS, 10);
		 * 
		 * lotsMap.computeIfPresent(vehicleType.CAR, (key,val) -> val-1);
		 * System.out.println("Map : "+lotsMap);
		 */	
		}
}
