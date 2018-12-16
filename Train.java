import java.text.DecimalFormat;
import java.util.ArrayList;

public class Train extends Vehicle {
	
	double ticketCost;
	double feesTaxes;
	double parkTaxiEtc;
	private DecimalFormat df = new DecimalFormat("#.00");

	
	/**
	 * Class Constructor.
	 * 
	 * @param vehicleCost, hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc
	 */
	public Train(double hoursTravelTime, double ticketCost, double feesTaxes, 
			double parkTaxiEtc) {
		
		super(hoursTravelTime);
		this.ticketCost = ticketCost;
		this.feesTaxes = feesTaxes;
		this.parkTaxiEtc = parkTaxiEtc;
		calcVehicleCost();
	}
	/**
	 * Calculate Vehicle Cost based on ticketCost, feesTaxes, parkTaxiEtc
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
	 * @return an ArrayList of Vehicle details as strings
	 */
	public ArrayList getVehicleArray() {
		ArrayList<String> trainDetails = new ArrayList();
		trainDetails.add("Train");
		calcVehicleCost();
		trainDetails.add("" + vehicleCost);
		trainDetails.add("" + hoursTravelTime);
		trainDetails.add("" + maxPassengers);
		trainDetails.add("" + ticketCost);
		trainDetails.add("" + feesTaxes);
		trainDetails.add("" + parkTaxiEtc);

		
		return trainDetails;
	}
	
	/**
	 * @return String of Train details
	 */
	public String toString() {
		return "Train          - Total Cost: $" + calcVehicleCost() + "; Passengers: 1" +
				"; Travel Time: " + hoursTravelTime + " hours"; 
	}
}
