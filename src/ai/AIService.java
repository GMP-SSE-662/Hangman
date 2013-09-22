package ai;

import java.util.ArrayList;
import java.util.Random;

import player.Player;

import dictionary.Dictionary;

public class AIService {
	protected String generateRandomWord() {
		ArrayList<String> dList = new Dictionary().getDictionary();
		return dList.get(new Random().nextInt(dList.size()));
	}

	protected void setPlayerTries(Player player, String word) {
		int tries = (int) (word.length() * .8);
		player.setTries(tries % 10);
	}

	public Boolean isLetterInWord(String answer, String letter) {
		char[] ltr = letter.toCharArray();
		char[] arrAns = answer.toCharArray();

		for (int x = 0; x < arrAns.length; x++) {
			if (ltr[0] == arrAns[x]) {
				return true;
			}
		}
		return false;
	}

	public Boolean isGuessCorrect(String answer, String guess) {
		return guess.equals(answer);
	}
}
