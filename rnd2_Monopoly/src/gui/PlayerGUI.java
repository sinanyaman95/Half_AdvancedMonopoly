package gui;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.*;

public class PlayerGUI {
	public JPanel playerStatPanel=new JPanel();
	public JLabel playerNameLabel=new JLabel();
	public JTextArea propList=new JTextArea();
	
	public PlayerGUI(Player p) {
		playerNameLabel.setText(p.getName());
		
		for(TitleDeed td:p.getOwnedTitleDeeds()) {
			propList.append(td.name);
		}
		for(Company c:p.getOwnedCompanies()) {
			propList.append(c.name);
		}
		
		playerStatPanel.add(playerNameLabel);
		playerStatPanel.add(propList);
		
	}

}
