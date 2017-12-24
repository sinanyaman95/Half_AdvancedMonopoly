package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import domain.bot.IdleObserver;
import domain.bot.JailObserver;
import domain.bot.MonopolyBot;
import domain.bot.MonopolyBotObserver;
import domain.bot.NeutralObserver;
import domain.cards.ChanceCard;
import domain.cards.CommunityChestCard;
import domain.cards.TravelVoucherCard;
import domain.cards.chancecards.AdvanceToThePayCorner;
import domain.cards.chancecards.GoToJailCard;
import domain.cards.chancecards.HurricaneMakesLandfall;
import domain.cards.chancecards.MakeGeneralRepairsToAllYourProperties;
import domain.cards.communitychestcards.BankErrorInYourFavor;
import domain.cards.communitychestcards.InsurancePremiumsDue;
import domain.cards.communitychestcards.YouAreGettingMarried;
import domain.squares.Square;
import domain.squares.actionsquares.*;
import domain.squares.propertysquares.*;
import domain.squares.actionsquares.taxes.*;

import gui.MonopolyBoard;
import gui.StartingScreen;


public class MonopolyGameController {

	//private static MonopolyGameController instance = new MonopolyGameController(); causes errors, we already create it elsewhere

	private static StartingScreen startingScreen;

	public static ArrayList<Player> players = new ArrayList<Player>();

	public static Square[] squareList = new Square[120];	 

	public static  Player bank=new Player("Bank", 999999999);

	public static RegularDice die1 = new RegularDice();

	public static RegularDice die2 = new RegularDice();

	public static SpeedDie die3= new SpeedDie();

	public static ArrayList<CommunityChestCard> communityDeck = new ArrayList<CommunityChestCard>();

	public static ArrayList<ChanceCard> chanceCardDeck = new ArrayList<ChanceCard>();
	
	public static ArrayList<TravelVoucherCard> travelCardDeck = new ArrayList<TravelVoucherCard>();
	
	public static Timer idleTimer;
	public static Timer jailTimer;
	public static Timer emotionTimer;

	public static MonopolyBot gamebot = new MonopolyBot();

	public static NeutralObserver neutralObserver = new NeutralObserver();
	public static IdleObserver idleObserver = new IdleObserver();
	public static JailObserver jailObserver = new JailObserver();
	
	public static double poolMoney=0;

	public static double bidAmount = 0;


	int idleTime = 30000; // 30 seconds
	int jailTime = 1000;
	int emotionTime = 5000;//might change it later


