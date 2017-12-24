package domain.cards;

import domain.MonopolyGameController;

public abstract class ChanceCard implements Card {
	
	private boolean playImmediately;

	
	public ChanceCard(boolean playImmediately) {
		this.playImmediately=playImmediately;
		MonopolyGameController.chanceCardDeck.add(this);
		
	}
	public boolean isPlayImmediately() {
		return playImmediately;
	}
	
	
}
