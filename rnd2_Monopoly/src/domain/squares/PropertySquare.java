package domain.squares;

import domain.Player;

public abstract class PropertySquare extends Square {
	public String name;
	public String color;
	public int price;
	public int rent;
	public int mortgageValue;
	public Player owner;
	public boolean mortgageStatus;
	
	public abstract void performPurchase(Player p, PropertySquare s);

	public abstract Player getOwner();

	public abstract void calculateRent();

	public abstract void setOwner(Player owner);

	public abstract int getPrice();

}
