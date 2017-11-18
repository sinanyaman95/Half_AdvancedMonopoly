package domain;

public class Company extends Square {

	public Company(String name) {
		super(name);
		buyBehavior=new BuyCompany();
		// TODO Auto-generated constructor stub
	}

}
