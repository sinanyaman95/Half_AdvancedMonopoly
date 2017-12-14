
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PayRent_PopUp_Window extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblRentAmount_label;
	private JLabel lblCurrentBalance_label;
	private JLabel lblRemainingBalance_label;
	private JLabel lblPropertyname;
	private JLabel lblOwner_label;
	public boolean success = false;
	
	public PayRent_PopUp_Window() {
		getContentPane().setBackground(Color.CYAN);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.CYAN);
		contentPanel.setBounds(0, 0, 434, 198);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPayRent_header_message = new JLabel("You have to pay rent!!");
			lblPayRent_header_message.setHorizontalAlignment(SwingConstants.CENTER);
			lblPayRent_header_message.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPayRent_header_message.setBounds(108, 11, 207, 24);
			contentPanel.add(lblPayRent_header_message);
		}
		
		JLabel lblRentAmount_label_header = new JLabel("Rent Amount :");
		lblRentAmount_label_header.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRentAmount_label_header.setBounds(109, 88, 105, 24);
		contentPanel.add(lblRentAmount_label_header);
		
		lblRentAmount_label = new JLabel("New label");
		lblRentAmount_label.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRentAmount_label.setBounds(249, 93, 77, 14);
		contentPanel.add(lblRentAmount_label);
		
		JLabel lblCurrentBalance_label_header = new JLabel("Current Balance :");
		lblCurrentBalance_label_header.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentBalance_label_header.setBounds(109, 123, 105, 24);
		contentPanel.add(lblCurrentBalance_label_header);
		
		lblCurrentBalance_label = new JLabel("New label");
		lblCurrentBalance_label.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCurrentBalance_label.setBounds(249, 128, 77, 14);
		contentPanel.add(lblCurrentBalance_label);
		
		JLabel lblRemainingBalance_label_header = new JLabel("Remaining Balance :");
		lblRemainingBalance_label_header.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRemainingBalance_label_header.setBounds(109, 158, 130, 24);
		contentPanel.add(lblRemainingBalance_label_header);
		
		lblRemainingBalance_label = new JLabel("New label");
		lblRemainingBalance_label.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemainingBalance_label.setBounds(249, 163, 77, 14);
		contentPanel.add(lblRemainingBalance_label);
		
		lblPropertyname = new JLabel("Property_Name");
		lblPropertyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPropertyname.setBounds(55, 46, 122, 24);
		contentPanel.add(lblPropertyname);
		
		JLabel lblOwner = new JLabel("Owner :");
		lblOwner.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOwner.setBounds(215, 46, 62, 21);
		contentPanel.add(lblOwner);
		
		lblOwner_label = new JLabel("New label");
		lblOwner_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOwner_label.setBounds(287, 46, 84, 21);
		contentPanel.add(lblOwner_label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(60, 209, 309, 41);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						if(Double.parseDouble(lblRemainingBalance_label.getText())<=0) {
							JOptionPane.showMessageDialog(null, "Game Over! \nYou are bankrupted!!!");
							
						}else {
							success = true;
							
						}
					}
				});
			}
		}
	}
	
	public void setRentAmount(double amount) {
		lblRentAmount_label.setText(amount+"");
	}
	public void setCurrentBalance(double d) {
		lblCurrentBalance_label.setText(d+"");
	}
	public void calculateRemaining() {
		lblRemainingBalance_label.setText(""+(Double.parseDouble(lblCurrentBalance_label.getText())-Double.parseDouble(lblRentAmount_label.getText())));
	}
	public void setPropertyName(String name) {
		lblPropertyname.setText(name);
	}
	public void setOwner(String name) {
		lblOwner_label.setText(name);
	}
}