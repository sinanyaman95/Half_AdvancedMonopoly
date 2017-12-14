package domain.cards.chancecards;

import domain.Player;
import domain.cards.ChanceCard;
import domain.squares.propertysquares.PropertySquare;
import domain.squares.propertysquares.TitleDeed;

public class MakeGeneralRepairsToAllYourProperties extends ChanceCard {
	
	//NEED MORE METHODS!!!!!!!!!!!!!!!!!!!!!!

	public MakeGeneralRepairsToAllYourProperties(boolean playImmediately) {
		super(true);
	}

	public void doCardAction(Player p) {
		int totalHouse = 0;
		int totalHotel = 0;
		int totalSky = 0;
		int totalProp=p.getOwnedTransportation().size();
		
		for (TitleDeed td: p.getOwnedTitleDeeds()) {
			totalHouse += td.getNumberOfHouses();
			totalHotel += td.getNumberOfHotels();
			totalSky += td.getNumberOfSkyscrapers();
		}
		
		int sum= (25*(totalProp+totalHouse))+(100*(totalHotel+totalSky));
		
		p.setBalance(p.getBalance()-sum);
		
	}
	@Override
    public String toString() {
        return  "Make General Repairs To All Your Properties";
    }

	@Override
	public void setCardDescription(String desc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCardType(String type) {
		// TODO Auto-generated method stub
		
	}


}
