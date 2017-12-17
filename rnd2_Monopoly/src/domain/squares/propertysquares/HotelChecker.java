package domain.squares.propertysquares;

import domain.Player;

public class HotelChecker {
	private int numHouses;
	private HouseChecker houseCheck;
	
	public HotelChecker() {
		this.houseCheck = new HouseChecker();
	}
	
	/**
	 * @param p
	 * @param property
	 * @return true if MajorityOwnership and other requirements are met for building a hotel for the property
	 */
	public boolean HotelAvailable(Player p,TitleDeed property) {
		this.numHouses = property.getNumberOfHouses();
		if (p.getBalance() >= property.getHotelCost()){
			return (getNumHouses() == 4 && property.getNumberOfHotels() < 1);
		}
		return false;
	}

	public int getNumHouses() {
		return numHouses;
	}

	public HouseChecker getHouseCheck() {
		return houseCheck;
	}
}
