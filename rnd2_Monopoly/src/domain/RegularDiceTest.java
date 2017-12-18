package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegularDiceTest {
	private RegularDice die;
	@Before
	public void setUp() throws Exception {
		die = new RegularDice();
	}

	@Test
	public void test() {
		for(int i = 0; i < 5; i ++) {
			die.roll();
			System.out.println(die.toString());
		}
		assertTrue(die.repOK());
	}
	

}
