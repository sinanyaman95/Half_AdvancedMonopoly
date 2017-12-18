package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.SpeedDie;

public class SpeedDieTest {

	private SpeedDie die;
	@Before
	public void setUp() throws Exception {
		die = new SpeedDie();
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
