package machine;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import dictionary.Dictionary;
import dictionary.DictionaryRepository;
import player.Player;

public class Machine {
	private String answer;
	private String lettersGuessed;
	private int difficulty;

	public Machine(Player player, int difficulty) throws IOException{
		setDifficulty(difficulty);
		this.answer = generateRandomWord();
		setPlayerTries(player, answer);
		player.initGuess(this);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Generate Random word from the hardcoded list
	 */
	private String generateRandomWord() throws IOException{
		if (getDifficulty() == 1) {
			List<String> dictionary = new Dictionary().getDictionary();
			return dictionary.get(new Random().nextInt(dictionary.size()));
		} else {
			List<String[]> dictionary = new DictionaryRepository().getDictionary();
			return dictionary.get(new Random().nextInt(dictionary.size()))[0];
		}
		
	}

	/**
	 * Set player tries based on the length of the word
	 */
	private void setPlayerTries(Player player, String word) {
		int tries = (int) (word.length() * .8);
		player.setTries(tries % 10);
	}
	
	/**
	 * Checks if players guessed letter is part of the word
	 */
	public Boolean isLetterInWord(Player player, String answer, String letter) {
		char ltr = letter.charAt(0);
		char[] arrAns = answer.toCharArray();
		boolean isInWord = false;

		for (int x = 0; x < arrAns.length; x++) {
			if (ltr == arrAns[x]) {
				player.getGuess()[x] = ltr;
				isInWord = true;
			}
		}
		return isInWord;
	}

	/**
	 * Checks if the word guessed is correct
	 */
	public Boolean isGuessCorrect(String answer, String guess) {
		return guess.equals(answer);
	}
	
	/**
	 * Displays letter guessed by the player
	 */
	public String displayLettersGuessed(Player player) {
		this.lettersGuessed = "";
		for (int x = 0; x < answer.length(); x++) {
			this.lettersGuessed += player.getGuess()[x] + " ";
		}
		return this.lettersGuessed.trim();
	}
}
