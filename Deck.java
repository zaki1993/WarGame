import java.util.Random;

public class Deck {
	private Card[] deck;
	private int cardNumber;
	public static final int MAX_CARDS = 52;

	Deck(){
		String[] types = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] paint = {"Spades", "Diamonds", "Hearts", "Clubs"};
		this.deck = new Card[Deck.MAX_CARDS];
		this.cardNumber = 0;
		int strength = 0;
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < paint.length; j++) {
				this.deck[this.cardNumber++] = new Card(types[i], paint[j], strength);
			}
			strength++;
		}
		shuffle();
	}
	
	public void shuffle(){
		for (int i = 0; i < this.cardNumber; i++) {
			int index = new Random().nextInt(Deck.MAX_CARDS);
			Card temp = this.deck[i];
			this.deck[i] = this.deck[index];
			this.deck[index] = temp;
		}
	}

	public void printDeck(){
		for (int i = 0; i < this.cardNumber; i++) {
			this.deck[i].printInfo();
		}
	}
	
	public Card getTopCard(){
		return this.deck[--this.cardNumber];
	}
}
