import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;

/**
 * TODO Comments
 * 
 * @author ZacharyArens
 *
 */
public class TripComparisonModel {
	private Trip currentTrip;
	private Comparison currentComparison;
	public static double tripMiles;
	public static double tripFuelPrice;
	private PrintWriter export;
	private File exportFile;
	
	public TripComparisonModel() {
		
	}
	
	public Trip newTrip(String tripName, int numPeopleTraveling, Double fuelPrice, Double tripMiles) {
		currentTrip = new Trip(tripName, numPeopleTraveling, fuelPrice, tripMiles);
		currentComparison = new Comparison();
		return currentTrip;
	}
	
	public Trip getTrip() {
		return currentTrip;
	}
	
	
	
	public String printPassengers() {
		int passAccomodated;
		try {
			passAccomodated = currentComparison.getPassAccomodated();
		} catch (NullPointerException e) {
			passAccomodated = 0;
		}
		int passNeeded = currentTrip.getNumPeopleTraveling() - passAccomodated;
		int tripPassengers = currentTrip.getNumPeopleTraveling();
		String passengerStatement = passNeeded + " of " + tripPassengers + " still need a ride.";

		return passengerStatement;
	}
	
	//params to instantiate new Vehicle - may need addFlight, addTrain, etc
	public void addFlight(double hoursTravelTime,
			double ticketCost, double feesTaxes, double parkTaxiEtc) {
		
		Vehicle addedVehicle = new Airplane(hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc);
		currentComparison.add(addedVehicle);
		}
	
	public void addTrain(double hoursTravelTime, double ticketCost, double feesTaxes, 
			double parkTaxiEtc) {
		
		Vehicle addedVehicle = new Train(hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc);
		currentComparison.add(addedVehicle);
	}
	
	public void addOwnedCar(double hoursTravelTime, int maxPassengers, double maintCostPerMile, 
			 int mpg) {
		
		Vehicle addedVehicle = new OwnedCar(hoursTravelTime, maxPassengers, maintCostPerMile, mpg);
		currentComparison.add(addedVehicle);
	}
	
	public void addRentalCar(double hoursTravelTime, int maxPassengers, double rentalCost, 
			double insuranceCost, double costPerMile, int mpg) {
		
		Vehicle addedVehicle = new RentalCar(hoursTravelTime, maxPassengers, rentalCost, 
			insuranceCost, costPerMile, mpg);
		currentComparison.add(addedVehicle);
	}
	
	public ArrayList<String> pullVehicle(int index) {
		ArrayList<String> vehicleArray = currentComparison.remove(index);
		return vehicleArray;
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return currentComparison.getList();
	}
	
	public Comparison getComparison(int index) {
		return currentTrip.getComparison(index);
	}
	
	public Comparison removeComparison(int index) {
		currentComparison = currentTrip.remove(index);
		return currentComparison;
	}
	
	public int comparisonListSize() {
		return currentTrip.size();
	}
	
	public void submitComparison(String name) {
		//TODO
		//setComparisonName
		currentComparison.setName(name);
		currentTrip.add(currentComparison);
		currentComparison = new Comparison();
	}

	public ArrayList<Comparison> getComparisons() {
		
		return currentTrip.getList();
	}

	public void saveToTxtFile() {
		//exportFile = new File(fileName + ".txt");
		
		JFileChooser chooser = new JFileChooser();
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
		
			exportFile = chooser.getSelectedFile();
	
			try {
				export = new PrintWriter(exportFile);
				export.print("" + currentTrip);
			} catch(FileNotFoundException e) {
				System.out.println("FileNotFoundException");
			} finally {
				export.close();
			}
		}
		
	}

}
