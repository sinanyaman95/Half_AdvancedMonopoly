package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public interface Dice {
	
	/**
	 * @effects generate a random number between 1 and 6
	 */
	public void roll();
	
	public String getFaceValue();
}
