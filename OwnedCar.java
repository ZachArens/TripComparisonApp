import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * TODO Comments
 * @author ZacharyArens
 *
 */
public class OwnedCar extends Vehicle {
	
	protected double maintCostPerMile;
	protected int mpg;
	protected double fuelCost;
	protected double mileageCost;
	private DecimalFormat df = new DecimalFormat("#.00");

	
	
	/**
	 * Class constructor 
	 * 
	 * @param hoursTravelTime, maxPassengers, maintCostPerMile, mpg
	 */
	public OwnedCar (double hoursTravelTime, int maxPassengers, double maintCostPerMile, 
		 int mpg) {
		super(hoursTravelTime, maxPassengers);
		this.maintCostPerMile = maintCostPerMile;
		this.mpg = mpg;
		calcVehicleCost();
	}
	
	/**
	 * Calculates fuelCost based on mpg and tripMiles and fuelPrice
	 */
	public void calcFuelCost() {
		double fuelCost = (TripComparisonModel.tripMiles/mpg) * TripComparisonModel.tripFuelPrice;
		fuelCost = Double.parseDouble(df.format(fuelCost));
		
		this.fuelCost = fuelCost;
	}
	
	/**
	 * Calculates mileageCost based on tripMiles and maintCostPerMile;
	 */
	public void calcMileageCost() {
		double mileageCost = (TripComparisonModel.tripMiles) * maintCostPerMile;
		
		mileageCost = Double.parseDouble(df.format(mileageCost));
		
		this.mileageCost = mileageCost;
		
	}
	
	/**
	 * Calculates vehicle cost based on mileageCost and fuelCost.
	 * 
	 * @return vehicle cost
	 */
	public double calcVehicleCost() {
		calcFuelCost();
		calcMileageCost();
		vehicleCost = mileageCost + fuelCost;
		vehicleCost = Double.parseDouble(df.format(vehicleCost));

		return vehicleCost;
	}
	
	/**
	 * @return the maintenance cost per mile
	 */
	public double getMaintCostPerMile() {
		return maintCostPerMile;
	}

	/**
	 * @return the miles per gallon (mpg)
	 */
	public int getMpg() {
		return mpg;
	}

	/**
	 * @return the fuelCost
	 */
	public double getFuelCost() {
		return fuelCost;
	}

	/**
	 * @return the ownerTripCost
	 */
	public double getMileageCost() {
		return mileageCost;
	}

	/**
	 * @return an ArrayList of Vehicle details as strings
	 */
	public ArrayList<String> getVehicleArray() {
		ArrayList<String> ownCarDetails = new ArrayList();
		ownCarDetails.add("Owned Car");
		calcVehicleCost();
		ownCarDetails.add("" + vehicleCost);
		ownCarDetails.add("" + hoursTravelTime);
		ownCarDetails.add("" + maxPassengers);
		ownCarDetails.add("" + maintCostPerMile);
		calcMileageCost();
		ownCarDetails.add("" + mileageCost);
		ownCarDetails.add("" + mpg);
		calcFuelCost();
		ownCarDetails.add("" + fuelCost);

		
		return ownCarDetails;
	}
	
	/**
	 * @return a summary of Owned Car details
	 */
	public String toString() {
		calcVehicleCost();
		return "Car            - Total Cost: $" + vehicleCost + "; Passengers: " + maxPassengers +
				"; Travel Time: " + hoursTravelTime + " hours"; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(fuelCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maintCostPerMile);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mileageCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mpg;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OwnedCar other = (OwnedCar) obj;
		if (Double.doubleToLongBits(fuelCost) != Double.doubleToLongBits(other.fuelCost))
			return false;
		if (Double.doubleToLongBits(maintCostPerMile) != Double.doubleToLongBits(other.maintCostPerMile))
			return false;
		if (Double.doubleToLongBits(mileageCost) != Double.doubleToLongBits(other.mileageCost))
			return false;
		if (mpg != other.mpg)
			return false;
		return true;
	}
	
	
}
