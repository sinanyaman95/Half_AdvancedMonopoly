package domain.squares.propertysquares;

import domain.Player;

public class BuildingFacade {
	//OVERVIEW: Building facade communicates with 3 classes HouseChecker, HotelChecker, SkyscraperChecker 
	//to decide whether player is eligible to build House, Hotel and Skyscraper and builds if so.
	private HouseChecker houseCheck;
	private HotelChecker hotelCheck;
	private SkyscraperChecker skyscraperCheck;
	
	public BuildingFacade() {
		this.houseCheck = new HouseChecker();
		this.hotelCheck = new HotelChecker();
		this.skyscraperCheck = new SkyscraperChecker();
	}
	
	/**
	 * @param p - Player
	 * @param property - TitleDeed
	 * @modifies property - number of houses is incremented by 1 in the property(if the conditions are met)
	 * @effect if all conditions are met -HouseChecker class checks for this- player builds a house to the property
	 * 
	 */
	public void buildHouse(Player p, TitleDeed property) {
		if(houseCheck.houseAvailable(p, property)) {
			property.setNumberOfHouses(property.getNumberOfHouses() + 1);
			p.setBalance(p.getBalance()-property.getHouseCost());
		}
			
	}
	
	/**
	 * @param p
	 * @param property
	 * @modifies property - number of hotels is incremented by 1 in the property(if the conditions are met)
	 * @effect if all conditions are met -HotelChecker class checks for this- player builds a hotel to the property
	 */
	public void buildHotel(Player p, TitleDeed property) {
		if(hotelCheck.HotelAvailable(p, property)) {
			property.setNumberOfHotels(property.getNumberOfHotels() + 1);
			p.setBalance(p.getBalance()-property.getHotelCost());
		}
	}
	
	/**
	 * @param p
	 * @param property
	 * @modifies property - number of skyscrapers is incremented by 1 in the property(if the conditions are met)
	 * @effect if all conditions are met -SkyscraperChecker class checks for this- player builds a skyscraper to the property
	 */
	public void buildSkyscraper(Player p, TitleDeed property) {
		if(skyscraperCheck.skyscraperAvailable(p, property)) {
			property.setNumberOfSkyscrapers(property.getNumberOfSkyscrapers() + 1);
			p.setBalance(p.getBalance()-property.getSkyscraperCost());
		}
	}
}
