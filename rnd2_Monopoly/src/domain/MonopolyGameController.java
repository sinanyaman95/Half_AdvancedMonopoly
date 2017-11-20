package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;



public class MonopolyGameController {
	public static ArrayList<Player> players = new ArrayList<Player>();

	public static  Player p1=new Player("Bank", 999999999);
	public  Player p2= null;
	public  Player p3= null;
	public  Player p4= null;
	public  Player p5= null;
	public  Player p6= null;
	
	

	
	public  void initPlayers() {
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);
		
	}



	public boolean SaveGame() {
		
		JSONObject object = new JSONObject();
		JSONArray players_array = new JSONArray();
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
			player.put("Position", p.getPosition());
			players_array.add(player);
		}
		object.put("players", players_array);
		
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

	public boolean LoadGame() throws ParseException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Gson gs = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\umur\\Desktop\\MonopolySaveJSON.json"));
			PlayerMapper player = gs.fromJson(br, PlayerMapper.class);
			if(player != null) {
				int i=1;
				for(Player p: player.getPlayers()) {
					//System.out.println(p.getName() + " " + p.getBalance() + " " + p.getPosition() + " " + p.getOwnedTitleDeeds().toString());
					getClass().getDeclaredField("p"+i).set(this, p);
					i++;
				}
				initPlayers();
			}
				
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}
}
