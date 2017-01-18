
public class Player {
	private static int id = 0;
	private Card[] hand;
	private Card[] wonCards;
	private int handCardNumber;
	private int wonCardNumber;
	
	Player(){
		if(Player.id >= 2){
			return; // set max players to 2
		}
		Player.id++;
		this.hand = new Card[Deck.MAX_CARDS/2];
		this.wonCards = new Card[Deck.MAX_CARDS];
		this.handCardNumber = 0;
		this.wonCardNumber = 0;
	}
	
	public void addCard(Card newCard){
		if(this.handCardNumber == Deck.MAX_CARDS/2){
			return;
		}
		this.hand[this.handCardNumber++] = newCard;
	}
	
	public void winCard(Card wonCard){
		if(this.wonCardNumber == Deck.MAX_CARDS){
			return;
		}
		this.wonCards[this.wonCardNumber++] = wonCard;
	}
	
	public Card getTopCard(){
		if(this.handCardNumber == 0){
			return null;
		}
		Card tmp = this.hand[this.handCardNumber - 1];
		this.hand[this.handCardNumber - 1] = null;
		this.handCardNumber--;
		return tmp;
	}
	
	public void moveToHand(){
		if(this.handCardNumber == 0){
			return;
		}
		for (int i = 0; i < Deck.MAX_CARDS/2; i++) {
			this.hand[this.handCardNumber++] = this.wonCards[this.wonCardNumber];
			this.wonCards[this.wonCardNumber--] = null;
		}
	}
	
	public boolean hasOneCard(){
		return this.handCardNumber <= 1;
	}
}
