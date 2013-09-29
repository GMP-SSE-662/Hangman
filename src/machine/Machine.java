package machine;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import dictionary.Dictionary;
import dictionary.DictionaryRepository;
import player.Player;

public class Machine {
	private String answer;
	private String display;

	public Machine(Player player) throws IOException {
		setAnswerDifficulty(player);
		setPlayerTries(player, this.answer);
		player.initGuess(this);
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Set answer based on the difficulty chosen
	 */
	public void setAnswerDifficulty(Player player) throws IOException {
		switch (player.getDifficulty()) {
		case 1:
			this.answer = generateRandomEasy();
			break;
		case 2:
			this.answer = generateRandomNormal();
			break;
		}
	}

	/**
	 * Generates dictionary from hardcoded list
	 */
	private String generateRandomEasy() throws IOException {
		List<String> dictionary = new Dictionary().getDictionary();
		return dictionary.get(new Random().nextInt(dictionary.size()));
	}
	
	/**
	 * Generates dictionary from file
	 */
	private String generateRandomNormal() throws IOException {
		List<String[]> dictionary = new DictionaryRepository().getDictionary();
		return dictionary.get(new Random().nextInt(dictionary.size()))[0];
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
	public Boolean isGuessCorrect(Player player, String answer, String guess) {
		if (guess.equals(answer)) {
			player.setGuess(guess.toCharArray());
			player.setTries(0);
			return true;
		}
		return false;
	}
	
	/**
	 * Displays letter guessed by the player
	 */
	public String displayLettersGuessed(Player player) {
		this.display = "";
		for (int x = 0; x < answer.length(); x++) {
			this.display += player.getGuess()[x] + " ";
		}
		return this.display.trim();
	}
	
	/**
	 * Subtracts a try on mistake
	 */
	public void removeOneTry(Player player) {
		player.setTries(player.getTries() - 1);
	}
	
	/**
	 * Checks if game is over
	 */
	public boolean isGameOver(Player player, Machine machine) {
		return player.getTries() == 0 && !machine.isGuessCorrect(player, answer, player.getGuessAsString());
	}
}
