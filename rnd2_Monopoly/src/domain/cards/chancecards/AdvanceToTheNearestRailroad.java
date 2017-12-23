package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToTheNearestRailroad extends ChanceCard {

	public AdvanceToTheNearestRailroad(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {

		if(p.getPosition()==7) {
			p.setPosition(15);
			
		}else if(p.getPosition()==22||p.getPosition()==50||p.getPosition()==61||p.getPosition()==70) {
			p.setPosition(75);
		
		}else if(p.getPosition()==36||p.getPosition()==94) {
			p.setPosition(47);
		
		}else if(p.getPosition()==112) {
			p.setPosition(35);
		
		}
		
		
	}
	  @Override
	    public String toString() {
	        return "Advance to the nearest Railroad";
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
