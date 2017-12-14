package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class GoToJail extends ChanceCard {

	public GoToJail(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {

		p.setPosition(10);
		p.setInJail(true);
		
	}
	@Override
    public String toString() {
        return  "Go to Jail";
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
