import java.util.ArrayList;

/**
 * Manages an ArrayList of Vehicles
 * 
 * @author ZacharyArens
 *
 */
public class Comparison implements Comparable{
	
	private ArrayList<Vehicle> vehicleList;
	private String name;
	//private double totalCost;
	//private double maxHrsTravelTime;
	//private int passAccomodated;
	
	/**
	 * Comparison Constructor - with name
	 * @param name
	 */
	public Comparison(String name) { 		// instantiate the queue/list
		vehicleList = new ArrayList<Vehicle>();
		this.name = name;
	} 
	
	/**
	 * Comparison Constructor - without name
	 */
	public Comparison() {
		vehicleList = new ArrayList<Vehicle>();
	}
	
	/** 
	 * Gets the Comparison name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the parameter name as the Comparison name
	 * 
	 * @param
	 */
	public void setName(String name) {
		this.name = name;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public boolean isEmpty() { 
//		return vehicleList.isEmpty();
//	}
 
	/**
	 * Adds Vehicle vehicle to this Comparison's list of Vehicles
	 * 
	 * @param vehicle
	 */
	public void add(Vehicle vehicle) { 
		//TODO
		vehicleList.add(vehicle);
		
	}	
	
	/**
	 * Returns the total cost for all passengers and vehicles to travel to the destination
	 * for this comparison
	 * 
	 * @return total cost for this comparison
	 */
	public double getTotalComparisonCost() {
		double totalCost = 0;
		for (Vehicle vehicle : vehicleList) {
			double vehicleCost = vehicle.calcVehicleCost();
			totalCost = totalCost + vehicleCost;
		}
		return totalCost;
	}
		
		
	/**
	 * Returns the maximum hours of travel time it will take all passengers to reach the destination
	 * in this comparison
	 * 
	 * @return maximum hours of travel time
	 */
	public double getHoursTravelTime() {
		double hoursTravelTime = 0;
		for (Vehicle vehicle : vehicleList) {
			double vehicleTravelTime = vehicle.getHoursTravelTime();
			if (hoursTravelTime < vehicleTravelTime) { 
				hoursTravelTime = vehicleTravelTime; 
				}
		}
		return hoursTravelTime;
	}
	
	/**
	 * getMaxPassengers returns the maximum amount of passengers a vehicle can carry
	 * 
	 * @return amount of passengers a vehicle can carry
	 */
	public int getPassAccomodated() {
		int maxPassengers = 0;
		for (Vehicle vehicle : vehicleList) {
			int vehiclePass = vehicle.getMaxPass();
			maxPassengers = maxPassengers + vehiclePass;
		}
		
		return maxPassengers;
	}
	
	/**
	 * Returns an ArrayList of Vehicle type from this Comparison
	 * 
	 * @return an ArrayList of Vehicle type from this Comparison
	 */
	public ArrayList<Vehicle> getList() {
		return vehicleList;
	}
	
	/**
	 * Removes the Vehicle of index-listIndex and returns an array of Vehicle info as strings
	 * @param listIndex
	 * @return removed Vehicle as Array of Strings
	 * @throws IndexOutOfBoundsException
	 */
	
	public ArrayList<String> remove(int listIndex) throws IndexOutOfBoundsException {
		
		//
		if (vehicleList.isEmpty()) {
			throw new IndexOutOfBoundsException("No elements to remove from list!");
			}
		Vehicle vehicle = vehicleList.get(listIndex);
		ArrayList<String> vehicleArray = vehicle.getVehicleArray();
		vehicleList.remove(listIndex);
		
		return vehicleArray;
	}
	
	/**
	 * Compares this Comparison to other Comparison first by name, then by total cost, 
	 * then by hours travel time.
	 * 
	 * Returns -1 if this method is first alphabetical (name) or less (cost, hours)
	 * Returns 1 if this method is last alphabetical (name) or more (cost, hours)
	 * Returns 0 if this method is the same name, cost, and hours
	 * 
	 * @param other Comparison
	 * @return -1, 0, 1
	 */
	public int compareTo(Object o) {
		Comparison other = (Comparison) o;
		int result = name.compareTo(other.getName());
		
		if (result == 0) {
			if( getTotalComparisonCost() < other.getTotalComparisonCost()) {return -1;}
		      if(getTotalComparisonCost() < other.getTotalComparisonCost()) {return 1;}
		}
		
		if (result == 0) {
			if( getHoursTravelTime() < other.getHoursTravelTime()) {return -1;}
		      if(getHoursTravelTime() < other.getHoursTravelTime()) {return 1;}
		}
				
		return result;
	}
	
	/**
	 * printSummary @return custom string with Summary
	 * 
	 * @return full summary of Comparison as String
	 */
	public String printSummary() {
		String outputString = "Comparison " ;
		double totalCompCost = getTotalComparisonCost();
		double maxTravelTime = getHoursTravelTime();
		int passAccomodated = getPassAccomodated();
		
	
		try {
			name.trim();
			outputString = outputString + "\"" + name + "\" - ";
		} catch (NullPointerException e) {
			outputString += " - ";
		}
		
		outputString = outputString + "\nTotal Cost: " + totalCompCost + "\nMax Travel Time: " +
				maxTravelTime + "\nTotal Passengers Accommodated: " + passAccomodated;
		
		for(Vehicle vehicle: vehicleList) {
			outputString += ("\n\t" + vehicle + ";");
		}
		
		return outputString;
	}
	
	/**
	 * toString - brief representation of Comparison
	 * 
	 * @return String
	 */
	public String toString() {
		String outputString = "";
		double totalCompCost = getTotalComparisonCost();
		double maxTravelTime = getHoursTravelTime();
		int vehicleCount = 0;
		
	
		try {
			name.trim();
			outputString = outputString + "\"" + name + "\" - ";
		} catch (NullPointerException e) {
			outputString += " - ";
		}
		
		outputString += " $" + totalCompCost + ", " +
				maxTravelTime + " hrs, ";
		
		for(Vehicle vehicle: vehicleList) {
			vehicleCount ++;
		}
		outputString += vehicleCount + " vehicles";
		
		return outputString;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comparison other = (Comparison) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
//		if (passAccomodated != other.passAccomodated)
//			return false;
		if (vehicleList == null) {
			if (other.vehicleList != null)
				return false;
		} else if (!vehicleList.equals(other.vehicleList))
			return false;
		return true;
	}	
	
}
