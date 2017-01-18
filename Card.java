
public class Card {
	private final String type;
	private final String paint;
	private final int strength;
	
	Card(String type, String paint, int strength){
		this.type = type;
		this.paint = paint;
		this.strength = strength;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getPaint(){
		return this.paint;
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public void printInfo(){
		System.out.println(this.type + " " + this.paint);
	}
}
