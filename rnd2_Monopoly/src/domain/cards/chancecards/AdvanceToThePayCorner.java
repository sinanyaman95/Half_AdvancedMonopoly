package domain.cards.chancecards;

import domain.Player;
import domain.cards.Card;
import domain.cards.ChanceCard;

public class AdvanceToThePayCorner extends ChanceCard{



	public AdvanceToThePayCorner(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		
		if(p.getPosition() <41) {
			p.setPosition(0);
			p.setBalance(p.getBalance()+200);	
			
		}else if((p.getPosition()<81) && (40<p.getPosition())) {
			p.setPosition(68);
			p.setBalance(p.getBalance()+400);	
			
		}else {
			p.setPosition(102);
			p.setBalance(p.getBalance()+300);						
		}		
	}
	@Override
    public String toString() {
        return  "Advance to the Pay Corner";
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
