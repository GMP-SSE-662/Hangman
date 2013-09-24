package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import player.*;
import dictionary.*;
import ai.*;

public class Launcher {
	private static BufferedReader consoleReader;

	public static void main(String[] args) throws IOException {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name:");
		String username = consoleReader.readLine();

		Player P1 = new Player(username);
		System.out.println("Welcome " + P1.getUsername() + "!");
		System.out.println();

		int choice = 0;
		while (choice != 4) {
			try {
				System.out.println("1. Play Hangman");
				System.out.println("2. Help");
				System.out.println("3. About this game");
				System.out.println("4. Quit");

				choice = Integer.parseInt(consoleReader.readLine());
				if (choice == 1) {
					// Play with AI commence
					AI a1 = new AI(P1);
					String answer = a1.getAnswer();
					System.out.println();

					int controls = 0;
					P1.setGuess(P1.initGuess(a1));
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
							System.out.println("No. of tries remaining:" + P1.getTries());
							controls = Integer.parseInt(consoleReader.readLine());

							if (controls == 1) {
								System.out.print("Input letter: ");
								String ltr = consoleReader.readLine();

								if (a1.isLetterInWord(P1, answer, ltr)) {
									if (String.valueOf(P1.getGuess()).equals(answer)) {
										System.out.println("\"" + String.valueOf(P1.getGuess())	+ "\"" + " is correct!");
										System.out.println("You have beaten the game, " + P1.getUsername()+ "!");
										P1.setTries(0);
									}
									System.out.println();
								} else {
									P1.setTries(P1.getTries() - 1);
									if (P1.getTries() != 0) {
										System.out.println("Sorry try again!");
									}

								}
							}

							if (controls == 2) {
								System.out.print("Input guess: ");
								String guess = consoleReader.readLine();
								if (a1.isGuessCorrect(answer, guess)) {
									P1.setGuess(guess.toCharArray());
									System.out.println("\"" + guess + "\"" + " is correct!");
									System.out.println("You have beaten the game, " + P1.getUsername() + "!");
									P1.setTries(0);

								} else {
									System.out.println("Sorry try again!");
									P1.setTries(P1.getTries() - 1);
								}
							}

							if (controls == 3) {
								System.out.println("Are you sure you want to concede? Y/N: ");
								String yn = consoleReader.readLine();
								if ((yn.toLowerCase().equals("y"))) {
									P1.setTries(0);
								}
							}
						} catch (Exception e) {
							System.out.println("Error! Invalid input!");
						}
					}

					if (P1.getTries() == 0
							&& !String.valueOf(P1.getGuess()).equals(answer)) {
						System.out.println("GAME OVER, " + P1.getUsername());
						System.out.println("The answer is " + "\"" + answer + "\"");
						System.out.println();
					}
				}
				if (choice == 2 || choice == 3) {
					System.out.println("This section is under construction");
				}
				if (choice == 4) {
					System.out.println("Are you sure you want to quit? Y/N:");
					String yn = consoleReader.readLine();
					if ((yn.toLowerCase().equals("y"))) {
						choice = 4;
					} else {
						choice = 0;
					}
				}
			} catch (Exception e) {
				System.out.println("Error! Invalid input!");
			}

		}
	}
}
