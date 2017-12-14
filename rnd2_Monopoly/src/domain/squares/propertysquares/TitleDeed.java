package domain.squares.propertysquares;

import java.util.ArrayList;

import domain.MonopolyGameController;
import domain.Player;
import domain.squares.BuyableBehavior;
import domain.squares.canBuy;
import domain.squares.notBuy;

public class TitleDeed extends PropertySquare {
	

	
	public int index;
	public double zeroRent;
	public ArrayList<Double> titled_rent;
	public int buildingPrice;
	
	public boolean twoColorDeed;
	public boolean threeColorDeed;
	public int numberOfHouses;
	public int numberOfHotels;
	public int numberOfSkyscrapers;
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	public TitleDeed(int index,String name,String color,int price,int zeroRent,int mortgageVal,int numberOfHouses, 
			int numberOfHotels, int numberOfSkyscrapers, int buildingPrice) {
		
		super();
		this.index=index;
		this.name = name;
		this.color=color;
		this.price=price;
		this.zeroRent=zeroRent;
		this.mortgageValue=mortgageVal;
		this.numberOfHouses = numberOfHouses;
		this.numberOfHotels = numberOfHotels;
		this.numberOfSkyscrapers = numberOfSkyscrapers;
		this.titled_rent = new ArrayList<Double>();
		this.mortgageStatus=false;
		
		//We'll discuss this part, it might cause bugs.
		// Do we need buyable field since it is property square for sure??
		/*if(owner==MonopolyGameController.bank) {
			buyable = new notBuy();
		}else {
			buyable = new canBuy();
		}*/
	}

	@Override
	public void performPurchase(Player p,PropertySquare s) {
			// if the owner of the title deed is the bank
			// (no one owns the title deed), assign the new owner and update balance
			if (/*s.getOwner().getName().equals("Bank") && */p.getBalance() >= s.getPrice()) {
				MonopolyGameController.bank.getOwnedTitleDeeds().remove(s);
				s.setOwner(p);
				p.getOwnedTitleDeeds().add((TitleDeed)s);
				p.setBalance(p.getBalance() - s.getPrice());

			}
	}
	public BuyableBehavior isBuyable() {
		return buyable;
	}
	
	@Override
	public Player getOwner() {
	
		return this.owner;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner=owner;
		
	}

	@Override
	public int getPrice() {

		return this.price;
	}

	public void increaseNumberOfHouses() {
		this.setNumberOfHouses(numberOfHouses + 1);
	}
    public void increaseNumberOfHotels() {
    	this.setNumberOfHotels(numberOfHotels + 1);
	}
    public int getNumberOfHouses() {
		return numberOfHouses;
	}

	public void setNumberOfHouses(int numberOfHouses) {
		this.numberOfHouses = numberOfHouses;
	}

	public int getNumberOfHotels() {
		return numberOfHotels;
	}

	public void setNumberOfHotels(int numberOfHotels) {
		this.numberOfHotels = numberOfHotels;
	}

	public int getNumberOfSkyscrapers() {
		return numberOfSkyscrapers;
	}

	public void setNumberOfSkyscrapers(int numberOfSkyscrapers) {
		this.numberOfSkyscrapers = numberOfSkyscrapers;
	}

	@Override
	public double calculateRent() {
		// TODO Auto-generated method stub
		if(this.numberOfHouses == 0) {
			return this.zeroRent;
		}else {
			return this.titled_rent.get((numberOfHouses + numberOfHotels + numberOfSkyscrapers) - 1);
		}
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Double> getRent() {
		return titled_rent;
	}

	public void setRent(ArrayList<Double> rent) {
		this.titled_rent = rent;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isTwoColorDeed() {
		return twoColorDeed;
	}

	public void setTwoColorDeed(boolean twoColorDeed) {
		this.twoColorDeed = twoColorDeed;
	}

	public boolean isThreeColorDeed() {
		return threeColorDeed;
	}

	public void setThreeColorDeed(boolean threeColorDeed) {
		this.threeColorDeed = threeColorDeed;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @param oneHouse
	 * @param twoHouse
	 * @param threeHouse
	 * @param fourHouse
	 * @param hotel
	 * @param skyScraper
	 * @effects receives a tax list of 6 integers and creates the rent prices for title deeds.
	 * @modifies this.rent
	 */
	public void addTaxList (double oneHouse, double twoHouse, double threeHouse, double fourHouse, double hotel, double skyScraper) {
		this.titled_rent.add(oneHouse);
		this.titled_rent.add(twoHouse);
		this.titled_rent.add(threeHouse);
		this.titled_rent.add(fourHouse);
		this.titled_rent.add(hotel);
		this.titled_rent.add(skyScraper);
		
			
	}

	@Override
	public boolean getMortgageStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMortgageStatus(boolean mortgageStatus) {
		// TODO Auto-generated method stub
		
	}


}
