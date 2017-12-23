package domain.squares.actionsquares;

import java.util.ArrayList;
import java.util.Random;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.CommunityChestCard;

public class CommunityChest extends ActionSquare {

	public CommunityChest(int index, ArrayList<CommunityChestCard> communityDeck) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		Random rnd=new Random();
		int  n = rnd.nextInt(2);
		
	domain.cards.CommunityChestCard pickedCard=	MonopolyGameController.communityDeck.get(n);
	
	pickedCard.doCardAction(p);
		

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Community Chest Square";
	}

}
