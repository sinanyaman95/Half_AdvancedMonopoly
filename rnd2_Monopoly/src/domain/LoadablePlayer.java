	package domain;

	import java.awt.List;
	import java.util.ArrayList;

	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	import domain.bot.JailObserver;
	import domain.bot.MonopolyBotObserver;
	import domain.squares.propertysquares.BuildingFacade;
	import domain.squares.propertysquares.PropertySquare;
	import domain.squares.propertysquares.TitleDeed;
	import domain.squares.propertysquares.Transportation;
	import domain.squares.propertysquares.Utility;
public class LoadablePlayer {

		@SerializedName("checkTurn")
		@Expose
		private boolean checkTurn;
		
		@SerializedName("Name")
		@Expose
		private String name;

		@SerializedName("Position")
		@Expose
		private int position=0;
		
		@SerializedName("Balance")
		@Expose
		private double balance;
		
		@SerializedName("Owned_Title_Deeds")
		@Expose
		ArrayList<String> ownedTitleDeeds=new ArrayList<String>();
		
		
		@SerializedName("Owned_Transportation")
		@Expose
		ArrayList<String> ownedTransportation=new ArrayList<String>();
		
		@SerializedName("Owned_Utility")
		@Expose
		ArrayList<String> ownedUtility=new ArrayList<String>();

		
		@SerializedName("isInJail")
		@Expose
		private boolean isInJail;
		
		
		@SerializedName("buildingFacade")
		@Expose
		public BuildingFacade buildingFacade;
		
		public ArrayList<MonopolyBotObserver> playerObservers=new ArrayList<MonopolyBotObserver>();
		
		public LoadablePlayer(String name, double balance) {
			this.name=name;
			this.balance=balance;
			setInJail(false);
		}
		public LoadablePlayer() {}
		
		public boolean isCheckTurn() {
			return checkTurn;
		}
		public void setCheckTurn(boolean checkTurn) {
			this.checkTurn = checkTurn;
		}
		
		public boolean isInJail() {
			return isInJail;
		}
		public void setInJail(boolean isInJail) {
			this.isInJail = isInJail;
		}
		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public ArrayList<String> getOwnedUtility() {
			return ownedUtility;
		}
		public void setOwnedUtility(ArrayList<String> ownedUtility) {
			this.ownedUtility = ownedUtility;
		}

		public ArrayList<String> getOwnedTitleDeeds() {
			return ownedTitleDeeds;
		}

		public void setOwnedTitleDeeds(ArrayList<String> ownedTitleDeeds) {
			this.ownedTitleDeeds = ownedTitleDeeds;
		}

		public LoadablePlayer withOwnedTitleDeeds(ArrayList<String> ownedTitleDeeds) {
			this.ownedTitleDeeds = ownedTitleDeeds;
			return this;
		}

		public ArrayList<String> getOwnedTransportation() {
			return ownedTransportation;
		}

		public void setOwnedTransportation(ArrayList<String> ownedTransportation) {
			this.ownedTransportation = ownedTransportation;
		}

		public LoadablePlayer withOwnedTransportation(ArrayList<String> ownedTransportation) {
			this.ownedTransportation = ownedTransportation;
			return this;
		}
		public void setName(String name) {
			this.name = name;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public String getName() {
			return name;
		}
	}

