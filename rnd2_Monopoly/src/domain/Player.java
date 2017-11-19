package domain;

import java.util.ArrayList;

public class Player {

	private String name;


	private int position=0;
	private double balance;
	ArrayList<TitleDeed> ownedTitleDeeds=new ArrayList<TitleDeed>();
	ArrayList<Company> ownedCompanies=new ArrayList<Company>();

	
	
	public Player(String name, double balance) {
		name=this.name;
		balance=this.balance;
		
		
	}
	
	public void buyProperty(PropertySquare p) {
		p.performPurchase(this, p);
	}

	public ArrayList<TitleDeed> getOwnedTitleDeeds() {
		return this.ownedTitleDeeds;
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
