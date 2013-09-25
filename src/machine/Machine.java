package machine;

import java.util.List;
import java.util.Random;

import dictionary.Dictionary;
import player.Player;

public class Machine {
	private String answer;

	public Machine(Player player) {
		this.answer = generateRandomWord();
		setPlayerTries(player, answer);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	private String generateRandomWord() {
		List<String> dList = new Dictionary().getDictionary();
		return dList.get(new Random().nextInt(dList.size()));
	}

	private void setPlayerTries(Player player, String word) {
		int tries = (int) (word.length() * .8);
		player.setTries(tries % 10);
	}
	
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

	public Boolean isGuessCorrect(String answer, String guess) {
		return guess.equals(answer);
	}
}
