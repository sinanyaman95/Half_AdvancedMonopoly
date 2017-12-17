package domain.squares.propertysquares;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Player;

public class BuildHotelTest {

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
		for (int i = 0; i <4; i ++) {
			p.getBuildingFacade().buildHouse(p, property1);
		}
		int x = property1.getNumberOfHouses();
		System.out.println("number of houses before hotel: " + x);
		System.out.println("Player balance: " + p.getBalance());
		System.out.println("Required balance: " + property1.getHouseCost());
		p.getBuildingFacade().buildHotel(p, property1);
		int y = property1.getNumberOfHotels();
		assertEquals(1,y);
		
	}

}
