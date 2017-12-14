package domain.squares.propertysquares;

import java.util.ArrayList;

import domain.Player;

public class HouseChecker {
	private int colorsOwned;
	public HouseChecker() {
	}
	
	/**
	 * @param p
	 * @param property
	 * @return true if MajorityOwnership and other requirements are met for building a house for the property
	 */
	public boolean houseAvailable(Player p,TitleDeed property) {
		if(this.isMajorityOwnership(p, property) && p.getBalance() >= property.getHouseCost()) {
			return (property.getNumberOfHouses() <4 );
		}
		return false;
	}
	
	/**
	 * @return ArrayList of colors that have 4 properties in the board
	 */
	public ArrayList<String> fourColorList(){
		ArrayList<String> fourColor = new ArrayList<String>();
		fourColor.add("light Green");
		fourColor.add("ocean Green");
		fourColor.add("gold");
		fourColor.add("light Red");
		fourColor.add("magenta");
		fourColor.add("light Yellow");
		return fourColor;
	}
	
	/**
	 * @param property
	 * @return true if a property has 4 of the same color in the board, false otherwise
	 */
	public boolean checkInFour(TitleDeed property) {
		return (this.fourColorList().contains(property.getColor()));
	}
	/**
	 * @param p
	 * @param property
	 * @return true if player has all but one colors of the same property color group
	 */
	public boolean isMajorityOwnership(Player p, TitleDeed property) {
		
		int colorCount=0;
		for(TitleDeed td : p.getOwnedTitleDeeds()) {
			if(td.getColor().equalsIgnoreCase(property.getColor())){
				colorCount += 1;
			}
		}
		setColorsOwned(colorCount);
		if (fourColorList().contains(property.getColor())) {
			return (colorCount >= 3);
		}else {
			return (colorCount >= 2);
		}
	}

	public int getColorsOwned() {
		return colorsOwned;
	}

	public void setColorsOwned(int colorsOwned) {
		this.colorsOwned = colorsOwned;
	}
	
}
