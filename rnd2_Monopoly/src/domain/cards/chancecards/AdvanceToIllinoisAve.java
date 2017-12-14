package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToIllinoisAve extends ChanceCard {

	public AdvanceToIllinoisAve(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {

		p.setPosition(24);
		
	//	if(p.getPosition() move olmas� laz�m
		
	}
	@Override
    public String toString() {
        return  "Advance to Illinois Ave";
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
