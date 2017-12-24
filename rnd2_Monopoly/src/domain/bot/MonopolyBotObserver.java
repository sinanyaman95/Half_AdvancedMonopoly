package domain.bot;


import domain.MonopolyGameController;
import domain.Player;


public abstract class MonopolyBotObserver {

	public String emotion="Neutral";
	public Player playerSubject;
	
	public abstract void update();
	public abstract void setEmotion(String emo);
	
}
