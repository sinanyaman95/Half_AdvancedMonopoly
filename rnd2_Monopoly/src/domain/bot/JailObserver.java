package domain.bot;

import domain.MonopolyGameController;
import domain.Player;
import gui.MonopolyBoard;

public class JailObserver extends MonopolyBotObserver {
	
	public JailObserver(Player subject) {
		  this.playerSubject = subject;
	      this.playerSubject.attachObserver(this);
	}
	
	public JailObserver() {
		 
	}



	@Override
	public void update() {
		// show sad emotion
		MonopolyGameController.gamebot.setEmotion("Sad");
		//System.out.println(emotion);//test

	}



	@Override
	public void setEmotion(String emo) {
		this.emotion=emo;
		
	}


	
	

}
