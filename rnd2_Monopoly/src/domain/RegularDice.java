package domain;

import java.util.Random;

public class RegularDice implements Dice{	
	
	private String faceVal;
	
	public RegularDice() {
		super();
	}
	
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		faceVal = ""+(rand.nextInt(6)+1);
	}

	@Override
	public String getFaceValue() {
		// TODO Auto-generated method stub
		return faceVal;
	}
	
	
}
