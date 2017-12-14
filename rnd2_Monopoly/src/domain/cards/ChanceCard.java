package domain.cards;

public abstract class ChanceCard implements Card {
	
	private boolean playImmediately;

	
	public ChanceCard(boolean playImmediately) {
		this.playImmediately=playImmediately;
		
	}
	public boolean isPlayImmediately() {
		return playImmediately;
	}
	
	
}
