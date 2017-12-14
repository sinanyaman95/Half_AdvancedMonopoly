package domain.cards.travelvouchercards;

import domain.Player;
import domain.cards.TravelVoucherCard;

public class FreeCabFareBack extends TravelVoucherCard {

	@Override
	public void doCardAction(Player p) {
		//will change it to move later
		p.setPosition(p.getPosition()-3);
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
