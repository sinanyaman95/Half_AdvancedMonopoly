package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import domain.squares.TitleDeed;
import domain.squares.Transportation;



public class MonopolyGameController {
	
	private static MonopolyGameController instance = new MonopolyGameController();
	
	public static MonopolyGameController getInstance() {
		return instance;
	}

	public static void setInstance(MonopolyGameController instance) {
		MonopolyGameController.instance = instance;
	}

	public static ArrayList<Player> players = new ArrayList<Player>();

	public static  Player bank=new Player("Bank", 999999999);
	public static  Player p1= new Player("Bank", 999999999);
	public static  Player p2= new Player("Bank", 999999999);
	public static  Player p3= new Player("Bank", 999999999);
	public static  Player p4= new Player("Bank", 999999999);
	public static  Player p5= new Player("Bank", 999999999);
	public static  Player p6= new Player("Bank", 999999999);
	public static  Player p7= new Player("Bank", 999999999);

	
	public static  void initPlayers() {
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);
		players.add(p7);
		
	}



	public static boolean SaveGame() {
		
		JSONObject object = new JSONObject();
		JSONArray players_array = new JSONArray();
		for(Player p: players) {
			JSONObject player = new JSONObject();
			JSONArray ownedDeeds = new JSONArray();
			JSONArray ownedCompanies = new JSONArray();
			for(TitleDeed t: p.getOwnedTitleDeeds()) {
				ownedDeeds.add(t.getName());
			}
			for(Transportation c: p.ownedTransportation) {
				ownedCompanies.add(c.getName());
			}
			player.put("Name", p.getName());
			player.put("Balance", p.getBalance());
			player.put("Owned_Title_Deeds",ownedDeeds);
			player.put("Owned_Transportation", ownedCompanies);
			player.put("Position", p.getPosition());
			players_array.add(player);
		}
		object.put("players", players_array);
		
		try {
			File dir = new File("GameSaveFiles");
			dir.mkdirs();
			File tmp = new File(dir,"MonopolySaveJSON3.json");
			tmp.createNewFile();
			
			/*
			URL path = this.getClass().getResource("/pics/MonopolySaveJSON2.json");
			File file=new File(path.getFile());
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			*/
			FileWriter fileWriter = new FileWriter(tmp);
			System.out.println("Writing JSON object to file");
			fileWriter.write(object.toString());
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean LoadGame() throws ParseException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Gson gs = new Gson();
		BufferedReader br = null;
		try {
			//br = new BufferedReader(new FileReader("C:\\Users\\umur1\\Desktop\\MonopolySaveJSON.json"));
			//URL path = this.getClass().getResource("/pics/MonopolySaveJSON.json");
			br = new BufferedReader(new FileReader(new File("GameSaveFiles/MonopolySaveJSON3.json")));
			PlayerMapper player = gs.fromJson(br, PlayerMapper.class);
			if(player != null) {
				int i=1;
				for(Player p: player.getPlayers()) {
					if(p != null) {
					//System.out.println(p.getName() + " " + p.getBalance() + " " + p.getPosition() + " " + p.getOwnedTitleDeeds().toString());
					MonopolyGameController.class.getDeclaredField("p"+i).set(instance, p);
					i++;
					}
				}
				initPlayers();
			}
				
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
					return true;
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}
}
