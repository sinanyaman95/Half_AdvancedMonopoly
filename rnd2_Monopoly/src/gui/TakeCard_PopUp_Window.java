package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TakeCard_PopUp_Window extends JDialog{

	private JLabel lblCard_Type_label;
	private JTextArea txtArea_CardDesc;

	
	public TakeCard_PopUp_Window() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(75, 201, 270, 23);
			getContentPane().add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
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
	}
	public void setCardDescription(String desc) {
		txtArea_CardDesc.setText(desc);
	}
}
