package player;

public class Player {
	private String username;
	private int tries;

	public Player(String username) {
		this.username = username;
	}
	
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
}
