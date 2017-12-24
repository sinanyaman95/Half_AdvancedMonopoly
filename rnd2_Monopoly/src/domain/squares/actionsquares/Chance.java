package domain.squares.actionsquares;

import java.util.ArrayList;
import java.util.Random;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.ChanceCard;
import gui.TakeCard_PopUp_Window;

public class Chance extends ActionSquare {

	private ChanceCard pickedCard;
	public Chance(int index, ArrayList<ChanceCard> chanceCardDeck) {
		super(index);
		this.name = "Chance";
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
	
		int randomCardIndex =rnd.nextInt(5);

		pickedCard = MonopolyGameController.chanceCardDeck.get(randomCardIndex);
	}

}
