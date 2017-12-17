package domain;

import java.awt.List;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import domain.squares.propertysquares.BuildingFacade;
import domain.squares.propertysquares.PropertySquare;
import domain.squares.propertysquares.TitleDeed;
import domain.squares.propertysquares.Transportation;

public class Player {
	@SerializedName("checkTurn")
	@Expose
	private boolean checkTurn;
	
	@SerializedName("Name")
	@Expose
	private String name;

	@SerializedName("Position")
	@Expose
	private int position=0;
	
	@SerializedName("Balance")
	@Expose
	private double balance;
	
	@SerializedName("Owned_Title_Deeds")
	@Expose
	ArrayList<TitleDeed> ownedTitleDeeds=new ArrayList<TitleDeed>();
	
	
	@SerializedName("Owned_Transportation")
	@Expose
	ArrayList<Transportation> ownedTransportation=new ArrayList<Transportation>();

	@SerializedName("isInJail")
	@Expose
	private boolean isInJail;

	
	@SerializedName("buildingFacade")
	@Expose
	public BuildingFacade buildingFacade;

	
	public Player(String name, double balance) {
		this.name=name;
		this.balance=balance;
		setInJail(false);

		this.buildingFacade = new BuildingFacade();

	}
	public Player() {}
	
	public boolean isCheckTurn() {
		return checkTurn;
	}
	public void setCheckTurn(boolean checkTurn) {
		this.checkTurn = checkTurn;
	}
	
	public boolean isInJail() {
		return isInJail;
	}
	public void setInJail(boolean isInJail) {
		this.isInJail = isInJail;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	/**
	 * @param p - PropertySquare which stands for buyable squares superclass
	 * 
	 * @effect Player buys the property p, p is added to the Player's OwnedTitleDeeds list, Player's balance is decreased with p's price
	 * @modifies p - p's owner will set to be "this" player
	 * 
	 */
	public void buyProperty(PropertySquare p) {
		p.performPurchase(this, p);
	}

	public ArrayList<TitleDeed> getOwnedTitleDeeds() {
		return ownedTitleDeeds;
	}

	public void setOwnedTitleDeeds(ArrayList<TitleDeed> ownedTitleDeeds) {
		this.ownedTitleDeeds = ownedTitleDeeds;
	}

	public Player withOwnedTitleDeeds(ArrayList<TitleDeed> ownedTitleDeeds) {
		this.ownedTitleDeeds = ownedTitleDeeds;
		return this;
	}

	public ArrayList<Transportation> getOwnedTransportation() {
		return ownedTransportation;
	}

	public void setOwnedTransportation(ArrayList<Transportation> ownedTransportation) {
		this.ownedTransportation = ownedTransportation;
	}

	public Player withOwnedTransportation(ArrayList<Transportation> ownedTransportation) {
		this.ownedTransportation = ownedTransportation;
		return this;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * @param property
	 * @effect Player builds a House to the TitleDeed he/she owns if the requirements of building House is met.
	 * @modifies property - property's numberOfHouses will be increased by 1
	 */
	public void buildHouse(TitleDeed property) {
		buildingFacade.buildHouse(this, property);
	}

	/**
	 * @param property
	 * @effect Player builds a Hotel to the TitleDeed he/she owns if the requirements of building Hotel is met.
	 * @modifies property - property's numberOfHouses will be increased by 1
	 */
	public void buildHotel(TitleDeed property) {
		buildingFacade.buildHotel(this, property);
	}
	
	
	/**
	 * @param property
	 * @effect Player builds a SkyScraper to the TitleDeed he/she owns if the requirements of building Skyscraper is met.
	 * @modifies property - property's numberOfSkyscrapers will be increased by 1
	 */
	public void buildSkyscraper(TitleDeed property) {
		buildingFacade.buildSkyscraper(this, property);
	}
	
	
	public BuildingFacade getBuildingFacade() {
		return this.buildingFacade;
	}
	
	public void setBuildingFacade(BuildingFacade buildingFacade) {
		this.buildingFacade = buildingFacade;
	}

	
	public String toString() {
		return "Player name: "+  this.getName() + "balance: " + this.getBalance() + "\n[Owned Deeds]: " + this.getOwnedTitleDeeds().toString()
				+ "\n[Owned Transportation]: " + this.getOwnedTransportation();
	}
	
	public boolean repOK() {
		boolean asserter = false;
		for(TitleDeed td : this.getOwnedTitleDeeds()){
			if(td instanceof TitleDeed) asserter = true;
		}
		if(this.getName() instanceof String) asserter=true;
		
		return asserter;
		
	}


}
