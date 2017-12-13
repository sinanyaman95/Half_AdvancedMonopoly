package domain.squares.propertysquares;

import java.util.ArrayList;

import domain.MonopolyGameController;
import domain.Player;
import domain.squares.BuyableBehavior;
import domain.squares.canBuy;
import domain.squares.notBuy;

public class TitleDeed extends PropertySquare {
	

	public String color;
	public int index;
	public int zeroRent;
	public ArrayList<Integer> rent;
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
		this.name=name;
		this.color=color;
		this.price=price;
		this.zeroRent=zeroRent;
		this.mortgageValue=mortgageVal;
		this.numberOfHouses = numberOfHouses;
		this.numberOfHotels = numberOfHotels;
		this.numberOfSkyscrapers = numberOfSkyscrapers;
		this.rent = new ArrayList<Integer>();
		this.mortgageStatus=false;
		
		//We'll discuss this part, it might cause bugs.
		// Do we need buyable field since it is property square for sure??
		if(owner==MonopolyGameController.bank) {
			buyable = new notBuy();
		}else {
			buyable = new canBuy();
		}
		
		
	}

	@Override
	public void performPurchase(Player p,PropertySquare s) {
		

			// if the owner of the title deed is the bank
			// (no one owns the title deed), assign the new owner and update balance
			if (s.getOwner().getName().equals("Bank") && p.getBalance() >= s.getPrice()) {
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

	public boolean BuildHouse(Player p) {
		TitleDeed property = null;
		for(TitleDeed s: p.getOwnedTitleDeeds()) {
			if(s.name.equals(this.name)) {
				property = s;
			}else {
				return false;
			}
		}
		if(isMajorityOwner(property)) {
			(property).increaseNumberOfHouses();	
			return true;
		}
		return false;
	}

	public boolean BuildHotel(Player p) {
		TitleDeed property = null;
		for(TitleDeed s: p.getOwnedTitleDeeds()) {
			if(s.name.equals(this.name)) {
				property = s;
			}else {
				return false;
			}
		}
		if(isMajorityOwner(property)) {
			(property).increaseNumberOfHotels();	
			return true;
		}
		return false;
	}

	public boolean BuildSkyscraper(Player p) {
		TitleDeed property = null;
		for(TitleDeed s: p.getOwnedTitleDeeds()) {
			if(s.name.equals(this.name)) {
				property = s;
			}else {
				return false;
			}
		}
		if(isMonopoly(property,p)) {
			(property).setNumberOfSkyscrapers(1);
			return true;
		}
		return false;

	}

	public boolean isMajorityOwner(PropertySquare property){
		return false;

	}
	public boolean isMonopoly(TitleDeed property,Player p){
		int color_count = 1; 
		boolean hasHotel = false;
		for(TitleDeed s: p.getOwnedTitleDeeds()) {
			if(s.color.equals(property.color)) {
				color_count ++;
				if((s).getNumberOfHotels() != 0) {
					hasHotel = true;
				}else {
					hasHotel = false;
				}
			}
		}
		if(hasHotel) {
			if(color_count == 3 && property.threeColorDeed) {
				return true;
			}else if(color_count == 2 && property.twoColorDeed) {
				return true;
			}
		}
		return false;
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
	public void calculateRent() {
		// TODO Auto-generated method stub
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getRent() {
		return rent;
	}

	public void setRent(ArrayList<Integer> rent) {
		this.rent = rent;
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

	
	public void addTaxList (int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel, int skyScraper) {
		this.rent.add(oneHouse);
		this.rent.add(twoHouse);
		this.rent.add(threeHouse);
		this.rent.add(fourHouse);
		this.rent.add(hotel);
		this.rent.add(skyScraper);
		
			
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
