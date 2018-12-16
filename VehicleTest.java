import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void testRentalCarConstructor() {
		Trip trip = new Trip("Trip", 12, 2.4, 1000.0);
		
		RentalCar rental = new RentalCar(24, 10, 400.25, 
			60.99, 0.40, 24);
		
		double hours = 24;
		int pass = 10;
		double rentCost = 400.25;
		double insCost = 60.99;
		double mileCost = 0.40;
		int mpg = 24;
		
		assertEquals(hours, rental.getHoursTravelTime(), 10);
		assertEquals(pass, rental.getMaxPass());
		assertEquals(rentCost, rental.getRentalCost(), 10);
		assertEquals(insCost, rental.getInsuranceCost(), 10);
		assertEquals(mileCost, rental.getMileageCost(), 10);
		assertEquals(mpg, rental.getMpg());
	}
	
	@Test
	void testRentalCalcCost() {
		Trip trip = new Trip("Trip", 12, 2.4, 1000.0);
		
		RentalCar rental;
		
		rental = new RentalCar(24, 10, 400.25, 
				60.99, 0.40, 24);
		
		double vehCost = rental.calcVehicleCost();
		
		assertEquals(100, rental.getFuelCost(), 10);
		assertEquals(400, rental.getMileageCost(), 10);
		assertEquals(400.25, rental.getRentalCost(), 10);
		assertEquals(60.99, rental.getInsuranceCost(), 10);
		assertEquals(961.24, vehCost, 2);
	}
	
	@Test
	void testOwnedCarConstructor() {
		
		Trip trip = new Trip("Trip", 12, 2.4, 1000.0);
		//(double hoursTravelTime, int maxPassengers, double maintCostPerMile, int mpg)
		OwnedCar car = new OwnedCar(24, 10, 0.40, 24);
		OwnedCar otherCar = new OwnedCar(24, 10, 0.40, 24);
		
		double hours = 24;
		int pass = 10;
		double mileCost = 0.40;
		int mpg = 24;
		
		assertEquals(hours, car.getHoursTravelTime(), 10);
		assertEquals(pass, car.getMaxPass());
		assertEquals(mileCost, car.getMaintCostPerMile(), 10);
		assertEquals(mpg, car.getMpg());
	}
	
	@Test
	void testOwnedCalcCost() {
		Trip trip = new Trip("Trip", 12, 2.4, 1000.0);

		OwnedCar car = new OwnedCar(24, 10, 0.40, 24);
		
		double vehCost = car.calcVehicleCost();
		
		assertEquals(100, car.getFuelCost(), 10);
		assertEquals(400, car.getMileageCost(), 10);
		assertEquals(500, vehCost, 2);
	}
	
	
	@Test
	void testConstructorAirplane() {
		
		Trip trip = new Trip("Trip", 12, 2.4, 1000.0);
		//(double hoursTravelTime, int maxPassengers, double maintCostPerMile, int mpg)
		Airplane flight = new Airplane(24, 383, 100, 70);
		
		double hours = 24;
		double ticketCost = 383;
		double feesTaxes = 100;
		double parkTaxiEtc = 70;
		
		assertEquals(hours, flight.getHoursTravelTime(), 10);
		assertEquals(ticketCost, flight.getTicketCost(), 10);
		assertEquals(feesTaxes, flight.getFeesTaxes(), 10);
		assertEquals(parkTaxiEtc, flight.getParkTaxiEtc(), 10);
	}
	
	@Test
	void testConstructorTrain() {
		Train train= new Train(6, 440.25, 69.99, 30);
		train.calcVehicleCost();		
		
		double hours = 6;
		double ticketCost = 440.25;
		double feesTaxes = 69.99;
		double parkTaxiEtc = 30;
		
		assertEquals(hours, train.getHoursTravelTime(), 10);
		assertEquals(ticketCost, train.getTicketCost(), 10);
		assertEquals(feesTaxes, train.getFeesTaxes(), 10);
		assertEquals(parkTaxiEtc, train.getParkTaxiEtc(), 10);
	}
	
	@Test
	void testGetHoursTravelTime() {
		Train train= new Train(6, 440.25, 69.99, 30);
		train.calcVehicleCost();
		
		double travelTime = train.getHoursTravelTime();
		assertEquals(6, travelTime, 10);
	}

}
