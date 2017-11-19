package domain;

public class TitleDeed extends PropertySquare {
	public String name;
	public int price;
	public int rent;
	public int mortgageValue;
	public Player owner;
	public String color;
	
	public boolean twoColorDeed;
	public boolean threeColorDeed;
	public int numberOfHouses;
	public int numberOfHotels;
	public int numberOfSkyscrapers;

	
	public TitleDeed(String tname,int priceVal,int rentVal,int mortgageVal,String clr) {
		//update
		super();
		name=tname;
		owner=MonopolyGameController.bank;
		price=priceVal;
		rent=rentVal;
		mortgageValue=mortgageVal;
		color=clr;
		
		
		
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

	@Override
	public Player getOwner() {
	
		return this.owner;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner=owner;
		
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
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



}
