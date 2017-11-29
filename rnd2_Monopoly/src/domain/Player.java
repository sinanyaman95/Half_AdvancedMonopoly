package domain;

import java.awt.List;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {
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
	
	@SerializedName("Owned_Companies")
	@Expose
	ArrayList<Company> ownedCompanies=new ArrayList<Company>();



	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Player(String name, double balance) {
		this.name=name;
		this.balance=balance;


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

	public ArrayList<Company> getOwnedCompanies() {
		return ownedCompanies;
	}

	public void setOwnedCompanies(ArrayList<Company> ownedCompanies) {
		this.ownedCompanies = ownedCompanies;
	}

	public Player withOwnedCompanies(ArrayList<Company> ownedCompanies) {
		this.ownedCompanies = ownedCompanies;
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
