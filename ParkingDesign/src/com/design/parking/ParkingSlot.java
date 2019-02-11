package com.design.parking;
import java.util.*;
import com.design.parking.Vehicle.color;
import com.design.parking.Vehicle.vehicleType;

public class ParkingSlot {
	
	private volatile int bikeSlotNo;
	private volatile int carSlotNo;
	private volatile int bigCarSlotNo;
	private volatile int busSlotNo;

	private int MAX_SIZE;
	private Map<vehicleType, Integer> lotsMap = new HashMap<>();
	private Map<Integer, Vehicle> parkedMap = new HashMap<>();

	public ParkingSlot(int lotCount)
	{
		MAX_SIZE = lotCount;
		lotsMap.put(vehicleType.BIKE, 10);
		lotsMap.put(vehicleType.CAR, 10);
		lotsMap.put(vehicleType.BIGCAR, 10);
		lotsMap.put(vehicleType.BUS, 10);

		System.out.println("Created parking lot with " + lotCount + " slots");
	}

	
	/*
	 * public void createParkingLot(int lotCount) { MAX_SIZE = lotCount;
	 * lotsMap.put(vehicleType.BIKE, 10); lotsMap.put(vehicleType.CAR, 10);
	 * lotsMap.put(vehicleType.BIGCAR, 10); lotsMap.put(vehicleType.BUS, 10);
	 * 
	 * System.out.println("Created parking lot with " + lotCount + " slots"); }
	 */
	public void park(String noPlate, vehicleType vType, color c) {
		int slotSize = lotsMap.get(vType);

		if (slotSize > 0 && slotSize <= MAX_SIZE)
		{
			Vehicle veh = createVehicle(vType, noPlate, c);
			int allocate = lotsMap.computeIfPresent(vType, (key, val) -> val - 1);
			
			if(allocate >= 0)
			{	
				switch (vType) {
				case CAR:
					parkedMap.put(++carSlotNo, veh);
					break;
				case BIKE:
					parkedMap.put(++bikeSlotNo, veh);
					break;

				case BIGCAR:
					parkedMap.put(++bigCarSlotNo, veh);
					break;

				case BUS:
					parkedMap.put(++busSlotNo, veh);
					break;
			     }
				
			System.out.println("Allocate : "+ allocate);
			System.out.println("Allocated slot number: " + carSlotNo);
			System.out.println("Map : " + lotsMap);
			
			//System.out.println("parkedMap : " + parkedMap);
			}
		} else
			System.out.println("Parking is Full");
	}

	private Vehicle createVehicle(vehicleType vType, String noPlate, color c) {
       
		Vehicle vehcle = null;

		switch (vType) {
		case CAR:
			vehcle = new Car(noPlate, c);
			break;
		case BIKE:
			vehcle = new Bike(noPlate, c);
			break;

		case BIGCAR:
			vehcle = new BigCar(noPlate, c);
			break;

		case BUS:
			vehcle = new Bus(noPlate, c);
			break;
		}
		return vehcle;
	}

	public long unpark(int slotNo) 
	{
		Vehicle vehicle = parkedMap.get(slotNo);
		int available = 0;
		long charge = 0;
		
		 if(vehicle != null)
		 {
			 parkedMap.remove(slotNo);
			 System.out.println("Vehicle Unparked : "+ vehicle);
			 
			 if(vehicle instanceof Bike)
				 available = lotsMap.computeIfPresent(vehicleType.BIKE, (key, val) -> val + 1);
			 else if (vehicle instanceof Car)
				 available = lotsMap.computeIfPresent(vehicleType.CAR, (key, val) -> val + 1);
			 else if (vehicle instanceof BigCar)
				 available = lotsMap.computeIfPresent(vehicleType.BIGCAR, (key, val) -> val + 1);
			 else if (vehicle instanceof Bus)
				 available = lotsMap.computeIfPresent(vehicleType.BUS, (key, val) -> val + 1);
			 
			 System.out.println("Available Slots : "+ available);
		 }
		 charge = charges(vehicle) ;
		 
		return charge; 
	}
	
	private long charges(Vehicle vehicle) {
		long charges = 0;
		Bike b = null;
		Car c = null;
		BigCar bc = null;
		Bus bs = null;

		if (vehicle instanceof Bike) {
			b = (Bike) vehicle;
			charges = b.getCarges();
		} else if (vehicle instanceof Car) {
			c = (Car) vehicle;
			charges = c.getCarges();
		} else if (vehicle instanceof BigCar) {
			bc = (BigCar) vehicle;
			charges = bc.getCarges();
		} else if (vehicle instanceof Bus) {
			bs = (Bus) vehicle;
			charges = bs.getCarges();
		}
		return charges;
	}
}
