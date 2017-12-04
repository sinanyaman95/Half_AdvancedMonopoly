package domain;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.parser.ParseException;

import domain.squares.*;
import gui.StartingScreen;

public class Test {
	

	public static void main(String[] args) throws IOException, ParseException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, URISyntaxException {
		// TODO Auto-generated method stub
		//MonopolyGameController m = new MonopolyGameController();
		//m.initPlayers();
		//m.SaveGame();
		//m.LoadGame();
		new StartingScreen();
	}
}
