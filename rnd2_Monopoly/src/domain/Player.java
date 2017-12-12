package domain;

import java.awt.List;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import domain.squares.PropertySquare;
import domain.squares.TitleDeed;
import domain.squares.Transportation;

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

	public Player(String name, double balance) {
		this.name=name;
		this.balance=balance;
	}
	public Player() {}
	
	public boolean isCheckTurn() {
		return checkTurn;
	}
	public void setCheckTurn(boolean checkTurn) {
		this.checkTurn = checkTurn;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	

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

}
