package domain.squares.actionsquares;

import domain.squares.ActionBehavior;
import domain.squares.Square;
import domain.squares.notBuy;

public abstract class ActionSquare extends Square implements ActionBehavior{
	public abstract String toString();
	public ActionSquare(int index) {
		super();
		this.buyable = new notBuy();
	}

	


}
