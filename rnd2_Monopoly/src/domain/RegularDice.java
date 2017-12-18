package domain;

import java.util.Random;

public class RegularDice implements Dice{	
	
	private String faceVal;
	
	public RegularDice() {
		super();
	}
	
	public void roll() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		faceVal = ""+(rand.nextInt(6)+1);
	}

	public String getFaceValue() {
		// TODO Auto-generated method stub
		return faceVal;
	}
	
	public String toString() {
		return "Regular Die rolled, face value is: " + this.getFaceValue();
	}
	
	public boolean repOK() {
		boolean asserter = false;
		if(this.getFaceValue() instanceof String) asserter = true;
		
		return asserter;
	}
	
}
