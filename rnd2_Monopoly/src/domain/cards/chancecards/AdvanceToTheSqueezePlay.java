package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToTheSqueezePlay extends ChanceCard {

	public AdvanceToTheSqueezePlay(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {

		p.setPosition(96);
		
		
		//will change to move function
	}
	public String toString() {
		return "Advance To The Squeeze Play";
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
