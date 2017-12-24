package domain.bot;

import domain.MonopolyGameController;

public class PayObserver extends MonopolyBotObserver {
	
	public PayObserver() {
		 
	}

	@Override
	public void update() {
		MonopolyGameController.gamebot.setEmotion("Amused");
		
	}

	@Override
	public void setEmotion(String emo) {
		this.emotion=emo;
		
	}


	


}
