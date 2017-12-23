package domain;

import java.awt.List;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerMapper {
	
	@SerializedName("players")
	@Expose
	private ArrayList<LoadablePlayer> players = null;

	public ArrayList<LoadablePlayer> getPlayers() {
	return players;
	}

	public void setPlayers(ArrayList<LoadablePlayer> players) {
	this.players = players;
	}

	public PlayerMapper withPlayers(ArrayList<LoadablePlayer> players) {
	this.players = players;
	return this;
	}
}
