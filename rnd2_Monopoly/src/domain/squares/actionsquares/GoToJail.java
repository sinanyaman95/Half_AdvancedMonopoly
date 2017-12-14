package domain.squares.actionsquares;

import domain.Player;

public class GoToJail extends ActionSquare {

	public GoToJail(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		//sends the player to jail
		p.setPosition(10);
		p.setInJail(true);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
