package domain;

import java.util.ArrayList;

public class Player {

	private String name;


	private int position=0;
	private double balance;
	private ArrayList<Square> ownedProperties=new ArrayList<Square>();
	
	
	public Player(String name, double balance) {
		name=this.name;
		balance=this.balance;
		
		
	}
	
	public void buyProperty(Square p) {
		p.performPurchase(this);
	}

	public ArrayList<Square> getOwnedProperties() {
		return ownedProperties;
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
