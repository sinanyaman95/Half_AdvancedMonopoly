package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class ChangingLanesA extends ChanceCard {
	
	//2222222222222222222222222222222222

	public ChangingLanesA(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		// TODO Auto-generated method stub
		if(p.getPosition()==50) {
			p.setPosition(8);
			}

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
