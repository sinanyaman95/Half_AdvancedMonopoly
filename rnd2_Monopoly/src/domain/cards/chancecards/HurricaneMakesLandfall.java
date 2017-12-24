package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class HurricaneMakesLandfall extends ChanceCard {

	public HurricaneMakesLandfall(boolean playImmediately) {
		super(playImmediately);
		// TODO Auto-generated constructor stub
	}

	public void doCardAction(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCardDescription(String desc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCardType(String type) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public String toString() {
		return "Remove 1 House from each\r\n" + "property in any player’s 1 color\r\n" + "group. (Downgrade Skyscrapers to\r\n" + 
				"Hotels; Hotels to 4 houses.";
		
	}

}
