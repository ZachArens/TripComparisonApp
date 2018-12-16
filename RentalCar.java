import java.text.DecimalFormat;
import java.util.ArrayList;

public class RentalCar extends Vehicle {

	private double rentalCost;
	private double insuranceCost;
	private double costPerMile;
	private int mpg;
	private double fuelCost;
	private double mileageCost;
	private DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * Class Constructor.
	 * 
	 * @param hoursTravelTime, maxPassengers, rentalCost, insuranceCost, costPerMile, mpg
	 */
	public RentalCar (double hoursTravelTime, int maxPassengers, double rentalCost, 
			double insuranceCost, double costPerMile, int mpg) {
			super(hoursTravelTime, maxPassengers);
			this.rentalCost = rentalCost;
			this.insuranceCost = insuranceCost;
			this.costPerMile = costPerMile;
			this.mpg = mpg;
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
		 * Calculate mileageCost based on tripMiles and costPerMile
		 */
		public void calcMileageCost() {
			double mileageCost = TripComparisonModel.tripMiles * costPerMile;
			
			mileageCost = Double.parseDouble(df.format(mileageCost));
			
			this.mileageCost = mileageCost;
		}
		
		/**
		 * Calculate Vehicle cost based on rental cost, insurance cost, mileage cost, fuel cost
		 * 
		 * @return vehicle cost
		 */
		public double calcVehicleCost() {
			calcFuelCost();
			calcMileageCost();
			vehicleCost = rentalCost + insuranceCost + mileageCost + fuelCost;
			vehicleCost = Double.parseDouble(df.format(vehicleCost));

			return vehicleCost;
		}

		/**
		 * @return the rentalCost
		 */
		public double getRentalCost() {
			return rentalCost;
		}

		/**
		 * @return the insuranceCost
		 */
		public double getInsuranceCost() {
			return insuranceCost;
		}

		/**
		 * @return the mpg
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
		 * @return the mileageCost
		 */
		public double getMileageCost() {
			return mileageCost;
		}

		/**
		 * @return an ArrayList of Vehicle details as strings
		 */
		public ArrayList<String> getVehicleArray() {
			ArrayList<String> rentalDetails = new ArrayList();
			rentalDetails.add("Rental Car");
			calcVehicleCost();
			rentalDetails.add("" + vehicleCost);
			rentalDetails.add("" + hoursTravelTime);
			rentalDetails.add("" + maxPassengers);
			rentalDetails.add("" + rentalCost);
			rentalDetails.add("" + insuranceCost);
			rentalDetails.add("" + mpg);
			rentalDetails.add("" + costPerMile);
			calcMileageCost();
			rentalDetails.add("" + mileageCost);
			calcFuelCost();
			rentalDetails.add("" + fuelCost);

			
			return rentalDetails;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			long temp;
			temp = Double.doubleToLongBits(costPerMile);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(fuelCost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(insuranceCost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(mileageCost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + mpg;
			temp = Double.doubleToLongBits(rentalCost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			RentalCar other = (RentalCar) obj;
			if (Double.doubleToLongBits(costPerMile) != Double.doubleToLongBits(other.costPerMile))
				return false;
			if (Double.doubleToLongBits(fuelCost) != Double.doubleToLongBits(other.fuelCost))
				return false;
			if (Double.doubleToLongBits(insuranceCost) != Double.doubleToLongBits(other.insuranceCost))
				return false;
			if (Double.doubleToLongBits(mileageCost) != Double.doubleToLongBits(other.mileageCost))
				return false;
			if (mpg != other.mpg)
				return false;
			if (Double.doubleToLongBits(rentalCost) != Double.doubleToLongBits(other.rentalCost))
				return false;
			return true;
		}

		/**
		 * TODO Comments
		 */
		public String toString() {
			calcVehicleCost();
			return "Rental Car     - Total Cost: $" + vehicleCost + "; Passengers: " + maxPassengers +
					"; Travel Time: " + hoursTravelTime + " hours"; 
		}
}
