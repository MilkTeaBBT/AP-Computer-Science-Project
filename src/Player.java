import java.util.ArrayList;

public class Player
{
	private Deck d;
	private ArrayList<Card> hand, graveyard;
	public Player()
	{
		d = new Deck();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
	}
}
