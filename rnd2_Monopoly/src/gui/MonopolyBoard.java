package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import domain.*;
import domain.squares.Square;
import domain.squares.actionsquares.Chance;
import domain.squares.actionsquares.CommunityChest;
import domain.squares.propertysquares.PropertySquare;
import domain.squares.propertysquares.TitleDeed;
import domain.squares.propertysquares.Transportation;
import domain.squares.propertysquares.Utility;;

public class MonopolyBoard extends JFrame{

	private JFrame frame;
	public JLabel monopolyBoard;
	public JPanel maingame_panel;
	public static JPanel players_panel;
	public JPanel gameplay_panel;
	public JLabel lblTurn;
	public JLabel lblTurn_label;
	public JButton btnRoll;
	public JLabel lblFaceVal1;
	public JLabel lblFaceVal1_label;
	public JLabel lblFaceVal2;
	public JLabel lblFaceVal2_label;
	public JLabel lblCurrentPosition;
	public JLabel lblCurrentPosition_label;
	public JButton btnEndTurn;
	public JPanel buy_panel;
	public JLabel lblBuyable;
	public JButton btnBuy;
	public JLabel lblNewLabel_3;
	public JButton btnSaveGame;
	public JButton btnNewGame;
	public JButton btnExit;
	public JLabel lblTotalMove_label;
	public JLabel lblBuyable_property_name;
	public JLabel lblBuyable_price_label;

	private int position = 0;
	private static Square prop;
	private static Player current;
	private boolean first_roll =true;
	private static int player_count = 1;
	private boolean rolled = false;
	private boolean isBuyed = false;
	

	private static ArrayList<PlayerGUI> player_guis;

	public MonopolyBoard() {
		player_guis = new ArrayList<PlayerGUI>();

		
		updatePlayerGui();
		initialize();
		setVisible(true);
		lblTurn_label.setText(current.getName());
		btnEndTurn.setEnabled(false);
		resetLabels();
		

	}

