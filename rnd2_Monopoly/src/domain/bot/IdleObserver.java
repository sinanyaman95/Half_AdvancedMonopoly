package domain.bot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domain.MonopolyGameController;

public class IdleObserver extends MonopolyBotObserver {
	


	public IdleObserver() {
	// TODO Auto-generated constructor stub
}

	@Override
	public void update() {
		//show bored emotion
		MonopolyGameController.gamebot.setEmotion("Bored");
		//System.out.println(emotion);//test
	    
	  
	}

	@Override
	public void setEmotion(String emo) {
		this.emotion=emo;
		
	}



}
