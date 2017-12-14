package domain.squares.actionsquares;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.Player;

public class BirthdayGift extends ActionSquare{

	public BirthdayGift(int index) {
        super(index);
    }

	@Override
	public void landedOn(Player p) {
		// Pops up a dialog asking whether the game should give 100$ to player
		//or take him/her to nearest cab station.
		
		JFrame dialogFrame= new JFrame();  
        JDialog dialog = new JDialog(dialogFrame , "Choose", true);  
       dialog.setLayout( new FlowLayout() );  
       JLabel questionLabel=new JLabel("What do you want to do?");
        JButton takeMoney = new JButton ("Take 100$");  
        JButton  cab= new JButton ("Go to the nearest cab company"); 
        
        dialog.add(questionLabel);
        dialog.add(takeMoney);
        dialog.add(cab);
        
       takeMoney.addActionListener ( new ActionListener()  
        {  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				p.setBalance(p.getBalance()+100);
				dialog.setVisible(false);
			}  
        });  
       cab.addActionListener ( new ActionListener()  
       {  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				p.setPosition(46);
				dialog.setVisible(false);
			}  
       }); 
        
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
