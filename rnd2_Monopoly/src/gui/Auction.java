package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;
import domain.squares.propertysquares.TitleDeed;
import domain.squares.propertysquares.Transportation;
import domain.squares.propertysquares.Utility;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class Auction extends JDialog {
	private JTextField txtField_bid_amount;
	private Player currentPlayer;

	private Square prop;
	private double bidAmount;
	private int index = 0;
	private JLabel lblPropName;
	private JLabel lblHighestBid_label;
	private JLabel lblBiddingPlayer_label;
	private int passCount = 0;
	private Player highestBidder;
	private int highestBidIndex;
	

	public Auction(Square prop,Player current, Double bid) {
		this.prop = prop;
		this.currentPlayer = current;
		this.bidAmount = bid;
		
		setBounds(100, 100, 807, 354);
		getContentPane().setLayout(null);
		{
			JLabel lblAuction = new JLabel("AUCTION");
			lblAuction.setHorizontalAlignment(SwingConstants.CENTER);
			lblAuction.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAuction.setBounds(152, 0, 479, 35);
			getContentPane().add(lblAuction);
		}
		
		lblPropName = new JLabel("New label");
		lblPropName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPropName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropName.setBounds(274, 46, 229, 22);
		getContentPane().add(lblPropName);
		lblPropName.setText(prop.getName());
		JLabel lblHighestBid = new JLabel("Highest Bid :");
		lblHighestBid.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighestBid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHighestBid.setBounds(42, 82, 97, 22);
		getContentPane().add(lblHighestBid);
		
		lblHighestBid_label = new JLabel("New label");
		lblHighestBid_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHighestBid_label.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighestBid_label.setBounds(152, 85, 83, 19);
		getContentPane().add(lblHighestBid_label);
		
		JButton btnBid = new JButton("Bid");
		btnBid.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBid.setBounds(152, 256, 229, 35);
		getContentPane().add(btnBid);
		
		JButton btnPass = new JButton("Pass");
		btnPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPass.setBounds(397, 256, 229, 35);
		getContentPane().add(btnPass);
		
		JLabel lblBid = new JLabel("Bid :");
		lblBid.setHorizontalAlignment(SwingConstants.CENTER);
		lblBid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBid.setBounds(42, 177, 97, 22);
		getContentPane().add(lblBid);
		
		txtField_bid_amount = new JTextField();
		txtField_bid_amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtField_bid_amount.setBounds(152, 179, 86, 20);
		getContentPane().add(txtField_bid_amount);
		txtField_bid_amount.setColumns(10);
		
		JLabel lblBiddingPlayer = new JLabel("Bidding Player :");
		lblBiddingPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiddingPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBiddingPlayer.setBounds(42, 144, 109, 22);
		getContentPane().add(lblBiddingPlayer);
		
		lblBiddingPlayer_label = new JLabel("...");
		lblBiddingPlayer_label.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiddingPlayer_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBiddingPlayer_label.setBounds(152, 144, 97, 22);
		getContentPane().add(lblBiddingPlayer_label);
		
		ArrayList<Player> auctionPlayer = new ArrayList<Player>();
		for(Player p : MonopolyGameController.players) {
			auctionPlayer.add(p);
		}
		auctionPlayer.remove(currentPlayer);
		
		
		for(Player p: auctionPlayer) {
			System.out.println(p.getName());
		}
		
		lblBiddingPlayer_label.setText(auctionPlayer.get(index).getName());
		
		
		if (index==auctionPlayer.size()-1) {
			index = 0;
		}
		
		
		
		
		btnBid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String bidText = txtField_bid_amount.getText();
				double bid = Double.parseDouble(bidText);
				//System.out.println("Bid player: " + auctionPlayer);
				if(bidText != "" && bid > bidAmount && bid <= auctionPlayer.get(index).getBalance()) {
					bidAmount = bid;
					highestBidder = auctionPlayer.get(index);
					highestBidIndex = index;
					if (index==auctionPlayer.size()-1) {
						index = 0;
					}else {
						//System.out.println("Pass player: " + auctionPlayer);
							index++;
						}
					passCount = 0;
					lblHighestBid_label.setText(bidAmount+"");
					lblBiddingPlayer_label.setText(auctionPlayer.get(index).getName());
				}else {
					JOptionPane.showMessageDialog(null, "Please enter valid amount");
				}
			}
		});
		
		
		btnPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				if (index==auctionPlayer.size()-1) {
					index = 0;
					System.out.println("index reset: " + index);
				}else {
				//System.out.println("Pass player: " + auctionPlayer);
					index++;
				}
				passCount++;
				System.out.println("Pass count: " + passCount);
				lblHighestBid_label.setText(bidAmount+"");
				lblBiddingPlayer_label.setText(auctionPlayer.get(index).getName());
				if(passCount == highestBidIndex + auctionPlayer.size() - 1) {
					if(prop.getClass() == TitleDeed.class) {
						TitleDeed temp = (TitleDeed) prop;
						double differenceBid = bidAmount - temp.getPrice();
						highestBidder.buyProperty(temp);
						MonopolyBoard.findGUIbyName(highestBidder.getName()).comboBox_TitleDeeds.addItem(temp.getName());
						highestBidder.setBalance(highestBidder.getBalance() - differenceBid);
						setVisible(false);
						MonopolyBoard.updatePlayerGui();
					}else if(prop.getClass() == Transportation.class) {
						Transportation temp = (Transportation) prop;
						double differenceBid = bidAmount - temp.getPrice();
						highestBidder.buyProperty(temp);
						MonopolyBoard.findGUIbyName(highestBidder.getName()).comboBox_TitleDeeds.addItem(temp.getName());
						setVisible(false);
						MonopolyBoard.updatePlayerGui();
					}else if(prop.getClass() == Utility.class) {
						Utility temp = (Utility) prop;
						double differenceBid = bidAmount - temp.getPrice();
						highestBidder.buyProperty(temp);
						MonopolyBoard.findGUIbyName(highestBidder.getName()).comboBox_TitleDeeds.addItem(temp.getName());
						setVisible(false);
						MonopolyBoard.updatePlayerGui();
					}
				}

			}
		});
	}
	public Square getProp() {
		return prop;
	}


	public void setProp(Square prop) {
		this.prop = prop;
		lblPropName.setText(prop.getName());
	}


	public double getBidAmount() {
		return bidAmount;
	}


	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public void resetIndex() {
		index = 0;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}
