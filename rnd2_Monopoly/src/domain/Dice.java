package domain;

import java.util.Random;

public interface Dice {
	public void roll();
	public String getFaceValue();
}

class RegularDice implements Dice{	
	
	private String faceVal;
	
	public RegularDice() {
		super();
		
	}
	
	private String val;
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		faceVal = ""+rand.nextInt(6)+1;
	}

	@Override
	public String getFaceValue() {
		// TODO Auto-generated method stub
		return faceVal;
	}
	
	
}
class SpeedDie implements Dice{
	public String faceVal;
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFaceValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}