package domain.bot;

import domain.Player;
import gui.MonopolyBoard;

public class JailObserver extends MonopolyBotObserver {
	
	public JailObserver(Player subject) {
		  this.playerSubject = subject;
	      this.playerSubject.attachObserver(this);
	}



	@Override
	public void update() {
		// show sad emotion
		System.out.println("Sad");//test

	}


	
	

}
