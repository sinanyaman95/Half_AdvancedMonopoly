package domain;

import gui.StartingScreen;
import org.json.JSONException;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new StartingScreen();
	
	MonopolyGameController m = new MonopolyGameController();
	m.initPlayers();
	try {
		m.SaveGame();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

}
