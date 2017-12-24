package domain.squares.actionsquares;

import java.util.ArrayList;
import java.util.Random;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.CommunityChestCard;

public class CommunityChest extends ActionSquare {

	private CommunityChestCard pickedCard;
	
	public CommunityChest(int index, ArrayList<CommunityChestCard> communityDeck) {
		super(index);
		this.name = "Community Chest";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {

	pickedCard.doCardAction(p);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pickedCard.toString();
	}
	
	public void pickCard() {
		Random rnd=new Random();
		int  n = rnd.nextInt(4);
		
	pickedCard=	MonopolyGameController.communityDeck.get(n);
	}

}
