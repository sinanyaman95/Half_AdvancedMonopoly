package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.*;;

public class MonopolyBoard extends JFrame{

	private JFrame frame;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MonopolyBoard() {
		initialize();
		setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Monopoly Ultimate");
		getContentPane().setBackground(new Color(64, 224, 208));
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		
				JLabel monopolyBoard = new JLabel("");
				monopolyBoard.setBounds(38, 0, 993, 1007);
				getContentPane().add(monopolyBoard);
				monopolyBoard.setIcon(
						new ImageIcon(MonopolyBoard.class.getResource("/pics/ultimate_monopoly_by_jonizaak-d5wgqgs.png")));

		JPanel pppanel=new JPanel();
		pppanel.setBounds(1036,11,682,983);
		pppanel.setBackground(new Color(65, 105, 225));
		pppanel.setLayout(null);
		getContentPane().add(pppanel);
		JPanel pnl2=new JPanel();
		pnl2.setBounds(25, 27, 629, 513);
		pnl2.setBackground(new Color(64, 224, 208));
		pnl2.setPreferredSize(new Dimension(450, 400));
		pppanel.add(pnl2);
		pnl2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(1744, 35, 139, 23);
		getContentPane().add(btnSaveGame);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(1744, 69, 139, 23);
		getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(1744, 103, 139, 23);
		getContentPane().add(btnExit);
		
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
		for (Player p : MonopolyGameController.players) {

			PlayerGUI g=new PlayerGUI(p);
			
			pnl2.add(g.playerStatPanel);

			

		}

	
	}
}
