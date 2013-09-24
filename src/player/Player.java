package player;

public class Player extends PlayerService{
	private String username;
	private char[] guess;
	private int tries;
	//boolean attributes to check if guess is true?

	public Player(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public char[] getGuess() {
		return guess;
	}

	public void setGuess(char[] guess) {
		this.guess = guess;
	}

	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
}
