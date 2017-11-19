package domain;

import java.util.ArrayList;
import java.util.Arrays;
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
	public ArrayList<String> speedDie_faceValues = new ArrayList<String>(Arrays.asList("1", "2", "3","Mr. Monopoly","Mr. Monopoly","Bus"));
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		faceVal = speedDie_faceValues.get(rand.nextInt(6)+1);

		
	}

	@Override
	public String getFaceValue() {
		// TODO Auto-generated method stub
		return faceVal;
	}
	
	
}