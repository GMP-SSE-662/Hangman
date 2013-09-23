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
		while (choice != 4) { // Quit
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

					if (controls == 1) {
						System.out.print("Input letter: ");
						String guess = consoleReader.readLine();
						
						if (a1.isLetterInWord(answer, guess)) {
							//updates P1 guess
							//redundant code
							//place in AIService class
							for(int x = 0; x < answer.length(); x++) {
								if (answer.toCharArray()[x] == guess.charAt(0)) {
									P1.getGuess()[x] = guess.charAt(0);
								}
							}
							//checks if final input letter is same as guess
							if(String.valueOf(P1.getGuess()).equals(answer)) {
								System.out.print("You have beaten the game!");
								System.out.println();
								
							}
							System.out.println();
						} else {
							P1.setTries(P1.getTries() - 1);
						}
					}
					
					if(controls == 3) {
						P1.setTries(0);
					}

					// TODO if 3 Verify: ARE YOU SURE if yes show answer and
					// give controls a value of 4
				}

				if (P1.getTries() == 0 && !String.valueOf(P1.getGuess()).equals(answer)) {
					System.out.println("GAME OVER, " + P1.getUsername());
					System.out.println("The answer is " + "\"" + answer + "\"");
					System.out.println();
				}

				// TODO if controls = 4

			}
		}
	}
}
