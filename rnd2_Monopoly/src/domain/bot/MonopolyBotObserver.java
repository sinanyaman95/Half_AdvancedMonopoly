package domain.bot;


import domain.MonopolyGameController;
import domain.Player;


public abstract class MonopolyBotObserver {

	public String emotion;
	public MonopolyGameController gameSubject;
	public Player playerSubject;
	
	public abstract void update();
	
}