	public MonopolyGameController() {

		// add idle observer to game, jail observer to every player

		for (int i = 0; i < players.size(); i++) {
			new JailObserver(players.get(i));
		}
		
		generateCards();
	
		ActionListener idleTask = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				idleObserver.update();

			}
		};

		
		ActionListener jailTask = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				for (int i = 0; i < players.size(); i++) {
					if(players.get(i).isInJail()) {
						jailObserver.update();
					}
				}

			}
		};
		
		ActionListener emotionTask = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//print bot's current emotion in every 5 seconds
			System.out.println(gamebot.emotion);

			}
		};

		jailTimer = new Timer(jailTime, jailTask);
		idleTimer = new Timer(idleTime, idleTask);
		emotionTimer = new Timer(emotionTime, emotionTask);
		jailTimer.start();
		idleTimer.start();
		emotionTimer.start();

		initBoard();
	
	}


	//public static MonopolyGameController getInstance() {
	//	return instance;
	//}

	//public static void setInstance(MonopolyGameController instance) {
	//	MonopolyGameController.instance = instance;
	//	}

	public static void initBoard() {


		squareList[0] = new GoSquare(0);
		TitleDeed MediterraneanAve = new TitleDeed(1, "Mediterranean Avenue", "purple", 60, 2,30, 0,0,0,50);
		MediterraneanAve.addTaxList(10, 30, 90, 160, 250, 750);
		squareList[1] = MediterraneanAve;
		squareList[2] = new CommunityChest(2, communityDeck);

		TitleDeed BalticAve = new TitleDeed(3, "Baltic Avenue", "purple", 60, 4,30,0,0,0,50);
		BalticAve.addTaxList(20, 60, 180, 320, 450, 950);
		squareList[3] = BalticAve;

		squareList[4] = new IncomeTax(4);
		squareList[5] = new TransitStation(5, 47, "Reading");

		TitleDeed OrientalAve = new TitleDeed(6, "Oriental Avenue", "light Blue", 100, 6, 50,0,0,0,50);
		OrientalAve.addTaxList(30, 90, 270, 400, 550, 1050);
		squareList[6] = OrientalAve;

		squareList[7] = new Chance(7, chanceCardDeck);

		TitleDeed VermontAve = new TitleDeed(8, "Vermont Avenue", "light Blue", 100, 6,50,0,0,0,50);
		VermontAve.addTaxList(30, 90, 270, 400, 550, 1050);
		squareList[8] = VermontAve;

		TitleDeed ConnecticutAve = new TitleDeed(9, "Connecticut Avenue", "light Blue", 100, 8, 50,0,0,0,50);
		ConnecticutAve.addTaxList(30, 90, 270, 400, 550, 1050);
		squareList[9] = ConnecticutAve;

		squareList[10] = new Jail(10);

		TitleDeed CharlesPlace = new TitleDeed(11, "St. Charles Place", "pink", 140, 10, 70,0,0,0,100);
		CharlesPlace.addTaxList(50, 150, 450, 625, 750, 1250);
		squareList[11] = CharlesPlace;

		squareList[12] = new Utility(12, "Electric Company");

		TitleDeed StatesAve = new TitleDeed(13, "States Avenue", "pink", 140, 10, 70,0,0,0,100);
		StatesAve.addTaxList(50, 150, 450, 625, 750, 1250);
		squareList[13] = StatesAve;

		TitleDeed VirginiaAve = new TitleDeed(14, "Virginia Avenue", "pink", 160, 12,80,0,0,0,100);
		VirginiaAve.addTaxList(60, 180, 500, 700, 900,1400);
		squareList[14] = VirginiaAve;

		squareList[15] = new TransitStation(15, 105, "Pennsylvania");

		TitleDeed JamesPlace = new TitleDeed(16, "St. James Place", "orange", 180, 14, 90,0,0,0,100);
		JamesPlace.addTaxList(70, 200, 550, 750, 950, 1450);
		squareList[16] = JamesPlace;

		squareList[17] = new CommunityChest(17, communityDeck);

		TitleDeed TennesseeAve = new TitleDeed(18, "Tennessee Avenue", "orange", 180, 14,90,0,0,0,100);
		TennesseeAve.addTaxList(70, 200, 550, 750, 950, 1450);        
		squareList[18] = TennesseeAve;

		TitleDeed NewYorkAve = new TitleDeed(19, "New York Avenue", "orange", 200, 16,100,0,0,0,100);
		NewYorkAve.addTaxList(80, 220, 600, 800, 1000,1500);
		squareList[19] = NewYorkAve;

		squareList[20] = new FreeParking(20);

		TitleDeed KentuckyAve = new TitleDeed(21, "Kentucky Avenue", "red", 220, 18,100,0,0,0,150);
		KentuckyAve.addTaxList(90, 250, 700, 875, 1050,2050);
		squareList[21] = KentuckyAve;

		squareList[22] = new Chance(22, chanceCardDeck);

		TitleDeed IndianaAve= new TitleDeed(23, "Indiana Avenue", "red", 220, 18,110,0,0,0,150);
		IndianaAve.addTaxList(90, 250, 700, 875, 1050, 2050);
		squareList[23] = IndianaAve;

		TitleDeed IllinoisAve = new TitleDeed(24, "Illinois Avenue", "red", 240, 20,120,0,0,0,150);
		IllinoisAve.addTaxList(100, 300, 750, 925, 1100,2100);
		squareList[24] = IllinoisAve;

		squareList[25] = new TransitStation(25, 75, "Short Line");

		TitleDeed AtlanticAve = new TitleDeed(26, "Atlantic Avenue", "yellow", 260, 22,130,0,0,0,150);
		AtlanticAve.addTaxList(110, 330, 800, 975, 1050,2150);
		squareList[26] = AtlanticAve;

		TitleDeed VentnorAve = new TitleDeed(27, "Ventnor Avenue", "yellow", 260, 22,130,0,0,0,150);
		VentnorAve.addTaxList(110, 330, 800, 975, 1050,2150);
		squareList[27] = VentnorAve;

		squareList[28] = new Utility(28, "Water Works");

		TitleDeed MarvinGardens = new TitleDeed(29, "Marvin Gardens", "yellow", 280, 22,140,0,0,0,150);
		MarvinGardens.addTaxList(120, 360, 850, 1025, 1200,2200);
		squareList[29] = MarvinGardens;

		squareList[30] = new RollThree(30);

		TitleDeed PacificAve = new TitleDeed(31, "Pacific Avenue", "green", 300, 26,150,0,0,0,200);
		PacificAve.addTaxList(130, 390, 900, 1100, 1275,2275);
		squareList[31] = PacificAve;

		TitleDeed NorthCarolinaAve = new TitleDeed(32, "North Carolina Avenue", "green", 300, 26,150,0,0,0,200);
		NorthCarolinaAve.addTaxList(130, 390, 900, 1100, 1275,2275);
		squareList[32] = NorthCarolinaAve;

		squareList[33] = new CommunityChest(33, communityDeck);

		TitleDeed PennsylvaniaAve = new TitleDeed(34, "Pennsylvania Avenue", "green", 320, 28,160,0,0,0,200);
		PennsylvaniaAve.addTaxList(150, 450, 1000, 1200,1400, 2400);
		squareList[34] = PennsylvaniaAve;

		squareList[35] = new TransitStation(35, 117, "B&O");

		squareList[36] = new Chance(36, chanceCardDeck);

		TitleDeed ParkPlace = new TitleDeed(37, "Park Place", "blue", 350, 35,175,0,0,0,200);
		ParkPlace.addTaxList(175, 500, 1100, 1300, 1500, 2500);
		squareList[37] = ParkPlace;

		squareList[38] = new LuxuryTax(38);

		TitleDeed Boardwalk =  new TitleDeed(39, "Boardwalk", "blue", 400, 50,200,0,0,0,200);
		Boardwalk.addTaxList(200, 600, 1400, 1700, 2000, 3000);
		squareList[39] = Boardwalk;

		squareList[40] = new Subway(40);

		TitleDeed LakeStreet = new TitleDeed(41, "Lake Street", "light Pink", 30, 1,15,0,0,0,50);
		LakeStreet.addTaxList(5, 15, 45, 80, 125, 62);
		squareList[41] = LakeStreet;

		squareList[42] = new CommunityChest(42, communityDeck);

		TitleDeed NicolletAve = new TitleDeed(43, "Nicollet Avenue", "light Pink", 30, 1,15,0,0,0,50);
		NicolletAve.addTaxList(5, 15, 45, 80, 125, 625);
		squareList[43] = NicolletAve;

		TitleDeed HennepinAve = new TitleDeed(44, "Hennepin Avenue", "light Pink", 60, 3,30,0,0,0,50);
		HennepinAve.addTaxList(15, 45, 120, 240, 350,850);
		squareList[44] = HennepinAve;

		squareList[45] = new BusTicket(45);
		squareList[46] = new CabCompany(46, "Checker");
		squareList[47] = new TransitStation(47, 5, "Reading");

		TitleDeed EsplanadeAve = new TitleDeed(48, "Esplanade Avenue", "light Green", 90, 5,50,0,0,0,50);
		EsplanadeAve.addTaxList(25, 80, 225, 360, 600,1000);
		squareList[48] = EsplanadeAve;

		TitleDeed CanalStreet = new TitleDeed(49, "Canal Street", "light Green", 90, 5, 50,0,0,0,50);
		CanalStreet.addTaxList(25, 80, 225, 360, 600,1000);
		squareList[49] = CanalStreet;

		squareList[50] = new Chance(50, chanceCardDeck);
		squareList[51] = new Utility(51, "Cable Company");

		TitleDeed MagazineStreet= new TitleDeed(52, "Magazine Street", "light Green", 120, 8,60,0,0,0,50);
		MagazineStreet.addTaxList(40, 100, 300, 450, 600,1100);
		squareList[52] = MagazineStreet;

		TitleDeed BourbonStreet = new TitleDeed(53, "Bourbon Street", "light Green", 120, 8,60,0,0,0,50);
		BourbonStreet.addTaxList(40, 100, 300, 450, 600,1100);
		squareList[53] = BourbonStreet;

		squareList[54] = new HollandTunnel(54, 114);
		squareList[55] = new Auction(55);

		TitleDeed KatyFreeway= new TitleDeed(56, "Katy Freeway", "light Yellow", 150, 11,70,0,0,0,100);
		KatyFreeway.addTaxList(55, 160, 475, 650, 800,1300);
		squareList[56] = KatyFreeway;

		TitleDeed WestheimerRoad= new TitleDeed(57, "Westheimer Road", "light Yellow", 150, 11,70,0,0,0,100);
		WestheimerRoad.addTaxList(55, 160, 475, 650,800,1300);
		squareList[57] = WestheimerRoad;

		squareList[58] = new Utility(58, "Internet Service Provider");

		TitleDeed KirbyDrive = new TitleDeed(59, "Kirby Drive", "light Yellow", 180, 14,80,0,0,0,100);
		KirbyDrive.addTaxList(70, 200, 550, 750, 950, 1450);
		squareList[59] = KirbyDrive;

		TitleDeed CullenBouleward =  new TitleDeed(60, "Cullen Bouleward", "light Yellow", 180, 14,80,0,0,0,100);
		CullenBouleward.addTaxList(70, 200, 550, 750, 950, 1450);
		squareList[60] = CullenBouleward;

		squareList[61] = new Chance(61, chanceCardDeck);
		squareList[62] = new CabCompany(62, "Black and White");

		TitleDeed DeklabAve = new TitleDeed(63, "Deklab Avenue", "ocean Green", 210, 17,90,0,0,0,100);
		DeklabAve.addTaxList(85, 240, 670, 840, 1025,1525);
		squareList[63] = DeklabAve;

		squareList[64] = new CommunityChest(64,communityDeck);

		TitleDeed AndrewBoulevard = new TitleDeed(65, "Andrew Young Itnl Boulevard", "ocean Green", 210, 17,90,0,0,0,100);
		AndrewBoulevard.addTaxList(85, 240,670, 840, 1025, 1525);
		squareList[65] = AndrewBoulevard;

		TitleDeed DecaturStreet = new TitleDeed(66, "Decatur Street", "ocean Green", 240, 20,100,0,0,0,100);
		DecaturStreet.addTaxList(100, 300, 750, 925,1100, 1600);
		squareList[66] = DecaturStreet;

		TitleDeed PeachtreeStreet = new TitleDeed(67, "Peachtree Street", "ocean Green", 240, 20,100,0,0,0,100);
		PeachtreeStreet.addTaxList(100, 300, 750, 925,1100, 1600);
		squareList[67] = PeachtreeStreet;

		squareList[68] = new PayDay(68);

		TitleDeed RandolphStreet = new TitleDeed(69, "Randolph Street", "magenta", 270, 23,110,0,0,0,150);
		RandolphStreet.addTaxList(115, 345, 825, 1010,1180, 2180);
		squareList[69] = RandolphStreet;

		squareList[70] = new Chance(70, chanceCardDeck);

		TitleDeed LakeShore = new TitleDeed(71, "Lake Shore Drive", "magenta", 270, 23,110,0,0,0,150);
		LakeShore.addTaxList(115, 345, 825, 1010,1180, 2180);
		squareList[71] = LakeShore;

		TitleDeed WeckerDrive = new TitleDeed(72, "Wacker Drive", "magenta", 300, 26, 120,0,0,0,150); 
		WeckerDrive.addTaxList(130, 390, 900, 1100, 1275,2275);
		squareList[72] = WeckerDrive;

		TitleDeed MichiganAve = new TitleDeed(73, "Michigan Avenue", "magenta", 300, 26,120,0,0,0,150);
		MichiganAve.addTaxList(130, 390, 900, 1100,1275, 2275);
		squareList[73] = MichiganAve;

		squareList[74] = new CabCompany(74, "Yellow");
		squareList[75] = new TransitStation(75, 25, "Short Line");
		squareList[76] = new CommunityChest(76, communityDeck);

		TitleDeed SouthTemple = new TitleDeed(77, "South Temple", "gold", 330, 32,130,0,0,0,200);
		SouthTemple.addTaxList(160, 470, 1050, 2250, 1500,2500);
		squareList[77] = SouthTemple;

		TitleDeed WestTemple = new TitleDeed(78, "West Temple", "gold", 330, 32, 130,0,0,0,200);
		WestTemple.addTaxList(160, 470, 1500, 1250, 1500,2500);
		squareList[78] = WestTemple;

		squareList[79] = new Utility(79, "Trash Collector");

		TitleDeed NorthTemple = new TitleDeed(80, "North Temple", "gold", 360, 38, 140,0,0,0,200);
		NorthTemple.addTaxList(170, 520, 1125, 1275, 1425,1650);
		squareList[80] = NorthTemple;

		TitleDeed TempleSquare = new TitleDeed(81, "Temple Square", "gold", 360, 38,140,0,0,0,200);
		TempleSquare.addTaxList(170, 520, 1125, 1275, 1425,1650);
		squareList[81] = TempleSquare;

		squareList[82] = new GoToJail(82);

		TitleDeed SouthStreet = new TitleDeed(83, "South Street", "light Red", 390, 45,150,0,0,0,250);
		SouthStreet.addTaxList(210, 575, 1300, 1600, 1800,3300);
		squareList[83] = SouthStreet;

		TitleDeed BroadStreet = new TitleDeed(84, "Broad Street", "light Red", 390, 45, 150,0,0,0,250);
		BroadStreet.addTaxList(210, 575, 1300, 1600, 1800,3300);
		squareList[84] = BroadStreet;

		TitleDeed WalnutStreet = new TitleDeed(85, "Walnut Street", "light Red", 420, 55, 160,0,0,0,250);
		WalnutStreet.addTaxList(225, 630, 1450, 1750,2050, 3550);
		squareList[85] = WalnutStreet;

		squareList[86] = new CommunityChest(86, communityDeck);

		TitleDeed MarketStreet = new TitleDeed(87, "Market Street", "light Red", 420, 55,160,0,0,0,250);
		MarketStreet.addTaxList(225, 630, 1450, 1750,2050, 3550);
		squareList[87] = MarketStreet;

		squareList[88] = new BusTicket(88);
		squareList[89] = new Utility(89, "Sewage System");
		squareList[90] = new CabCompany(90, "Ute");
		squareList[91] = new BirthdayGift(91);

		TitleDeed MulhollandDrive = new TitleDeed(92, "Mulholland Drive", "dark Red", 450, 70,175,0,0,0,300);
		MulhollandDrive.addTaxList(350, 750, 1600, 1850,2100, 3600);
		squareList[92] = MulhollandDrive;

		TitleDeed VenturaBoulevard = new TitleDeed(93, "Ventura Boulevard", "dark Red", 480, 80,200,0,0,0,300);
		VenturaBoulevard.addTaxList(400, 825, 1800, 2175,2550, 4050);
		squareList[93] = VenturaBoulevard;

		squareList[94] = new Chance(94, chanceCardDeck);

		TitleDeed RodeoDrive = new TitleDeed(95, "Rodeo Drive", "dark Red", 510, 90,250,0,0,0,300);
		RodeoDrive.addTaxList(450, 900, 2000, 2500, 3000, 4500);
		squareList[95] = RodeoDrive;

		squareList[96] = new SqueezePlay(96);

		TitleDeed TheEmbarcadero = new TitleDeed(97, "The Embarcadero", "white", 210, 17, 105,0,0,0,100);
		TheEmbarcadero.addTaxList(85, 240, 475, 670, 1025, 1525);
		squareList[97] = TheEmbarcadero;

		TitleDeed FishermansWharf = new TitleDeed(98, "Fisherman's Wharf", "white", 250, 21,125,0,0,0,100);
		FishermansWharf.addTaxList(105, 320, 780, 950, 1125,1625);
		squareList[98] = FishermansWharf;

		squareList[99] = new Utility(99, "Telephone Company");
		squareList[100] = new CommunityChest(100, communityDeck);

		TitleDeed BeaconStreet = new TitleDeed(101, "Beacon Street", "black", 330, 30,265,0,0,0,200);
		BeaconStreet.addTaxList(160, 470, 1050, 1250, 1500,2500);
		squareList[101] = BeaconStreet;

		squareList[102] = new BonusSquare(102);

		TitleDeed BolysonStreet = new TitleDeed(103, "Boylston Street", "black", 330, 30,165,0,0,0,200);
		BolysonStreet.addTaxList(160, 470, 1050, 1250,1500,2500);
		squareList[103] = BolysonStreet;

		TitleDeed NewBurlyStreet = new TitleDeed(104, "NewBurly Street", "black", 380, 40,190,0,0,0,200);
		NewBurlyStreet.addTaxList(185, 550, 1200, 1500,1700, 2700);
		squareList[104] = NewBurlyStreet;


		squareList[105] = new TransitStation(105, 15, "Pennsylvania");

		TitleDeed FifthAve = new TitleDeed(106, "Fifth Avenue", "grey", 430, 60,215,0,0,0,300);
		FifthAve.addTaxList(220, 650, 1500, 1800, 2100,3600);
		squareList[106] = FifthAve;

		TitleDeed MadisonAve = new TitleDeed(107, "Madison Avenue", "grey", 430, 60,215,0,0,0,300);
		MadisonAve.addTaxList(220, 650, 1500, 1800, 2100,3600);
		squareList[107] = MadisonAve;

		squareList[108] = new StockExchange(108);

		TitleDeed WallStreet = new TitleDeed(109, "Wall Street", "grey", 500, 80,250,0,0,0,300);
		WallStreet.addTaxList(300, 800, 1800, 2200, 2700,4200);
		squareList[109] = WallStreet;

		squareList[110] = new TaxRefund(110);
		squareList[111] = new Utility(111, "Gas Company");
		squareList[112] = new Chance(112, chanceCardDeck);

		TitleDeed FloridaAve = new TitleDeed(113, "Florida Avenue", "brown", 130, 9,65,0,0,0,50);
		FloridaAve.addTaxList(45, 120, 350, 500, 700, 1200);
		squareList[113] = FloridaAve;

		squareList[114] = new HollandTunnel(114, 54);

		TitleDeed MiamiAve = new TitleDeed(115, "Miami Avenue", "brown", 130, 9,65,0,0,0,50);
		MiamiAve.addTaxList(45, 120, 320, 500, 700, 1200);
		squareList[115] = MiamiAve;

		TitleDeed BiscayneAve = new TitleDeed(116, "Biscayne Avenue", "brown", 150, 11, 75,0,0,0,50);
		BiscayneAve.addTaxList(55, 160, 475, 650, 800,1300);
		squareList[116] = BiscayneAve;

		squareList[117] = new TransitStation(117, 35, "B&O");
		squareList[118] = new ReverseDirection(118);

		TitleDeed LombardStreet = new TitleDeed(119, "Lombard Street", "white", 210, 17,105,0,0,0,100);
		LombardStreet.addTaxList(85, 240, 475, 670, 1025, 1525);
		squareList[119] = LombardStreet;

	}


	public static  void initPlayers() {
		//players.add(bank);
	}

	/**
	 * 
	 * @effects walks in the player list and checks which player is the current one
	 * @return the current player
	 */
	public static Player getCurrentPlayer() {
		for(Player p: players) {
			if(p.isCheckTurn()) {
				return p;
			}
		}
		return null;

	}

	/**
	 * @effects changes the balance of the current player
	 * @param rentAmount
	 */
	public static void payRent(TitleDeed deed,double rentAmount) {
		double currentBalance = getCurrentPlayer().getBalance();
		System.out.println("Current Balance: " + currentBalance);
		getCurrentPlayer().setBalance(currentBalance-rentAmount);
		System.out.println("After paying rent : " +getCurrentPlayer().getBalance());
		System.out.println("Owner's balance : "+ deed.getOwner().getBalance());
		deed.getOwner().setBalance(deed.getOwner().getBalance()+rentAmount);
		System.out.println("Owner's balance after rent : "+deed.getOwner().getBalance());
	}

	/**
	 * @effects saves the game in a json file
	 * @return
	 */
	public static boolean SaveGame() {

		JSONObject object = new JSONObject();
		JSONArray players_array = new JSONArray();
		for(Player p: players) {
			JSONObject player = new JSONObject();
			JSONArray ownedDeeds = new JSONArray();
			JSONArray ownedCompanies = new JSONArray();
			for(TitleDeed t: p.getOwnedTitleDeeds()) {
				ownedDeeds.add(t.getName());
			}
			for(Transportation c: p.ownedTransportation) {
				ownedCompanies.add(c.getName());
			}
			player.put("Name", p.getName());
			player.put("Balance", p.getBalance());
			player.put("Owned_Title_Deeds",ownedDeeds);
			player.put("Owned_Transportation", ownedCompanies);
			player.put("Position", p.getPosition());
			player.put("checkTurn", p.isCheckTurn());
			player.put("isInJail", p.isInJail());
			players_array.add(player);
		}
		object.put("players", players_array);

		try {
			File dir = new File("GameSaveFiles");
			dir.mkdirs();
			File tmp = new File(dir,"MonopolySaveJSON3.json");
			tmp.createNewFile();

			/*
			URL path = this.getClass().getResource("/pics/MonopolySaveJSON2.json");
			File file=new File(path.getFile());
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			 */
			FileWriter fileWriter = new FileWriter(tmp);
			System.out.println("Writing JSON object to file");
			fileWriter.write(object.toString());
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * requires a game which was previously saved must be in the json file
	 * @effects loads the game from the json file
	 * @return
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static boolean LoadGame() throws ParseException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Gson gs = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("GameSaveFiles/MonopolySaveJSON3.json")));
			PlayerMapper player = gs.fromJson(br, PlayerMapper.class);
			if(player != null) {
				int i=1;
				for(LoadablePlayer p: player.getPlayers()) {
					if(p != null) {
						Player tempPlayer = loadableToPlayer(p);
						players.add(tempPlayer);
						i++;
					}
				}
				initPlayers();
			}

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
					return true;
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}
	public static void resetTheGame() {
		players = new ArrayList<Player>();
		initBoard();
	}

	public static void move(int rolledDice) {
		Player currentPlayer= MonopolyGameController.getCurrentPlayer();
		int nextLocation = currentPlayer.getPosition() + 1;

		for (int i = 0; i < rolledDice; i++) {


			//  transit stationlarin yer degistirmesi  
			if (rolledDice % 2 == 0) {
				if (nextLocation == 5)
					nextLocation = 47;
				else if (nextLocation == 15)
					nextLocation = 105;
				else if (nextLocation == 25)
					nextLocation = 75;
				else if (nextLocation == 35)
					nextLocation = 117;
				else if (nextLocation == 47)
					nextLocation = 5;
				else if (nextLocation == 105)
					nextLocation = 15;
				else if (nextLocation == 75)
					i = 25;
				else if (nextLocation == 117)
					nextLocation = 35;
			}

			//  kutu icinde restart
			if (nextLocation == 40)
				nextLocation = 0; 
			else if (nextLocation == 120)
				nextLocation = 97;
			else if (nextLocation == 96)
				nextLocation = 40;

			//bonustan gecme
			if (nextLocation == 103) { 
				currentPlayer.setBalance(currentPlayer.getBalance()+250);

			}

			// start parasi
			if (nextLocation == 0) { 
				currentPlayer.setBalance(currentPlayer.getBalance()+200);
			}

			//payday paras� tek cift ayri
			if (nextLocation == 68) { 
				if (rolledDice % 2 == 0) {
					currentPlayer.setBalance(currentPlayer.getBalance()+400);
				} else {
					currentPlayer.setBalance(currentPlayer.getBalance()+300);
				}
			}

			//bonustan gecme
			if (nextLocation == 103) { 
				currentPlayer.setBalance(currentPlayer.getBalance()+250);

			}
			nextLocation++;

		}

		currentPlayer.setPosition(nextLocation-1);


		if(MonopolyGameController.squareList[currentPlayer.getPosition()] instanceof PropertySquare || MonopolyGameController.squareList[currentPlayer.getPosition()] instanceof CommunityChest || MonopolyGameController.squareList[currentPlayer.getPosition()] instanceof Chance ) {
			// ekranda baslayacak

		}else{
			((ActionSquare) MonopolyGameController.squareList[currentPlayer.getPosition()]).landedOn(currentPlayer);

		}



	}

	public static Player loadableToPlayer(LoadablePlayer lp) {
		Player tempPlayer = new Player(lp.getName(),lp.getBalance());
		ArrayList<TitleDeed> title = new ArrayList<TitleDeed>();
		ArrayList<Utility> util = new ArrayList<Utility>();
		ArrayList<Transportation> trans = new ArrayList<Transportation>();
		for(String title_name: lp.ownedTitleDeeds) {
			for(Square s: squareList) {
				if(s.getName().equalsIgnoreCase(title_name)) {
					title.add((TitleDeed) s);
					System.out.println(s.getName());
					break;
				}
			}
		}
		for(String trans_name: lp.ownedTransportation) {
			for(Square s: squareList) {
				if(s.getName().equalsIgnoreCase(trans_name)) {
					trans.add((Transportation) s);
					System.out.println(s.getName());
					break;
				}
			}
		}
		for(String util_name: lp.ownedUtility) {
			for(Square s: squareList) {
				if(s.getName().equalsIgnoreCase(util_name)) {
					util.add((Utility) s);
					System.out.println(s.getName());
					break;
				}
			}
		}
		tempPlayer.setPosition(lp.getPosition());
		tempPlayer.setCheckTurn(lp.isCheckTurn());
		tempPlayer.setInJail(lp.isInJail());
		tempPlayer.setOwnedTitleDeeds(title);
		tempPlayer.setOwnedTransportation(trans);
		tempPlayer.setOwnedUtility(util);
		
		return tempPlayer;
	}
	
	public static double getPoolMoney() {
		return poolMoney;
	}

	public static void setPoolMoney(double poolMoney) {
		MonopolyGameController.poolMoney = poolMoney;
	}
	
	public static TravelVoucherCard drawTravelCard() {
		Random rand = new Random();
		int cardindex =rand.nextInt(3);
		return MonopolyGameController.travelCardDeck.get(cardindex);
	}
	public static void generateCards() {
		CommunityChestCard youAreGettingMaried = new YouAreGettingMarried(true);
		CommunityChestCard bankError = new BankErrorInYourFavor(true);
		CommunityChestCard insurancePremium = new InsurancePremiumsDue(true);
		ChanceCard hurricaneCard = new HurricaneMakesLandfall(true);
		ChanceCard makeGeneralRepairs = new MakeGeneralRepairsToAllYourProperties(true);
		ChanceCard advanceToPayCorner = new AdvanceToThePayCorner(true);
		ChanceCard goToJail = new GoToJailCard(true);
	}

}
