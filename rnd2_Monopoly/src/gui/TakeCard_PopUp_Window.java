package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import domain.MonopolyGameController;
import domain.cards.ChanceCard;
import domain.cards.CommunityChestCard;
import domain.squares.Square;
import domain.squares.actionsquares.Chance;
import domain.squares.actionsquares.CommunityChest;

public class TakeCard_PopUp_Window extends JDialog{

	private JLabel lblCard_Type_label;
	private JTextArea txtArea_CardDesc;
	private String cardDesc;
	private String cardType;
	private Square cardSquare;
	
	public TakeCard_PopUp_Window() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(75, 201, 270, 23);
			getContentPane().add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(cardType == "Chance") {
						//findChanceCardbyDesc().doCardAction(MonopolyGameController.getCurrentPlayer());
						Chance temp = (Chance) cardSquare;
						temp.landedOn(MonopolyGameController.getCurrentPlayer());
						setVisible(false);
					}else if(cardType == "Community") {
						//findCommunityCardbyDesc().doCardAction(MonopolyGameController.getCurrentPlayer());
						CommunityChest temp = (CommunityChest) cardSquare;
						temp.landedOn(MonopolyGameController.getCurrentPlayer());
						setVisible(false);
					}
				}
			});
		}
		
		JLabel lblCard_Type_Header = new JLabel(" Card Taken !!");
		lblCard_Type_Header.setHorizontalAlignment(SwingConstants.LEFT);
		lblCard_Type_Header.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCard_Type_Header.setBounds(194, 22, 151, 23);
		getContentPane().add(lblCard_Type_Header);
		
		lblCard_Type_label = new JLabel("====");
		lblCard_Type_label.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCard_Type_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCard_Type_label.setBounds(55, 22, 140, 23);
		getContentPane().add(lblCard_Type_label);
		
		JLabel lblCardDescription = new JLabel("Card Description :");
		lblCardDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCardDescription.setBounds(75, 70, 122, 23);
		getContentPane().add(lblCardDescription);
		
		txtArea_CardDesc = new JTextArea();
		txtArea_CardDesc.setLineWrap(true);
		txtArea_CardDesc.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtArea_CardDesc.setBounds(207, 75, 201, 100);
		getContentPane().add(txtArea_CardDesc);
		
		
	}
	
	public void setCardType(String type) {
		lblCard_Type_label.setText(type);
		cardType = type;
	}
	public void setCardDescription(String desc) {
		txtArea_CardDesc.setText(desc);
		cardDesc = desc;
	}
	public ChanceCard findChanceCardbyDesc() {
		for(ChanceCard c: MonopolyGameController.chanceCardDeck) {
			if(c.toString() == cardDesc) {
				return c;
			}
		}
		return null;
	}
	public CommunityChestCard findCommunityCardbyDesc() {
		for(CommunityChestCard c: MonopolyGameController.communityDeck) {
			if(c.toString() == cardDesc) {
				return c;
			}
		}
		return null;
	}
	public void setSquare(Square c) {
		cardSquare = c;
	}
}
