import java.text.DecimalFormat;
import java.util.ArrayList;

public class Airplane extends Vehicle {

	double ticketCost;
	double feesTaxes;
	double parkTaxiEtc;
	private DecimalFormat df = new DecimalFormat("#.00");

	
	/**
	 * Class Constructor
	 * 
	 * @param hoursTravelTime, vehicleCost, ticketCost, feesTaxes, parkTaxiEtc
	 */
	public Airplane(double hoursTravelTime,
			double ticketCost, double feesTaxes, double parkTaxiEtc) {
		
		super(hoursTravelTime);
		this.ticketCost = ticketCost;
		this.feesTaxes = feesTaxes;
		this.parkTaxiEtc = parkTaxiEtc;
		
		calcVehicleCost();
	}
	
	/**
	 * Calculate a Vehicle's Cost based on ticket cost, fees and taxes, and parking and taxi
	 * 
	 * @return vehicle cost
	 */
	public double calcVehicleCost() {
		vehicleCost = ticketCost + feesTaxes + parkTaxiEtc;
		vehicleCost = Double.parseDouble(df.format(vehicleCost));
		
		return vehicleCost;
	}
	
	/**
	 * @return the ticketCost
	 */
	public double getTicketCost() {
		return ticketCost;
	}
	
	/**
	 * @return the feesTaxes
	 */
	public double getFeesTaxes() {
		return feesTaxes;
	}
	
	/**
	 * @return the parkTaxiEtc
	 */
	public double getParkTaxiEtc() {
		return parkTaxiEtc;
	}

	/**
	 * @return an ArrayList of details for this flight
	 */
	public ArrayList getVehicleArray() {
		ArrayList<String> flightDetails = new ArrayList();
		flightDetails.add("Flight");
		calcVehicleCost();
		flightDetails.add("" + vehicleCost);
		flightDetails.add("" + hoursTravelTime);
		flightDetails.add("" + maxPassengers);
		flightDetails.add("" + ticketCost);
		flightDetails.add("" + feesTaxes);
		flightDetails.add("" + parkTaxiEtc);

		
		return flightDetails;
	}
	
	/**
	 * @return a string of flight details
	 */
	public String toString() {
		return "Flight         - Total Cost: $" + calcVehicleCost() + "; Passengers: " + maxPassengers +
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
		temp = Double.doubleToLongBits(feesTaxes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(parkTaxiEtc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ticketCost);
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
		Airplane other = (Airplane) obj;
		if (Double.doubleToLongBits(feesTaxes) != Double.doubleToLongBits(other.feesTaxes))
			return false;
		if (Double.doubleToLongBits(parkTaxiEtc) != Double.doubleToLongBits(other.parkTaxiEtc))
			return false;
		if (Double.doubleToLongBits(ticketCost) != Double.doubleToLongBits(other.ticketCost))
			return false;
		return true;
	}
}
