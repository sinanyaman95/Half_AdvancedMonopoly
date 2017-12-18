package domain.bot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domain.MonopolyGameController;

public class IdleObserver extends MonopolyBotObserver {
	
public IdleObserver(MonopolyGameController subject) {
	  this.gameSubject = subject;
      this.gameSubject.attachObserver(this);
      
  
   
 
      
}

	@Override
	public void update() {
		//show bored emotion
		System.out.println("Bored");//test
	    
	  
	}



}
