package domain.squares.propertysquares;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TitleDeedTaxTest {
	private TitleDeed property;
	@Before
	public void setUp() throws Exception {
		property =  new TitleDeed(0,"x","blue",100,2,30,0,0,0,50);
	}

	@Test
	public void test() {
		property.addTaxList(1, 2, 3, 4, 5, 6);
		double rentOne = property.getRent().get(0);
		assertTrue(1==rentOne);
		System.out.println(property.toString());
	}

}
