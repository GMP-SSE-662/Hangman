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

		// TODO Try Catch
		int choice = 0;
		while (choice != 2) { // Quit
			System.out.println("1. Play Hangman");
			System.out.println("2. Quit");

			choice = Integer.parseInt(consoleReader.readLine());
			if (choice == 1) {
				// Play with AI commence
				AI a1 = new AI(P1);
				String answer = a1.getAnswer();
				System.out.println();

				int controls = 0;
				P1.setGuess(P1.initGuess(a1));
				while (P1.getTries() != 0) {
					for (int x = 0; x < answer.length(); x++) {
						if(P1.getGuess()[x] == '\0') {
							System.out.print("_ ");
						} else {
							System.out.print(P1.getGuess()[x] + " ");
						}
					}
					System.out.println();
					System.out.println("1. Guess a letter");
					System.out.println("2. Guess the answer");
					System.out.println("3. Concede");
					System.out.println();
					System.out.println("No. of tries remaining:"
							+ P1.getTries());
					controls = Integer.parseInt(consoleReader.readLine());

					// TODO Player guesses
					if (controls == 1) {
						System.out.print("Input letter: ");
						String guess = consoleReader.readLine();
						// TODO limit input to a char

						if (a1.isLetterInWord(answer, guess)) {
							//TODO update P1.guess
							char[] arrAns = answer.toCharArray();
							for(int x = 0; x < answer.length(); x++) {
								if(arrAns[x] == guess.toCharArray()[0]) {
									System.out.print(arrAns[x] + " ");
								} else {
									System.out.print("_ ");
								}
							}
							System.out.println();
						} else {
							P1.setTries(P1.getTries() - 1);
						}
					}
					
					if(controls == 3) {
						break;
					}

					// TODO if 3 Verify: ARE YOU SURE if yes show answer and
					// give controls a value of 4
				}

				if (P1.getTries() == 0) {
					System.out.println("GAME OVER, " + P1.getUsername());
					System.out.println("The answer is " + "\"" + answer + "\"");
				}

				// TODO if controls = 4

			}
		}
	}
}
