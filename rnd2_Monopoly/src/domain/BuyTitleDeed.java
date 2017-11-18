package domain;

public class BuyTitleDeed implements BuyableBehavior {

	@Override
	public void buy(Player p, Square s) {

		// if the owner of the title deed is the bank
		// (no one owns the title deed), assign the new owner and update balance
		if (s.getOwner().getName().equals("Bank") && p.getBalance() >= s.getPrice()) {
			MonopolyGameController.bank.getOwnedProperties().remove(s);
			s.setOwner(p);
			p.getOwnedProperties().add(s);
			p.setBalance(p.getBalance() - s.getPrice());

		}

	}

}
