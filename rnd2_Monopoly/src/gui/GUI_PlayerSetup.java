package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.MonopolyGameController;
import domain.Player;

public class GUI_PlayerSetup extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private int counter = 0; 
	private int counter2 = 1; 
	private boolean first=true;
	private boolean first_player=true;
	
	
	//Launches and creates the Player setup window
	public GUI_PlayerSetup() {
		initPlayerSetup();
		setVisible(true);
	}

	public void initPlayerSetup () {

		setTitle("Player Setup");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		counter = StartingScreen.numOfStart;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setLocationRelativeTo(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.setForeground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player new_player = new Player();
				if(textField.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"Please give the player a name!");
				}else {
					if(first_player) {
						new_player.setCheckTurn(true);
						first_player=false;
					}else {
						new_player.setCheckTurn(false);
					}
					new_player.setName(textField.getText());
					new_player.setBalance(1000);		
					new_player.setPosition(0);
					
					MonopolyGameController.players.add(new_player);
					textField.setText("");
					counter--;
					counter2++;
					lblNewLabel_1.setText("Player "+counter2);
					if(counter == 0) {	
						setVisible(false);
						new MonopolyBoard();
						//new MonopolyBotGUI();
					}
				}
			}
		});

		new MonopolyGameController();

		btnSave.setBounds(324, 70, 100, 93);
		contentPane.add(btnSave);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(10, 70, 69, 47);
		contentPane.add(lblName);

		textField = new JTextField();
		textField.setBounds(91, 79, 134, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Select Icon :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 122, 89, 47);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 136, 116, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(301, 0, 13, 261);
		contentPane.add(btnNewButton);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 11, 281, 40);
		contentPane.add(lblNewLabel_1);
		if(first) {
			lblNewLabel_1.setText("Player "+counter2);
			first=false;
		}

	}
}

