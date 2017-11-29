package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StartingScreen {

	private JFrame frame;
	
	String[] numofPlay = { "2","3","4" };
	public static int numOfStart;



	/**
	 * Create the application.
	 */
	public StartingScreen() {
		initialize();
		this.frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MonopolyBoard();
			}
		});
		btnStartGame.setBounds(150, 136, 154, 25);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnLoadGame.setBounds(150, 174, 154, 25);
		frame.getContentPane().add(btnLoadGame);
		
		JLabel lblNumofPlayers = new JLabel("Select Number of Players:");
		lblNumofPlayers.setBounds(150, 98, 154, 25);
		frame.getContentPane().add(lblNumofPlayers);
		
		JComboBox comboBox = new JComboBox(numofPlay);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.SELECTED) {
					numOfStart = Integer.parseInt((String) comboBox.getSelectedItem());
					
				}
			}
		});
		comboBox.setBounds(316, 111, 71, 22);
		frame.getContentPane().add(comboBox);
	}
}