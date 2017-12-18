package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerConstructionTest {
	private Player p;
	@Before
	public void setUp() throws Exception {
		p = new Player("rnd2", 1000.0);
	}

	@Test
	public void test() {
		assertEquals("rnd2", p.getName());
		System.out.println(p.toString());
	}

}
