package domain.squares.actionsquares;

import domain.Player;

public class PayDay extends ActionSquare {

	public PayDay(int index) {
		super(index);
		this.name = "Pay Day";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		// you get money as you pass, nothing to do here

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
