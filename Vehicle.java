import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Vehicle class represents any travel information for any vehicle
 * @author ZachArens
 */
public abstract class Vehicle {
	
	protected double vehicleCost;
	protected double hoursTravelTime;
	protected int maxPassengers;
	
	/**
	 * Vehicle Constructor - vehicleCost to be calculated later
	 * @param hoursTravelTime, maxPassengers
	 */
	public Vehicle(double hoursTravelTime, int maxPassengers) {
		this.hoursTravelTime = hoursTravelTime;
		this.maxPassengers = maxPassengers;
	}
	
	/**
	 * Vehicle Constructor - vehicleCost to be calculated later, for
	 * use with ticketed vehicles where the assumed passenger amount is 1
	 * 
	 * @param hoursTravelTime
	 */
	public Vehicle(double hoursTravelTime) {
		this.hoursTravelTime = hoursTravelTime;
		this.maxPassengers = 1;
	}
	
	public abstract double calcVehicleCost();
	
	public abstract ArrayList getVehicleArray();

	/**
	 * @return the hoursTravelTime
	 */
	public double getHoursTravelTime() {
		return hoursTravelTime;
	}

	/**
	 * @return the maxPassengers
	 */
	public int getMaxPass() {
		return maxPassengers;
	}

}
