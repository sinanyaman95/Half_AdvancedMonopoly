package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import domain.MonopolyGameController;

public class MonopolyBotGUI {
	JFrame botFrame = new JFrame();
	JLabel botLabel = new JLabel("");
	static ImageIcon neutral = new ImageIcon(
			MonopolyBoard.class.getResource("/pics/Challenge_Accept_4fedc45a89cf3_large.jpeg"));
	static ImageIcon bored = new ImageIcon(
			MonopolyBoard.class.getResource("/pics/Annoyed_Dude_Dec_4fad9a77208a5_large.png"));
	static ImageIcon amused = new ImageIcon(MonopolyBoard.class.getResource("/pics/lol.jpg"));
	static ImageIcon mad = new ImageIcon(
			MonopolyBoard.class.getResource("/pics/Mad_Rage_Face_Di_4fedc4e6aee20_large.jpeg"));
	static ImageIcon afraid = new ImageIcon(MonopolyBoard.class.getResource("/pics/Raisins_Face.jpg"));
	Timer emotionTimer;
	int updateTime = 1000;

	MonopolyBotGUI() {
		botFrame.setVisible(true);
		botFrame.setBounds(200, 200, 520, 500);
		botFrame.add(botLabel);
		botLabel.setIcon(neutral);

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
