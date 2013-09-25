package player;

import machine.Machine;

public class Player{
	private String username;
	private char[] guess;
	private String lettersGuessed;
	private int tries;

	public Player(String username) {
		this.username = username;
	}
	
	public String getStrGuess() {
		return lettersGuessed;
	}
	public void setStrGuess(String lettersGuessed) {
		this.lettersGuessed = lettersGuessed;
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
	
	/**
	 * Initialise Player Guess
	 */
	public void initGuess(Machine machine) {
		char[] arrGuess = new char[machine.getAnswer().length()];
		for (int x = 0; x < machine.getAnswer().length(); x++) {
			arrGuess[x] = 95;
		}
		setGuess(arrGuess);
	}
	
	/**
	 * Returns the letters guessed as String
	 */
	public String getLettersGuessed() {
		this.lettersGuessed = "";
		for (int x = 0; x < this.guess.length; x++) {
			if( x != this.guess.length - 1) {
				this.lettersGuessed += getGuess()[x] + " ";
			} else {
				this.lettersGuessed += getGuess()[x];
			}
			//this.lettersGuessed += getGuess()[x] + " ";
		}
//		return this.lettersGuessed.trim();
		return this.lettersGuessed;
	}
	
	
}
