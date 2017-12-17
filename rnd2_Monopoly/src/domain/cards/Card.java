package domain.cards;

import domain.Player;

public interface Card {
	
	
	/**
	 * @effects applies the specific action of the card
	 * @param p
	 */
	public void doCardAction(Player p);
    public String toString();

    public void setCardDescription(String desc);
	public void setCardType(String type);
}
