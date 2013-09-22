package ai;

import player.Player;

public class AI extends AIService {
	private String answer;

	public AI(Player player) {
		this.answer = generateRandomWord();
		setPlayerTries(player, answer);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}
