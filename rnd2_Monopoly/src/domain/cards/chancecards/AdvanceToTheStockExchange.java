package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToTheStockExchange extends ChanceCard {

	public AdvanceToTheStockExchange(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		
		
		
		p.setPosition(108);

		
		
		
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
