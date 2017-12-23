package domain.squares.actionsquares;

import domain.Player;

public class BonusSquare extends ActionSquare {

	public BonusSquare(int index) {
		super(index);
		this.name = "Bonus Square";
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

	public static boolean repOK() {
		ActionSquare test =new BonusSquare(0);
		Player player = new Player("TestPlayer",100);
		double beforeBalance=player.getBalance();
		test.landedOn(player);
		double afterBalance=player.getBalance();
		if(beforeBalance+300==afterBalance) {
			return true;
		}else {
			return false;
		}
		
	}

}
