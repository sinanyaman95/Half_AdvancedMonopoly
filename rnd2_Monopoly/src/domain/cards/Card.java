package domain.cards;

import domain.Player;

public interface Card {
	
	
	
	public void doCardAction(Player p);
    public String toString();

    public void setCardDescription(String desc);
	public void setCardType(String type);
}
