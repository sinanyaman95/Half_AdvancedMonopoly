package domain.squares;

/**
 * @author rnd2
 * @overview Interface created for determining which squares are buyable or not
 *
 */
public interface BuyableBehavior {
	void buyProperty(Square s);
	boolean getBuyableType();
}
