package domain.squares.propertysquares;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Player;

public class BuildSkyscraperTest {

	private TitleDeed property1;
	private TitleDeed property2;
	private TitleDeed property3;
	private Player p;
	@Before
	public void setUp() throws Exception {
		property1 =  new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
		property2 = new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
		property3 = new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
		p = new Player("Sinan", 7000.0);
	}

	@Test
	public void test() {
		property1.setOwner(p);
		property2.setOwner(p);
		property3.setOwner(p);
		p.getOwnedTitleDeeds().add(property1);
		p.getOwnedTitleDeeds().add(property2);
		p.getOwnedTitleDeeds().add(property3);
		//At this point, player owns all deeds of color group blue
		for (int i = 0; i <4; i ++) {
			p.getBuildingFacade().buildHouse(p, property1);
			p.getBuildingFacade().buildHouse(p, property2);
			p.getBuildingFacade().buildHouse(p, property3);
		}
		//Player now has built 4 houses for every deed in the color group blue
		System.out.println("Player balance before hotels: " + p.getBalance());
		p.getBuildingFacade().buildHotel(p, property1);
		p.getBuildingFacade().buildHotel(p, property2);
		p.getBuildingFacade().buildHotel(p, property3);;
		//Player now has built 1 hotel for every deed in the color group blue
		System.out.println("Player balance: " + p.getBalance());
		System.out.println("Required balance for sky: " + property1.getSkyscraperCost());
		p.getBuildingFacade().buildSkyscraper(p, property1);
		int y = property1.getNumberOfSkyscrapers();
		System.out.println("numberofsky: " + y);
		assertEquals(1,y);
		
	}
}
