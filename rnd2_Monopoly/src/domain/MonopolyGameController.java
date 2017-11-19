package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import jdk.nashorn.internal.parser.JSONParser;



public class MonopolyGameController {
	public static ArrayList<Player> players = new ArrayList<Player>();

	public static  Player bank=new Player("Bank", 999999999);
	public  Player p1=new Player("Umur", 1000);
	public  Player p2=new Player("Ege", 1000);
	public  Player p3=new Player("Murat", 1000);
	public  Player p4=new Player("Sinan", 1000);
	public  Player p5=new Player("Hüseyin", 1000);

	
	public  void initPlayers() {
		players.add(bank);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		
	}



	public boolean SaveGame() {
		
		JSONObject object = new JSONObject();
		int i=0;
		for(Player p: players) {
			JSONObject player = new JSONObject();
			JSONArray ownedDeeds = new JSONArray();
			JSONArray ownedCompanies = new JSONArray();
			for(TitleDeed t: p.getOwnedTitleDeeds()) {
				ownedDeeds.add(t.getName());
			}
			for(Company c: p.ownedCompanies) {
				ownedCompanies.add(c.getName());
			}
			player.put("Name", p.getName());
			player.put("Balance", p.getBalance());
			player.put("Owned_Title_Deeds",ownedDeeds);
			player.put("Owned_Companies", ownedCompanies);
			player.put("Position", p.getName());
			i++;
			object.put("p"+i, player);
			
		}
		try {
			File file=new File("C:\\Users\\umur\\Desktop\\MonopolySaveJSON.json");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			System.out.println("Writing JSON object to file");
			fileWriter.write(object.toString());
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean LoadGame() throws ParseException {
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\umur\\Desktop\\MonopolySaveJSON.json"));
			JSONObject jsonObject = (JSONObject) obj;
				
		}catch (IOException e) {
			
		}
		return false;

	}
}
