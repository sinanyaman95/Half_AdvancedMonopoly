package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SpeedDie implements Dice{
	public String faceVal;
	public ArrayList<String> speedDie_faceValues = new ArrayList<String>(Arrays.asList("1", "2", "3","Mr. Monopoly","Mr. Monopoly","Bus"));

	public void roll() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		faceVal = speedDie_faceValues.get(rand.nextInt(6));

		
	}

	public String getFaceValue() {
		// TODO Auto-generated method stub
		return faceVal;
	}
	
	public String toString() {
		return "Speed Die rolled, face value is: " + this.getFaceValue();
	}
	
	public boolean repOK() {
		boolean asserter = false;
		if(this.getFaceValue() instanceof String) asserter = true;
		
		return asserter;
	}
	
}
