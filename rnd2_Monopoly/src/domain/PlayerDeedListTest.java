package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.squares.propertysquares.TitleDeed;

public class PlayerDeedListTest {
	private TitleDeed property;
	private Player p;
	@Before
	public void setUp() throws Exception {
		p = new Player("rnd2", 1000.0);
		property =  new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
	}

	@Test
	public void test() {
		property.setOwner(p);
		assertEquals("rnd2",property.getOwner().getName());
		p.getOwnedTitleDeeds().add(property);
		assertTrue(p.getOwnedTitleDeeds().contains(property));
		System.out.println(p.toString());
	}

}
