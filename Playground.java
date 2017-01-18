
public class Playground {
	private Deck deck;
	private Player[] players;
	private int currentPlayers;
	private boolean hasWar;
	
	private Card[] holdCards;
	private int cardsNumber;
	
	public Playground() {
		this.deck = new Deck();
		this.players = new Player[2];
		this.currentPlayers = 0;
		this.holdCards = new Card[Deck.MAX_CARDS];
		this.cardsNumber = 0;
		this.hasWar = false;
	}
	
	public void addPlayer(Player newPlayer){
		if(this.currentPlayers >= 2){
			return;
		}
		this.players[this.currentPlayers++] = newPlayer;
	}
	
	public void deal(){
		for (int i = 0; i < Deck.MAX_CARDS/2; i++) {
			this.players[0].addCard(this.deck.getTopCard());
			this.players[1].addCard(this.deck.getTopCard());
		}
	}
	
	public boolean checkForWar(){
		return this.holdCards[this.cardsNumber - 1].getStrength() == this.holdCards[this.cardsNumber - 2].getStrength();
	}
	
	public int compare(){
		if(this.holdCards[this.cardsNumber - 1].getStrength() < this.holdCards[this.cardsNumber - 2].getStrength()){
			return 1;
		}
		return -1;
	}
	
	public void play(){
		deal();
		run();
	}
	
	public void clearField(){
		int cmp = compare();
			if(cmp == 1){
				for (int i = 0; i < this.holdCards.length; i++) {
					this.players[1].winCard(this.holdCards[i]);
					this.holdCards[i] = null;
				}
			}
			else{
				for (int i = 0; i < this.holdCards.length; i++) {
					this.players[0].winCard(this.holdCards[i]);
					this.holdCards[i] = null;
				}
			}
			this.hasWar = false;
			this.cardsNumber = 0;
	}
	
	public void printWon(){
		Card player1 = players[0].getTopCard();
		Card player2 = players[1].getTopCard();
		if(player1 == null && player2 == null){
			int res = compare();
			if(res == 1){
				System.out.println("Player 1 won!");
			}
			else{
				System.out.println("Player 2 won!");
			}
		}
		if(player1.getStrength() < player2.getStrength()){
			System.out.println("Player 1 won!");
		}
		else if(player1.getStrength() > player2.getStrength()){
			System.out.println("Player 0 won!");
		}
		else{
			if(players[0].getTopCard() == null){
				System.out.println("Player 1 won!");
			}
			else{
				System.out.println("Player 0 won!");
			}
		}
	}
	
	public void run(){
		if(players[0].hasOneCard() || players[1].hasOneCard()){
			printWon();
			return;
		}
		this.holdCards[this.cardsNumber++] = this.players[0].getTopCard();
		this.holdCards[this.cardsNumber++] = this.players[1].getTopCard();
		if(checkForWar()){
			if(this.players[0].hasOneCard() || this.players[1].hasOneCard()){
				printWon();
				return;
			}
			if(!hasWar){
				this.holdCards[this.cardsNumber++] = this.players[0].getTopCard();
				this.holdCards[this.cardsNumber++] = this.players[1].getTopCard();
				clearField();
			}
			else{
				this.hasWar = true;
				for (int i = 0; i < 3; i++) {
					this.holdCards[this.cardsNumber++] = this.players[0].getTopCard();
					this.holdCards[this.cardsNumber++] = this.players[1].getTopCard();
				}
			}
		}
		else{
			clearField();
		}
		run();
	}
	
	public void reset(){
		this.deck = new Deck();
		this.cardsNumber = 0;
		this.hasWar = false;
	}
}
