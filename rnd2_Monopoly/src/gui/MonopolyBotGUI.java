package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import domain.MonopolyGameController;

public class MonopolyBotGUI {
	JPanel botPanel = new JPanel();
	JLabel botLabel = new JLabel("",SwingConstants.CENTER);
	static ImageIcon neutral = new ImageIcon(MonopolyBoard.class.getResource("/gui/pics/Challenge_Accept_4fedc45a89cf3_large.jpeg"));
	static ImageIcon bored = new ImageIcon(MonopolyBoard.class.getResource("/gui/pics/Annoyed_Dude_Dec_4fad9a77208a5_large.png"));
	static ImageIcon amused = new ImageIcon(MonopolyBoard.class.getResource("/gui/pics/lol.jpg"));
	static ImageIcon mad = new ImageIcon(MonopolyBoard.class.getResource("/gui/pics/Mad_Rage_Face_Di_4fedc4e6aee20_large.jpeg"));
	static ImageIcon afraid = new ImageIcon(MonopolyBoard.class.getResource("/gui/pics/Raisins_Face.jpg"));
	Timer emotionTimer;
	int updateTime = 1000;

	MonopolyBotGUI() {
		
		botPanel.setLayout(new GridBagLayout());
		botPanel.setBounds(200, 200, 520, 500);
		botPanel.add(botLabel);
		botLabel.setIcon(neutral);
		botPanel.setBackground(Color.white);
		//botLabel.setPreferredSize(new Dimension(520, 500));
		botLabel.setMaximumSize(new Dimension(520, 500));
		
		ActionListener emoTask = new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (getEmotionFromDomain().equals("Neutral")) {
					setBotEmotion(MonopolyBotGUI.neutral);
				} else if (getEmotionFromDomain().equals("Bored")) {
					setBotEmotion(MonopolyBotGUI.bored);
				} else if (getEmotionFromDomain().equals("Amused")) {
					setBotEmotion(MonopolyBotGUI.amused);
				} else if (getEmotionFromDomain().equals("Mad")) {
					setBotEmotion(MonopolyBotGUI.mad);
				} else if (getEmotionFromDomain().equals("Afraid")) {
					setBotEmotion(MonopolyBotGUI.afraid);
				}

			}
		};

		emotionTimer = new Timer(updateTime, emoTask);
		emotionTimer.start();

	}

	public void setBotEmotion(ImageIcon emo) {
		this.botLabel.setIcon(emo);
	}

	public String getEmotionFromDomain() {
		return MonopolyGameController.gamebot.getEmotion();
	}
}
