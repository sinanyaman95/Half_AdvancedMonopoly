package domain.squares.actionsquares;

import domain.Player;

public class BonusSquare extends ActionSquare {

	public BonusSquare(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
	p.setBalance(p.getBalance()+300);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
