package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.squares.actionsquares.BirthdayGift;

public class BirthdayGiftTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(BirthdayGift.repOK());
	}

}
