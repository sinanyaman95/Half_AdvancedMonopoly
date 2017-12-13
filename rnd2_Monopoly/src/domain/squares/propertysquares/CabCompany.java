package domain.squares.propertysquares;

import domain.MonopolyGameController;
import domain.Player;

public class CabCompany extends Transportation {

	public CabCompany(int i, String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performPurchase(Player p, PropertySquare s) {
		// if the owner of the title deed is the bank
		// (no one owns the title deed), assign the new owner and update balance
		if (s.getOwner().getName().equals("Bank") && p.getBalance() >= s.getPrice()) {
			MonopolyGameController.bank.getOwnedTransportation().remove(s);
			s.setOwner(p);
			p.getOwnedTransportation().add((Transportation)s);
			p.setBalance(p.getBalance() - s.getPrice());

		}
		
	}

	@Override
	public void calculateRent() {
		// TODO Auto-generated method stub
		
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

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
		
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
