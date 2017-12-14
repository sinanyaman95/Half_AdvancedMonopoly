package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class TrafficTicket extends ChanceCard {

	public TrafficTicket(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		
		p.setBalance(p.getBalance()-15);
		
		//ADD THAT MONEY TO POOL

		
	}

	@Override
	public String toString() {
		return "Traffic Ticket ";
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
