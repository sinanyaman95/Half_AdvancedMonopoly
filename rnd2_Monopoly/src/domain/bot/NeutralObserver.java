package domain.bot;

import domain.MonopolyGameController;


public class NeutralObserver extends MonopolyBotObserver {


	

	public NeutralObserver() {
		  
	}
	@Override
	public  void update() {

		
		MonopolyGameController.gamebot.setEmotion("Neutral");
	
	}

	@Override
	public void setEmotion(String emo) {
		this.emotion=emo;
		
	}

}
