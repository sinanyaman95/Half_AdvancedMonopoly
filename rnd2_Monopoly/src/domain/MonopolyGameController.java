package domain;

import java.util.ArrayList;

import gui.StartingScreen;

public class MonopolyGameController {
	
public static Player bank=new Player("Bank", 999999999);

public static ArrayList<Player> playerList=new ArrayList<Player>();
public void initializeGame() {
	
	for(int i=0; i<StartingScreen.numOfStart;i++) {
		Player p=new Player("Player"+" "+i,3200);
		playerList.add(p);
	}
		
}

	


}
