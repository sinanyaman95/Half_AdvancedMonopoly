package domain.squares.propertysquares;

import domain.Player;
import domain.squares.Square;
import domain.squares.canBuy;

public abstract class PropertySquare extends Square {
	public String color;
	public int price;
	public int rent;
	public int mortgageValue;
	public Player owner;
	public boolean mortgageStatus;
	
	
	public abstract boolean getMortgageStatus();
	
	public abstract void setMortgageStatus(boolean mortgageStatus);
	
	/**
	 * @param p: current player
	 * @param s: square the player wants to purchase
	 * @requires buy button must be pressed
	 * @modifies changes the properties owner
	 * @effects player's owned properties list is updated 
	 */
	public abstract void performPurchase(Player p, PropertySquare s);

	public abstract Player getOwner();

	/**
	 * @requires pay rent must be called beforehand
	 * @effects calculates rent for the given property
	 * @return
	 */
	public abstract double calculateRent();

	public abstract void setOwner(Player owner);

	public abstract int getPrice();
	
	public PropertySquare() {
		super();
		buyable = new canBuy();
	}

}
