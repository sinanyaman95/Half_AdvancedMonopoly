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
	
	
	/**
	 * @return mortgageStatus - if a property square is mortgaged or not
	 */
	public abstract boolean getMortgageStatus();
	
	public abstract void setMortgageStatus(boolean mortgageStatus);

	public abstract Player getOwner();

	/**
	 * @effect calculates the rent to be paid depending on the buildings a property square has
	 * @requires a property square has at least 1 house
	 */
	public abstract void calculateRent();

	public abstract void setOwner(Player owner);

	public abstract int getPrice();
	
	public PropertySquare() {
		super();
		buyable = new canBuy();
	}

	/**
	 * @param p -Player
	 * @param s -TitleDeed
	 * @modifies player balance 
	 * @effect TitleDeed s is added to player's inventory and s's owner is set to be the player. Player's balance is decreased by the price of s.
	 */
	public abstract void performPurchase(Player p, TitleDeed s);

}
