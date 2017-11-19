package domain;

public abstract class PropertySquare implements Square {
	public String name;
	public String color;

	public abstract void performPurchase(Player p, PropertySquare s);

	public abstract Player getOwner();

	public abstract void calculateRent();

	public abstract void setOwner(Player owner);

	public abstract double getPrice();

}
