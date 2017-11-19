package gui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.*;;

public class MonopolyBoard {

	private JFrame frame;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MonopolyBoard() {
		initialize();
		this.frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel monopolyBoard = new JLabel("");
		monopolyBoard.setIcon(
				new ImageIcon(MonopolyBoard.class.getResource("/pics/ultimate_monopoly_by_jonizaak-d5wgqgs.png")));
		monopolyBoard.setBounds(108, -30, 986, 986);

		frame.getContentPane().add(monopolyBoard);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		monopolyBoard.setSize(d.width, d.height);

		JPanel pppanel=new JPanel();
		JPanel pnl2=new JPanel();
		pnl2.setBackground(Color.BLUE);
		pppanel.setBounds(1100,77,500,800);
		pppanel.setBackground(Color.GREEN);
		pnl2.setPreferredSize(new Dimension(300,300));
		pppanel.add(pnl2);
		frame.getContentPane().add(pppanel);
		
		for (Player p : MonopolyGameController.playerList) {

			PlayerGUI g=new PlayerGUI(p);
			
			pnl2.add(g.playerStatPanel);

			

		}

	
	}
}
