package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToTheNearestRailroad extends ChanceCard {

	public AdvanceToTheNearestRailroad(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {

	//moveTo nearest railroad	
		/*
		 int ct=p.getPosition();
		  while(! ct= cabposition){
		  
		  ct++;
		 
		  }
		  player.setpos(ct);
		  
		  
		 
		 */
		
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
