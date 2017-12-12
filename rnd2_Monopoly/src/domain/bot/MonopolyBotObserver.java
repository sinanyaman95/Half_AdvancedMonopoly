package domain.bot;

import domain.MonopolyGameController;
import domain.Player;

public abstract class MonopolyBotObserver {

	public Player playerSubject;
	public MonopolyGameController gameSubject;
	
	public abstract void evaluateGame();
	public abstract void update();
}
