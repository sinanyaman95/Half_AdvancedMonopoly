package domain.squares;

public abstract class Square {

	//public ActionBehavior actionBehavior;
	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected BuyableBehavior buyable;

	public BuyableBehavior getBuyable() {
		return buyable;
	}

	public void setBuyable(BuyableBehavior buyable) {
		this.buyable = buyable;
	}
}
