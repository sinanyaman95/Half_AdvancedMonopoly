package domain.squares.propertysquares;

import domain.Player;
import domain.squares.Square;
import domain.squares.canBuy;

public abstract class PropertySquare extends Square {
	public String name;
	public String color;
	public int price;
	public int rent;
	public int mortgageValue;
	public Player owner;
	public boolean mortgageStatus;
	
	
	public abstract boolean getMortgageStatus();
	
	public abstract void setMortgageStatus(boolean mortgageStatus);
	
	public abstract void performPurchase(Player p, PropertySquare s);

	public abstract Player getOwner();

	public abstract void calculateRent();

	public abstract void setOwner(Player owner);

	public abstract int getPrice();
	
	public PropertySquare() {
		super();
		buyable = new canBuy();
	}

}
