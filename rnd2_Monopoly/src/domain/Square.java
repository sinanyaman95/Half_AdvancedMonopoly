package domain;

public class Square {
	protected BuyableBehavior buyBehavior;
	protected ActionBehavior actionBehavior;
	
	private String name;
	protected int price;
	protected int rent;
	protected int mortgageValue;

	protected Player owner;

	public Square(String name) {
		this.name = name;
	}

	public void performPurchase(Player p) {
		//calls the square's buy method depending on its BuyableBehavior
		buyBehavior.buy(p, this);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public double getPrice() {
		return this.price;
	}

	
	
}
