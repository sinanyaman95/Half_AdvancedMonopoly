package domain.squares.propertysquares;

import domain.Player;

public class Utility extends PropertySquare {



	public Utility(int i, String string) {
		// TODO Auto-generated constructor stub
		super();
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

	@Override
	public void performPurchase(Player p, PropertySquare s) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateRent() {
		return rent;
		// TODO Auto-generated method stub
	}

	@Override
	public void setOwner(Player owner) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
