package domain;

import java.awt.List;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerMapper {
	
	@SerializedName("players")
	@Expose
	private ArrayList<Player> players = null;

	
	/**
	 * @return  the players registered as an arraylist
	 */
	public ArrayList<Player> getPlayers() {
	return players;
	}

	/**
	 * @param players
	 * @modifies players arraylist, registers the players
	 */
	public void setPlayers(ArrayList<Player> players) {
	this.players = players;
	}

	public PlayerMapper withPlayers(ArrayList<Player> players) {
	this.players = players;
	return this;
	}
}
