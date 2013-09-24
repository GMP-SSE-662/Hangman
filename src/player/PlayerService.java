package player;

import ai.AI;

public class PlayerService {
	public char[] initGuess(AI ai) {
		char[] arrGuess = new char[ai.getAnswer().length()];
		for (int x = 0; x < ai.getAnswer().length(); x++) {
			arrGuess[x] = 95;
		}
		return arrGuess;
	}
}
