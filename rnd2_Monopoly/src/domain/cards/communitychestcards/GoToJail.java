package domain.cards.communitychestcards;

import domain.Player;
import domain.cards.CommunityChestCard;

public class GoToJail extends CommunityChestCard {

	public GoToJail(boolean playImmediately) {
		super(playImmediately);
		// TODO Auto-generated constructor stub
	}

	public void doCardAction(Player p) {
		p.setInJail(true);
		p.setPosition(10);

	}

	@Override
	public void setCardDescription(String desc) {
		desc= "Go directly to Jail. Do not pass any Pay\r\n" + 
				"Corner. Do not collect any money.";
		
	}

	@Override
	public void setCardType(String type) {
		// TODO Auto-generated method stub
		
	}

}
