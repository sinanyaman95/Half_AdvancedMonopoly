package domain.squares.propertysquares;

import java.util.ArrayList;

import domain.Player;

public class SkyscraperChecker {
	private int numHotels;
	private HotelChecker hotelCheck;
	public SkyscraperChecker() {
		this.hotelCheck = new HotelChecker();
	}
	
	/**
	 * @param p
	 * @param property
	 * @return ture if isMonopoly yields and all other properties for the same color group has hotels
	 */
	public boolean skyscraperAvailable(Player p, TitleDeed property) {
		int hotelCount = 0;
		if(this.isMonopoly(p, property) && p.getBalance() >= property.getSkyscraperCost()) {
			for(TitleDeed td: p.getOwnedTitleDeeds()) {
				if(td.getColor().equalsIgnoreCase(property.getColor()) && td.getNumberOfHotels() == 1) {
					hotelCount += 1;
				}
			}
			setNumHotels(hotelCount);
		}
		HouseChecker houseCheck = getHotelCheck().getHouseCheck();
		if(houseCheck.checkInFour(property)) {
			return (hotelCount == 4 && property.getNumberOfSkyscrapers()<1);
		}else {
			return (hotelCount == 3 && property.getNumberOfSkyscrapers()<1);
		}
	}
	
	public void setNumHotels(int numHotels) {
		this.numHotels = numHotels;
	}

	/**
	 * @param p
	 * @param property
	 * @return true if player has all properties for the same color group 
	 */
	public boolean isMonopoly(Player p, TitleDeed property) {
		int colorCount = 0;
		for (TitleDeed td : p.getOwnedTitleDeeds()) {
			if(td.getColor().equalsIgnoreCase(property.getColor())) {
				colorCount += 1;
			}
		}
		HouseChecker houseCheck = getHotelCheck().getHouseCheck();
		
		if (houseCheck.checkInFour(property)) {
			return (colorCount == 4);
		}else {
			return(colorCount ==3);
		}
	}
	

	public int getNumHotels() {
		return numHotels;
	}

	public HotelChecker getHotelCheck() {
		return hotelCheck;
	}
}
