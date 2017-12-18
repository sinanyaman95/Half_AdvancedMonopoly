package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.squares.actionsquares.BirthdayGift;
import domain.squares.actionsquares.GoToJail;

public class GoToJailTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(GoToJail.repOK());
	}

}
