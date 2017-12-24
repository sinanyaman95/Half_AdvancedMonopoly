package domain.cards.communitychestcards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.CommunityChestCard;

public class YouAreGettingMarried extends CommunityChestCard {

	public YouAreGettingMarried(boolean playImmediately) {
		super(playImmediately);
		// TODO Auto-generated constructor stub
	}

	public void doCardAction(Player p) {

		for (int i = 0; i < MonopolyGameController.players.size(); i++) {
			Player temp = MonopolyGameController.players.get(i);
			temp.setBalance(temp.getBalance() - 25);
		}

		p.setBalance(p.getBalance() + (25*MonopolyGameController.players.size()));

	}

	@Override
	public String toString() {
		return "Collect $25 from each player as\r\n" + "a wedding gift.";
		
	}

	@Override
	public void setCardType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCardDescription(String desc) {
		// TODO Auto-generated method stub
		
	}

}
