
public class Demo {

	public static void main(String[] args) {
		Playground war = new Playground();
		Player zaki = new Player();
		Player gosho = new Player();
		war.addPlayer(zaki);
		war.addPlayer(gosho);
		for(int i = 0;i<100;i++){
			war.play();
			war.reset();
		}
	}

}
