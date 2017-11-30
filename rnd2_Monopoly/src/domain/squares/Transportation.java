package domain.squares;

import domain.MonopolyGameController;
import domain.Player;

public class Transportation extends PropertySquare {
	
	
	public Transportation(String name) {
		super();
		this.name = name;
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
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void calculateRent() {
		// TODO Auto-generated method stub
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
