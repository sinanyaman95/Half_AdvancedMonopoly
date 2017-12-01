package domain.squares;

import domain.MonopolyGameController;
import domain.Player;

public class CabCompany extends Transportation {

	public CabCompany(String name) {
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
}
