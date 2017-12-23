package domain.cards.chancecards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.ChanceCard;
import domain.cards.TravelVoucherCard;

public class BusinessTrip extends ChanceCard {

	public BusinessTrip(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		
		TravelVoucherCard travelCard= MonopolyGameController.drawTravelCard();
		p.cardInventory.add(travelCard);
		//p.addCardInventory Travel Voucher!!!!!!!!!!!!!!!!!!!

	}
	public String toString() {
		return "Business Trip";
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
