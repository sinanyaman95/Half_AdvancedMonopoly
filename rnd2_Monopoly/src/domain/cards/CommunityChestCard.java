package domain.cards;

import domain.MonopolyGameController;

public abstract class CommunityChestCard implements Card {
	
	private boolean playImmediately;
	
	
	public CommunityChestCard(boolean playImmediately) {
		this.playImmediately=playImmediately;
		MonopolyGameController.communityDeck.add(this);
		
	}
	
	public boolean isPlayImmediately() {
		return playImmediately;
	}

}
