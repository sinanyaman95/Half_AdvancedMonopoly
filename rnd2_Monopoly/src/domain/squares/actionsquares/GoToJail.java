package domain.squares.actionsquares;

import domain.Player;

public class GoToJail extends ActionSquare {

	public GoToJail(int index) {
		super(index);
		this.name = "GO TO JAIL";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		//sends the player to jail
		p.setPosition(10);
		p.setInJail(true);
		p.notifyObservers();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean repOK() {
		//makes sure landedOn works
		ActionSquare testSquare=new GoToJail(0);
		Player player=new Player("TestPlayer",100);
		int beforePosition=player.getPosition();
		testSquare.landedOn(player);
		int afterPosition=player.getPosition();
		if(player.isInJail()&&player.getPosition()==10&&beforePosition!=afterPosition) {
			return true;
		}else {
			return false;	
		}
		
	}

}
