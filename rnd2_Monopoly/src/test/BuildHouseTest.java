/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Player;
import domain.squares.propertysquares.TitleDeed;

/**
 * @author rnd2
 *
 */
public class BuildHouseTest {
	private TitleDeed property1;

	private TitleDeed property2;
	private Player p;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		property1 =  new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
		property2 = new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
		p = new Player("Sinan", 1000.0);
	}

	@Test
	public void test() {
		property1.setOwner(p);
		property2.setOwner(p);
		p.getOwnedTitleDeeds().add(property1);
		p.getOwnedTitleDeeds().add(property2);
		int x = property1.getNumberOfHouses();
		System.out.println("number of houses before building: " + x);
		p.getBuildingFacade().buildHouse(p, property1);
		int y = property1.getNumberOfHouses();
		System.out.println("number of houses after building: " + y);
		assertEquals(1,y);
		
	}

}
