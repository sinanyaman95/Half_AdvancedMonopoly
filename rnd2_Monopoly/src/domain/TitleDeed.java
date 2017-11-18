package domain;

public class TitleDeed extends Square {
	

	public TitleDeed(String name,int priceVal,int rentVal,int mortgageVal) {
		
		super(name);
		buyBehavior=new BuyTitleDeed();
		owner=MonopolyGameController.bank;
		price=priceVal;
		rent=rentVal;
		mortgageValue=mortgageVal;
		
		
		
	}

}
