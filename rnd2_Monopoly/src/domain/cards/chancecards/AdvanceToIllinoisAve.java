package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;

public class AdvanceToIllinoisAve extends ChanceCard {

	public AdvanceToIllinoisAve(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		/*if(p.getPosition()==7||p.getPosition()==22||p.getPosition()==94) {
		p.setPosition(24);
		
	}else if(p.getPosition()==36||p.getPosition()==70||p.getPosition()==50||p.getPosition()==61||p.getPosition()==112) {
		p.setPosition(24);
		p.setBalance(p.getBalance()+200);
	}
	
	Adds 200 if player passes go square
		
	*/	
	
	p.setPosition(24);
		
	}
	@Override
    public String toString() {
        return  "Advance to Illinois Ave";
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