	private void initialize() {
		
		
		getContentPane().setBackground(new Color(64, 224, 208));
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();

		JLabel monopolyBoard = new JLabel("");
		monopolyBoard.setBounds(38, 0, 993, 1007);
		getContentPane().add(monopolyBoard);
		monopolyBoard.setIcon(
				new ImageIcon(MonopolyBoard.class.getResource("/pics/ultimate_monopoly_by_jonizaak-d5wgqgs.png")));

		maingame_panel=new JPanel();
		maingame_panel.setBounds(1036,11,682,983);
		maingame_panel.setBackground(new Color(65, 105, 225));
		maingame_panel.setLayout(null);
		getContentPane().add(maingame_panel);

		players_panel=new JPanel();
		players_panel.setBounds(25, 27, 629, 513);
		players_panel.setBackground(new Color(64, 224, 208));
		players_panel.setPreferredSize(new Dimension(450, 400));
		maingame_panel.add(players_panel);
		players_panel.setLayout(new GridLayout(3, 2, 0, 0));

		gameplay_panel = new JPanel();
		gameplay_panel.setBackground(new Color(65, 105, 225));
		gameplay_panel.setBounds(25, 551, 629, 421);
		maingame_panel.add(gameplay_panel);
		gameplay_panel.setLayout(null);

		lblTurn = new JLabel("Turn :");
		lblTurn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTurn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTurn.setForeground(new Color(255, 255, 255));
		lblTurn.setBounds(76, 60, 46, 23);
		gameplay_panel.add(lblTurn);

		lblTurn_label = new JLabel("New label");
		lblTurn_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTurn_label.setForeground(Color.WHITE);
		lblTurn_label.setBounds(132, 60, 177, 23);
		gameplay_panel.add(lblTurn_label);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRoll.setBounds(489, 51, 89, 23);
		gameplay_panel.add(btnRoll);

		lblFaceVal1 = new JLabel("Die 1 FaceValue :");
		lblFaceVal1.setForeground(Color.WHITE);
		lblFaceVal1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFaceVal1.setBounds(387, 98, 127, 14);
		gameplay_panel.add(lblFaceVal1);

		lblFaceVal1_label = new JLabel("New label");
		lblFaceVal1_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFaceVal1_label.setForeground(Color.WHITE);
		lblFaceVal1_label.setBounds(512, 98, 66, 14);
		gameplay_panel.add(lblFaceVal1_label);

		lblFaceVal2 = new JLabel("Die 2 FaceValue :");
		lblFaceVal2.setForeground(Color.WHITE);
		lblFaceVal2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFaceVal2.setBounds(387, 133, 127, 14);
		gameplay_panel.add(lblFaceVal2);

		lblFaceVal2_label = new JLabel("New label");
		lblFaceVal2_label.setForeground(Color.WHITE);
		lblFaceVal2_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFaceVal2_label.setBounds(512, 133, 66, 14);
		gameplay_panel.add(lblFaceVal2_label);

		lblCurrentPosition = new JLabel("Landed on :");
		lblCurrentPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentPosition.setForeground(Color.WHITE);
		lblCurrentPosition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPosition.setBounds(0, 98, 127, 23);
		gameplay_panel.add(lblCurrentPosition);

		lblCurrentPosition_label = new JLabel("New label");
		lblCurrentPosition_label.setForeground(Color.WHITE);
		lblCurrentPosition_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPosition_label.setBounds(132, 98, 177, 23);
		gameplay_panel.add(lblCurrentPosition_label);

		btnEndTurn = new JButton("End Turn");
		btnEndTurn.setForeground(Color.BLACK);
		btnEndTurn.setBackground(Color.WHITE);
		btnEndTurn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEndTurn.setBounds(132, 351, 382, 45);
		gameplay_panel.add(btnEndTurn);

		buy_panel = new JPanel();
		buy_panel.setBorder(new LineBorder(Color.RED, 3));
		buy_panel.setBackground(new Color(65, 105, 225));
		buy_panel.setBounds(10, 167, 241, 132);
		gameplay_panel.add(buy_panel);
		buy_panel.setLayout(null);

		lblBuyable = new JLabel("Buyable !!!");
		lblBuyable.setBackground(Color.BLACK);
		lblBuyable.setBounds(85, 11, 74, 17);
		buy_panel.add(lblBuyable);
		lblBuyable.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyable.setForeground(Color.WHITE);
		lblBuyable.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnBuy = new JButton("Buy");
		btnBuy.setBounds(85, 97, 74, 25);
		buy_panel.add(btnBuy);
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblBuyable_property_name = new JLabel("New label");
		lblBuyable_property_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyable_property_name.setForeground(Color.WHITE);
		lblBuyable_property_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuyable_property_name.setBounds(34, 39, 173, 19);
		buy_panel.add(lblBuyable_property_name);

		lblBuyable_price_label = new JLabel("New label");
		lblBuyable_price_label.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyable_price_label.setForeground(Color.WHITE);
		lblBuyable_price_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuyable_price_label.setBounds(34, 69, 173, 17);
		buy_panel.add(lblBuyable_price_label);

		JLabel lblTotalMove = new JLabel("Total Move :");
		lblTotalMove.setForeground(Color.WHITE);
		lblTotalMove.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalMove.setBounds(387, 167, 127, 14);
		gameplay_panel.add(lblTotalMove);

		lblTotalMove_label = new JLabel("0");
		lblTotalMove_label.setForeground(Color.WHITE);
		lblTotalMove_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalMove_label.setBounds(512, 167, 66, 14);
		gameplay_panel.add(lblTotalMove_label);

		btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(1744, 35, 139, 23);
		getContentPane().add(btnSaveGame);

		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(1744, 69, 139, 23);
		getContentPane().add(btnNewGame);

		btnExit = new JButton("Exit");
		btnExit.setBounds(1744, 103, 139, 23);
		getContentPane().add(btnExit);

		current =MonopolyGameController.getCurrentPlayer();
		position = current.getPosition();
		prop = MonopolyGameController.squareList[position];


		btnRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MonopolyGameController.die1.roll();
				MonopolyGameController.die2.roll();
				int die1 = Integer.parseInt(MonopolyGameController.die1.getFaceValue());
				int die2 = Integer.parseInt(MonopolyGameController.die2.getFaceValue());
				lblFaceVal1_label.setText(MonopolyGameController.die1.getFaceValue());
				lblFaceVal2_label.setText(MonopolyGameController.die2.getFaceValue());
				lblTotalMove_label.setText(""+(die1+die2));
				//current.setPosition(position+(die1+die2));
				MonopolyGameController.move((die1+die2));
				position = current.getPosition();
				prop = MonopolyGameController.squareList[position];

				lblCurrentPosition_label.setText(MonopolyGameController.squareList[position].getName());
				System.out.println(current.getName()+": "+position);
				System.out.println(MonopolyGameController.squareList[position].getClass().toString());
				first_roll=false;
				rolled = true;
				updateGui();
				MonopolyGameController.neutralObserver.update();
				MonopolyGameController.idleTimer.restart();
				btnEndTurn.setEnabled(true);
			}
		});

		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(prop.getBuyable().getBuyableType()) {

					isBuyed = true;
					if(prop.getClass() == TitleDeed.class) {
						TitleDeed temp= (TitleDeed) prop;
						if(current.getBalance()<temp.getPrice()) {
							JOptionPane.showMessageDialog(null,"Not enough balance !");
						}else {
							current.buyProperty(temp);
							findGUIbyName(current.getName()).comboBox_TitleDeeds.addItem(prop.getName());
						}
					}else if(prop.getClass() == Transportation.class) {
						Transportation trans = (Transportation) prop;
						if(current.getBalance()<trans.getPrice()) {
							JOptionPane.showMessageDialog(null,"Not enough balance !");
						}else {
							current.buyProperty(trans);
							findGUIbyName(current.getName()).comboBox_Companies.addItem(prop.getName());
						}
					}else if(prop.getClass() == Utility.class) {
						Utility util = (Utility) prop;
						if(current.getBalance()<util.getPrice()) {
							JOptionPane.showMessageDialog(null,"Not enough balance !");
						}else {
							current.buyProperty(util);
							findGUIbyName(current.getName()).comboBox_Companies.addItem(prop.getName());
						}
					}
					
					updateGui();
					updatePlayerGui();
					MonopolyGameController.neutralObserver.update();
					MonopolyGameController.idleTimer.restart();
					buy_panel.setVisible(false);
				}
			}
		});

		btnSaveGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(MonopolyGameController.SaveGame()) {
					JOptionPane.showMessageDialog(null,"Game Saved");
				}
			}
		});

		btnNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MonopolyGameController.resetTheGame();
				setVisible(false);
				new StartingScreen();
			}
		});

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		btnEndTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub
				//Auction initialization
				first_roll = true;	
				
				if(first_roll && !isBuyed) {
					if(prop.getClass() == TitleDeed.class || prop.getClass() == Transportation.class || prop.getClass() == Utility.class) {
					Auction auction_panel = new Auction(prop,current,MonopolyGameController.bidAmount);
					auction_panel.show();	
					}
				}
				//================================
				updatePlayerGui();
				current.setCheckTurn(false);
				if(player_count == MonopolyGameController.players.size()) {
					player_count=0;
				}

				player_count ++;
				
				current = MonopolyGameController.players.get(player_count-1);
				position = current.getPosition();
				prop = MonopolyGameController.squareList[position];
				
				current.setCheckTurn(true);
 
				updateGui();
				MonopolyGameController.neutralObserver.update();
				MonopolyGameController.idleTimer.restart();
				resetLabels();
				isBuyed= false;
				btnEndTurn.setEnabled(false);
			}
		});

		for (Player p : MonopolyGameController.players) {

			PlayerGUI g=new PlayerGUI(p);

			player_guis.add(g);

			players_panel.add(g.playerStatPanel);
		}


	}

	public void updateGui() {
		//Card pick initialization
		if(rolled) {
			if(prop.getClass() == TitleDeed.class) {
				TitleDeed temp = (TitleDeed) prop;
				if(temp.getOwner()!=current && temp.getOwner()!=null) {
					PayRent_PopUp_Window payrentPopUp = new PayRent_PopUp_Window();
					payrentPopUp.setPropertyName(prop.getName());
					payrentPopUp.setOwner(temp.getOwner().getName());
					payrentPopUp.setCurrentBalance(current.getBalance());
					payrentPopUp.setRentAmount(temp.calculateRent());
					payrentPopUp.calculateRemaining();
					payrentPopUp.show();
					payrentPopUp.setOwnerGu�(findGUIbyName(temp.getOwner().getName()));
					payrentPopUp.setCurrentGu�(findGUIbyName(current.getName()));
					payrentPopUp.setRentDeed(temp);
				}
			}
			if(prop.getClass() == Chance.class ) {
				Chance temp = (Chance) prop;
				TakeCard_PopUp_Window cardWindow = new TakeCard_PopUp_Window();
				cardWindow.setSquare(prop);
				cardWindow.setCardType("Chance");
				cardWindow.setCardDescription(temp.toString());
				cardWindow.show();
			}else if(prop.getClass() == CommunityChest.class) {
				CommunityChest temp = (CommunityChest) prop;
				TakeCard_PopUp_Window cardWindow = new TakeCard_PopUp_Window();
				cardWindow.setCardType("Community");
				cardWindow.setCardDescription(temp.toString());
				cardWindow.setSquare(prop);
				cardWindow.show();
			}
		}
		//================================================
		
		// Buy Panel initialization
		if(prop.getBuyable().getBuyableType()){

			if(prop.getClass() == TitleDeed.class) {
				TitleDeed title_temp = (TitleDeed) prop;
				if(title_temp.getOwner()!=current && title_temp.getOwner()==null) {
					buy_panel.setVisible(true);
					lblBuyable_price_label.setText(title_temp.getPrice()+" $");
				}
			}
			if(prop.getClass() == Transportation.class) {
				Transportation trans_temp = (Transportation) prop;
				if(trans_temp.getOwner()!=current && trans_temp.getOwner()==null) {
					buy_panel.setVisible(true);
					lblBuyable_price_label.setText(trans_temp.getPrice()+" $"); 
				}
			}
			if(prop.getClass() == Utility.class) {
				Utility util = (Utility) prop;
				if(util.getOwner()!=current && util.getOwner()==null) {
					buy_panel.setVisible(true);
					lblBuyable_price_label.setText(util.getPrice()+" $"); 
				}
			}
			lblBuyable_property_name.setText(prop.getName());

		}else{
			buy_panel.setVisible(false);
		}
		//=========================================
		
		
	
		
		
		
		lblTurn_label.setText(current.getName());


		if(!first_roll) {
			btnRoll.setEnabled(false);
		}else {
			btnRoll.setEnabled(true);
		}

		rolled=false;
	}

	public void resetLabels() {
		lblFaceVal1_label.setText("0");
		lblFaceVal2_label.setText("0");
		lblTotalMove_label.setText("0");
		lblCurrentPosition_label.setText(prop.getName());
		buy_panel.setVisible(false);
	}
	public static void updatePlayerGui() {
		for(PlayerGUI pg: player_guis) {
			pg.balance_label.setText(findPlayerbyName(pg.name_label.getText()).getBalance()+" $");
			pg.lblPosition.setText(MonopolyGameController.squareList[findPlayerbyName(pg.name_label.getText()).getPosition()].getName());
		}
	}
	public static PlayerGUI findGUIbyName(String name) {
		for(PlayerGUI pg: player_guis) {
			if(pg.name_label.getText() == name) {
				return pg;
			}
		}
		return null;
	}
	public static Player findPlayerbyName(String name) {
		for(Player p : MonopolyGameController.players) {
			if(p.getName() == name) {
				return p;
			}
		}
		return null;
	}
}
