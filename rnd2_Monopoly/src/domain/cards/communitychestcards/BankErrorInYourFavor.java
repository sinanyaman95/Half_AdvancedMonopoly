package domain.cards.communitychestcards;

import domain.Player;
import domain.cards.CommunityChestCard;

public class BankErrorInYourFavor extends CommunityChestCard {

	public BankErrorInYourFavor(boolean playImmediately) {
		super(playImmediately);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCardAction(Player p) {
		p.setBalance(p.getBalance()+200);
		
	}

	@Override
	public void setCardDescription(String desc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCardType(String type) {
		// TODO Auto-generated method stub
		
	}

}
