package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

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

}
