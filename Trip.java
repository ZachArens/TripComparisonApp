import java.util.ArrayList;

/**
 * A collection of comparisons for use in comparing different vacation travel arrangements
 * 
 * @author ZacharyArens
 *
 */
public class Trip {
	private ArrayList<Comparison> comparisonList;
	private String tripName;
	protected int numPeopleTraveling;
	
	/**
	 * Class Constructor.
	 * 
	 * @param tripName, numPeopleTraveling, fuelPrice, tripMiles
	 */
	public Trip(String tripName, int numPeopleTraveling, Double fuelPrice, Double tripMiles) {
		comparisonList = new ArrayList<Comparison>();
		this.tripName = tripName;
		this.numPeopleTraveling = numPeopleTraveling;
		TripComparisonModel.tripFuelPrice = fuelPrice;
		TripComparisonModel.tripMiles = tripMiles;
	}
	
	/**
	 * Test if this trip's ArrayList<Comparison> comparisonList is empty or contains values
	 * 
	 * @return true if the queue is empty, otherwise false  
	 */
	public boolean isEmpty() { 
		return comparisonList.isEmpty();
	}
	
	/**
	 * Get the size of this trip's comparisonList
	 * 
	 * @return size
	 */
	public int size() {
		return comparisonList.size();
	}
	
	/**
	 * Adds a Comparison to this Trip's comparisonList
	 * 
	 * @param comparison
	 */
	public void add(Comparison comparison) { 
		//TODO		
		comparisonList.add(comparison);
	}
	
	/**
	 * Returns the most recently (highest indexed) Comparison from this Trip's comparisonList
	 * 
	 * @return most recently added comparison
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Comparison getActiveComparison() throws ArrayIndexOutOfBoundsException {
		if (comparisonList.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("No Available Comparison");
		} else {
			return comparisonList.get(comparisonList.size() - 1);
		}
	}
	
	/**
	 * Returns the comparison of index
	 * 
	 * @param index
	 * @return comparison
	 */
	public Comparison getComparison(int index) {
		return comparisonList.get(index);
	}
	
	/**
	 * Removes the Comparison of listIndex and returns the removed Comparison
	 * 
	 * @param listIndex
	 * @return comparison
	 * @throws IndexOutOfBoundsException
	 */
	
	public Comparison remove(int listIndex) throws IndexOutOfBoundsException {
		
		//
		if (comparisonList.isEmpty()) {
			throw new IndexOutOfBoundsException("No elements to remove from list!");
			}
		
		return comparisonList.remove(listIndex);
	}
	
	/**
	 * Returns an ArrayList of this Trip's comparisonList
	 * 
	 * @return an ArrayList of Comparisons
	 */
	public ArrayList<Comparison> getList() {
		return comparisonList;
	}

//	public Comparison removeComparison(int index) {
//		return comparisonList.remove(index);
//	}

	/**
	 * Sorts the comparisons by name, then total cost, then hours travel time
	 */
	public void sortComparisons() {
		comparisonList.sort(null);
		
	}
	
	/**
	 * Returns the number of people traveling in this trip
	 * 
	 * @return number of people traveling in this trip
	 */
	public int getNumPeopleTraveling() {
		return numPeopleTraveling;
	}

	/**
	 * Returns a string representation of this string
	 * 
	 * @return String trip
	 */
	@Override
	public String toString() {
		String outputString = tripName + " Trip :\n\n" +
				numPeopleTraveling + " people traveling " + TripComparisonModel.tripMiles + " miles\n\n\n";
		
		for (Comparison comparison: comparisonList) {
			outputString += comparison.printSummary() + "\n\n";
		}
		
		return outputString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comparisonList == null) ? 0 : comparisonList.hashCode());
		result = prime * result + numPeopleTraveling;
		result = prime * result + ((tripName == null) ? 0 : tripName.hashCode());
		return result;
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
		Trip other = (Trip) obj;
		if (comparisonList == null) {
			if (other.comparisonList != null)
				return false;
		} else if (!comparisonList.equals(other.comparisonList))
			return false;
		if (numPeopleTraveling != other.numPeopleTraveling)
			return false;
		if (tripName == null) {
			if (other.tripName != null)
				return false;
		} else if (!tripName.equals(other.tripName))
			return false;
		return true;
	}
	
	
	
}
