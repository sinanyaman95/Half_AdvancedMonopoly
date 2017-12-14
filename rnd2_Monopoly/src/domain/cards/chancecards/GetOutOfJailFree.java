package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class GetOutOfJailFree extends ChanceCard {

	public GetOutOfJailFree(boolean playImmediately) {
		super(false);		
	}

	public void doCardAction(Player p) {
	
		//add get out of jail card to the players inventory
		// p.addToCardInventory(GetOutOfJail);

	}
	@Override
    public String toString() {
        return  "Get out of Jail Free";
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
