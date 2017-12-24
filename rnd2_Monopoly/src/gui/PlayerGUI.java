package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import domain.*;
import domain.squares.propertysquares.TitleDeed;
import domain.squares.propertysquares.Transportation;

public class PlayerGUI{
	
	public JPanel playerStatPanel=new JPanel();
	public JLabel balance_label;
	public JLabel name_label;
	public JComboBox comboBox_TitleDeeds;
	public JComboBox comboBox_Companies;
	public JLabel lblPosition;
	public  JLabel lblProperty_Name_Label;
	public  JLabel lblProp_Owner_Label;
	public  JLabel lblHouses_amount;
	public  JLabel lblHotels_amount;
	

	public  JLabel lblSkyscrapper_amount;
	/*
	public JLabel playerNameLabel=new JLabel();
	public JTextArea propList=new JTextArea();
	*/
	
	public PlayerGUI(Player p) {
		
		playerStatPanel.setBackground(new Color(127, 255, 212));
		playerStatPanel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 255)));
		playerStatPanel.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel name_label_header = new JLabel("Player :");
		name_label_header.setFont(new Font("Tahoma", Font.BOLD, 14));
		name_label_header.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(name_label_header);
		
		name_label = new JLabel("");
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(name_label);
		
		JLabel balance_label_header = new JLabel("Balance :");
		balance_label_header.setFont(new Font("Tahoma", Font.BOLD, 11));
		balance_label_header.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(balance_label_header);
		
		balance_label = new JLabel("New label");
		balance_label.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(balance_label);
		
		JLabel deeds_label_header = new JLabel("Deeds :");
		deeds_label_header.setFont(new Font("Tahoma", Font.BOLD, 11));
		deeds_label_header.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(deeds_label_header);
		
		JPanel panel_titleDeeds = new JPanel();
		panel_titleDeeds.setBackground(new Color(127, 255, 212));
		playerStatPanel.add(panel_titleDeeds);
		panel_titleDeeds.setLayout(new GridLayout(0, 1, 0, 0));
		
		comboBox_TitleDeeds = new JComboBox();
		panel_titleDeeds.add(comboBox_TitleDeeds);
		
		JLabel companies_label_header = new JLabel("Companies :");
		companies_label_header.setFont(new Font("Tahoma", Font.BOLD, 11));
		companies_label_header.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(companies_label_header);
		
		JPanel panel_companies = new JPanel();
		panel_companies.setBackground(new Color(127, 255, 212));
		playerStatPanel.add(panel_companies);
		panel_companies.setLayout(new GridLayout(0, 1, 0, 0));
		
		comboBox_Companies = new JComboBox();
		panel_companies.add(comboBox_Companies);
		
		JLabel lblPosition_header = new JLabel("Position :");
		lblPosition_header.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPosition_header.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(lblPosition_header);
		
		lblPosition = new JLabel("New label");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		playerStatPanel.add(lblPosition);

		name_label.setText(p.getName());
		
		comboBox_TitleDeeds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TitleDeed temp_Title = MonopolyBoard.findTitleDeedByName(comboBox_TitleDeeds.getSelectedItem().toString());
				System.out.println(temp_Title.getOwner().getName());
				System.out.println("Temp TÝTLE : " +temp_Title.toString());
				if(temp_Title.getOwner().isCheckTurn()){
				lblProp_Owner_Label.setText(temp_Title.getOwner().getName());
				lblProperty_Name_Label.setText(temp_Title.getName());
				lblHouses_amount.setText(temp_Title.getNumberOfHouses()+"");
				lblHotels_amount.setText(temp_Title.getNumberOfHotels()+"");
				lblSkyscrapper_amount.setText(temp_Title.getNumberOfSkyscrapers()+"");
				}
			}
		});
		
		
		
		
		balance_label.setText(p.getBalance()+" $");
		//propList.append(p.getPosition()+"");
		/*
		for(TitleDeed td:p.getOwnedTitleDeeds()) {
			deeds_label.setText(td.getName()+"/n");
		}
		for(Transportation c:p.getOwnedTransportation()) {
			companies_label.setText(c.getName()+"/n");
		}
		/*
		playerStatPanel.add(playerNameLabel);
		playerStatPanel.add(propList);
		*/
	}
	public JLabel getLblProperty_Name_Label() {
		return lblProperty_Name_Label;
	}

	public void setLblProperty_Name_Label(JLabel lblProperty_Name_Label) {
		this.lblProperty_Name_Label = lblProperty_Name_Label;
	}

	public JLabel getLblProp_Owner_Label() {
		return lblProp_Owner_Label;
	}

	public void setLblProp_Owner_Label(JLabel lblProp_Owner_Label) {
		this.lblProp_Owner_Label = lblProp_Owner_Label;
	}

	public JLabel getLblHouses_amount() {
		return lblHouses_amount;
	}

	public void setLblHouses_amount(JLabel lblHouses_amount) {
		this.lblHouses_amount = lblHouses_amount;
	}

	public JLabel getLblHotels_amount() {
		return lblHotels_amount;
	}

	public void setLblHotels_amount(JLabel lblHotels_amount) {
		this.lblHotels_amount = lblHotels_amount;
	}

	public JLabel getLblSkyscrapper_amount() {
		return lblSkyscrapper_amount;
	}

	public void setLblSkyscrapper_amount(JLabel lblSkyscrapper_amount) {
		this.lblSkyscrapper_amount = lblSkyscrapper_amount;
	}

}
