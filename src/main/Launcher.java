package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import player.Player;
import ai.AI;

public class Launcher {
	private static BufferedReader consoleReader;

	public static void main(String[] args) throws IOException {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***LET'S PLAY HANGMAN (w/o the actual \"man\")***");
		System.out.print("Enter name:");
		String username = consoleReader.readLine();

		Player P1 = new Player(username);
		String plyrName = P1.getUsername();
		System.out.println("Welcome " + plyrName + "!");

		int choice = 0;
		while (choice != 4) {
			try {
				System.out.println();
				System.out.println("1. Start game");
				System.out.println("2. Help");
				System.out.println("3. About this game");
				System.out.println("4. Quit");

				choice = Integer.parseInt(consoleReader.readLine());
				if (choice == 1) {

					AI a1 = new AI(P1);
					String answer = a1.getAnswer();
					P1.setGuess(P1.initGuess(a1));
					
					System.out.println();
					System.out.println("***Guess this " + answer.length() + " letter word!***");
					
					while (P1.getTries() != 0) {
						try {
							for (int x = 0; x < answer.length(); x++) {
								System.out.print(P1.getGuess()[x] + " ");
							}
							System.out.println();
							System.out.println("1. Guess a letter");
							System.out.println("2. Guess the answer");
							System.out.println("3. Concede");
							System.out.println();
							System.out.println("No. of tries remaining: " + "*" + P1.getTries() + "*");
							int controls = Integer.parseInt(consoleReader.readLine());

							if (controls == 1) {
								System.out.print("Input letter: ");
								String ltr = consoleReader.readLine();

								if (a1.isLetterInWord(P1, answer, ltr.toLowerCase())) {
									if (String.valueOf(P1.getGuess()).equals(answer)) {
										System.out.println("***\"" + String.valueOf(P1.getGuess())	+ "\"" + " is correct!***");
										System.out.print("***You have beaten the game, " + plyrName + "!***");
										P1.setTries(0);
									}
									System.out.println();
								} else {
									P1.setTries(P1.getTries() - 1);
									if (P1.getTries() != 0) {
										System.out.println("***Sorry try again!***");
									}
								}
							}

							else if (controls == 2) {
								System.out.print("Input guess: ");
								String word = consoleReader.readLine();
								if (a1.isGuessCorrect(answer, word.toLowerCase())) {
									P1.setGuess(word.toCharArray());
									System.out.println("***\"" + word + "\"" + " is correct!***");
									System.out.println("***You have beaten the game, " + plyrName + "!***");
									P1.setTries(0);

								} else {
									System.out.println("***Sorry try again!***");
									P1.setTries(P1.getTries() - 1);
								}
							}

							else if (controls == 3) {
								System.out.println("***Are you sure you want to concede?***");
								System.out.print("Y/N: ");
								String yn = consoleReader.readLine();
								while (!yn.toLowerCase().equals("n")) {
									if(yn.toLowerCase().equals("y")) {
										P1.setTries(0);
										break;
									}
									System.out.print("Y/N: ");
									yn = consoleReader.readLine();
								}
							}
						} catch (Exception e) {
							System.out.println("***ERROR: Invalid input!***");
						}
					}

					if (P1.getTries() == 0 && !String.valueOf(P1.getGuess()).equals(answer)) {
						System.out.println("***GAME OVER, " + plyrName + "!***");
						System.out.println("***The answer is " + "\"" + answer + "\"***");
					}
				}
				else if (choice == 2) {
					System.out.println("              ***Help***");
					System.out.println("You will be given a word to try and guess.");
					System.out.println("Your number of trials will depend on the length of the word.");
					System.out.println("You can guess it by letter or guess it directly.");
					System.out.println("Goodluck; Have fun!");
					System.out.println("              ***Help***");
				}
				else if (choice == 3) {
					System.out.println("          ***About this game***");
					System.out.println("This game was developed to check and exercise");
					System.out.println("zurcnay4's OOP knowledge using java. \n");
					System.out.println("Comments & suggestions on: ");
					System.out.println("- the application's overall design/code");
					System.out.println("- how to improve this game");
					System.out.println("are highly appreciated! \n");
					System.out.println("Fork on github: https://github.com/zurcnay4/Hangman");
					System.out.println("          ***About this game***");
				}
				else if (choice == 4) {
					System.out.println("***Are you sure you want to quit?***");
					System.out.print("Y/N: ");
					String yn = consoleReader.readLine();
					while (!yn.toLowerCase().equals("n")) {
						if ((yn.toLowerCase().equals("y"))) {
							choice = 4;
							break;
						}
						System.out.print("Y/N: ");
						yn = consoleReader.readLine();
					}
					if ((yn.toLowerCase().equals("n"))) {
						choice = 0;
					}
				}
			} catch (Exception e) {
				System.out.println("***ERROR: Invalid input!***");
			}
		}
	}
}
