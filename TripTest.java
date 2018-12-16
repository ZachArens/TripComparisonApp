import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TripTest {

	@Test
	void testGetComparison() {
		Comparison rental = new Comparison("All Rentals");
		Comparison otherRental = new Comparison("All Rentals");
		
		//public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
		//double insuranceCost, double costPerMile, int mpg)
		
		Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
		Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
		Vehicle train = new Train(6, 440.25, 69.99, 30);
		Vehicle flight = new Airplane(6, 440.25, 69.99, 30);
		Vehicle owned = new OwnedCar(24, 10, 0.40, 24);
		
		rental.add(rental1);
		rental.add(rental2);
		
		otherRental.add(train);
		otherRental.add(flight);
		otherRental.add(owned);
		
		//String tripName, int numPeopleTraveling, Double fuelPrice, Double tripMiles
		
		Trip trip = new Trip("Name", 10, 2.5, 1000.0);
		
		trip.add(rental);
		trip.add(otherRental);
		
		assertEquals(rental, trip.getComparison(0));
		assertEquals(otherRental, trip.getComparison(1));
	}
	
	@Test
	void testSortComparisons() {
		Comparison rental = new Comparison("All Rentals");
		Comparison otherRental = new Comparison("Tickets and Car");
		Comparison tickets = new Comparison("Just Tickets");
		
		//public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
		//double insuranceCost, double costPerMile, int mpg)
		
		Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
		Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
		Vehicle train = new Train(6, 440.25, 69.99, 30);
		Vehicle flight = new Airplane(6, 440.25, 69.99, 30);
		Vehicle owned = new OwnedCar(24, 10, 0.40, 24);
		
		rental.add(rental1);
		rental.add(rental2);
		
		otherRental.add(train);
		otherRental.add(flight);
		otherRental.add(owned);
		
		tickets.add(train);
		tickets.add(flight);
		
		//String tripName, int numPeopleTraveling, Double fuelPrice, Double tripMiles
		
		Trip trip = new Trip("Name", 10, 2.5, 1000.0);
		Trip sortedTrip = new Trip("Name", 10, 2.5, 1000.0);
		
		trip.add(otherRental);
		trip.add(rental);
		trip.add(tickets);
		
		sortedTrip.add(rental);
		sortedTrip.add(tickets);
		sortedTrip.add(otherRental);
		
		trip.sortComparisons();
		
		assertEquals(sortedTrip, trip);
	}

	@Test
	void testToSring() {
		
			Comparison rental = new Comparison("All Rentals");
			Comparison otherRental = new Comparison("Tickets and Car");
			Comparison tickets = new Comparison("Just Tickets");
			
			//public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
			//double insuranceCost, double costPerMile, int mpg)
			
			Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
			Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
			Vehicle train = new Train(6, 440.25, 69.99, 30);
			Vehicle flight = new Airplane(6, 440.25, 69.99, 30);
			Vehicle owned = new OwnedCar(24, 10, 0.40, 24);
			
			rental.add(rental1);
			rental.add(rental2);
			
			otherRental.add(train);
			otherRental.add(flight);
			otherRental.add(owned);
			
			tickets.add(train);
			tickets.add(flight);
			
			//String tripName, int numPeopleTraveling, Double fuelPrice, Double tripMiles
			
			Trip trip = new Trip("Name", 10, 2.5, 1000.0);
			
			trip.add(otherRental);
			trip.add(rental);
			trip.add(tickets);
			
			System.out.println(trip);
	}
}
