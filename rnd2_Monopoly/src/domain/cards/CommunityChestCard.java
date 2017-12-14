package domain.cards;

public abstract class CommunityChestCard implements Card {
	
	private boolean playImmediately;
	
	
	public CommunityChestCard(boolean playImmediately) {
		this.playImmediately=playImmediately;
		
	}
	
	public boolean isPlayImmediately() {
		return playImmediately;
	}

}
