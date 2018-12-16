import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ComparisonTest {

	@Test
	void testComparisonConstructor() {
		Comparison rental = new Comparison ("All Rentals");
		Comparison otherRental = new Comparison ("All Rentals");
		
		//public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
		//double insuranceCost, double costPerMile, int mpg)
		
		Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
		Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
		Vehicle train = new Train(6, 440.25, 69.99, 30);
		Vehicle flight = new Airplane(6, 440.25, 69.99, 30);
		Vehicle owned = new OwnedCar(24, 10, 0.40, 24);
		
		rental.add(rental1);
		rental.add(rental2);
		rental.add(train);
		rental.add(flight);
		rental.add(owned);
		
		otherRental.add(rental1);
		otherRental.add(rental2);
		otherRental.add(train);
		otherRental.add(flight);
		otherRental.add(owned);
		
		//System.out.println(rental);
		assertEquals(rental, otherRental);
	}
	
	@Test
	void testComparisonRemove() {
		Comparison rental = new Comparison("All Rentals");
		Comparison otherRental = new Comparison("All Rentals");
		
		//public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
		//double insuranceCost, double costPerMile, int mpg)
		
		Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
		Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
		
		rental.add(rental1);
		rental.add(rental2);
		ArrayList<String> removedRental = rental.remove(0);
		ArrayList<String> testArray = rental1.getVehicleArray();
		
		otherRental.add(rental2);
		
		//System.out.println(rental);
		assertEquals(rental, otherRental);
		assertEquals(removedRental, testArray);
	}
	
	@Test
	void testGetPassAccomodated() {
		Comparison rental = new Comparison("All Rentals");
		Comparison otherRental = new Comparison("All Rentals");
		
		Vehicle rental1 = new RentalCar(24, 5, 499.25, 75.96, 0.25, 24);
		Vehicle rental2 = new RentalCar(24, 7, 523.99, 89.99, 0.33, 22);
		
		rental.add(rental1);
		rental.add(rental2);
		
		assertEquals(12, rental.getPassAccomodated());
		
	}

}
