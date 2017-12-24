package domain.bot;

import domain.MonopolyGameController;

public class BankruptObserver extends MonopolyBotObserver {

	public BankruptObserver() {
		
	}

	@Override
	public void update() {
		MonopolyGameController.gamebot.setEmotion("Afraid");

	}

	@Override
	public void setEmotion(String emo) {
		this.emotion=emo;
		
	}


}
