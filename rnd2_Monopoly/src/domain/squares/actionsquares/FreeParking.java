package domain.squares.actionsquares;

import domain.Player;

public class FreeParking extends ActionSquare {

	public FreeParking(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		p.setBalance(p.getBalance()+100);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
