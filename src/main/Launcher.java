package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import machine.Machine;

import player.Player;

public class Launcher {
	private static BufferedReader consoleReader;
	
	public static void main(String[] args) throws IOException {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***LET'S PLAY HANGMAN (w/o the actual \"man\")***");
		
		System.out.print("Enter name:");
		String username = consoleReader.readLine();

		Player player = new Player(username);
		System.out.println("Welcome " + player.getUsername() + "!");
		
		while(true) {
			System.out.println("\n1. Start game");
			System.out.println("2. Help");
			System.out.println("3. About this game");
			System.out.println("4. Quit");
			
			switch (playerInputInteger(0)) {
			case 1: game(player); break;
			case 2: help(); break;
			case 3: about(); break;
			case 4: 
				if (playerWantsToQuit()) {
					System.out.println("***Goodbye, " + player.getUsername() + "***");
					return;
				} break;
			default: System.out.println("***ERROR: Invalid input!***");
			}
		}
	}
	
	public static int playerInputInteger(int n) {
		try {
			return Integer.parseInt(consoleReader.readLine());
		} catch (Exception e) {
			return n;
		}
	}
	
	public static void game(Player player) throws IOException {
		int difficulty = 0;
		do {
			System.out.println("Difficulty:");
			System.out.println("1. Easy");
			System.out.println("2. Normal");
			
			switch (playerInputInteger(0)) {
				case 1:
					difficulty = 1;
					break;
				case 2:
					difficulty = 2;
					break;
				default: System.out.println("***ERROR: Invalid input!***");
					break;
			}
		} while (difficulty == 0);
		
		Machine machine = new Machine(player, difficulty);
		String answer = machine.getAnswer();
		
		System.out.println("\n***Guess this " + answer.length() + " letter word!***");
		
		while (player.getTries() != 0) {
			System.out.println(machine.displayLettersGuessed(player));
			
			System.out.println("\n1. Guess a letter");
			System.out.println("2. Guess the answer");
			System.out.println("3. Concede\n");
			System.out.println("No. of tries remaining: " + "*" + player.getTries() + "*");
			
			switch(playerInputInteger(0)) {
			case 1: guessLetter(player, machine); break;
			case 2: guessAnswer(player, machine); break;
			case 3: 
				if(playerWantsToConcede(player)) {
					player.setTries(0);
				} break; 
			default: System.out.println("***ERROR: Invalid input!***");
			}
		}

		if (player.getTries() == 0 && !player.getGuessAsString().equals(answer)) {
			System.out.println("***GAME OVER, " + player.getUsername() + "!***");
			System.out.println("***The answer is " + "\"" + answer + "\"***");
		}
	}
	
	public static void guessLetter(Player player, Machine machine) throws IOException {
		System.out.print("Input letter: ");
		String letter = consoleReader.readLine();
		String answer = machine.getAnswer();

		if (machine.isLetterInWord(player, answer, letter.toLowerCase())) {
			if (player.getGuessAsString().equals(answer)) {
				System.out.println("***\"" + player.getGuessAsString()	+ "\"" + " is correct!***");
				System.out.print("***You have beaten the game, " + player.getUsername() + "!***");
				player.setTries(0);
			}
			System.out.println();
		} else {
			player.setTries(player.getTries() - 1);
			if (player.getTries() != 0) {
				System.out.println("***Sorry try again!***");
			}
		}
	}
	
	public static void guessAnswer(Player player, Machine machine) throws IOException {
		System.out.print("Input guess: ");
		String word = consoleReader.readLine();
		String answer = machine.getAnswer();
		
		if (machine.isGuessCorrect(answer, word.toLowerCase())) {
			player.setGuess(word.toCharArray());
			System.out.println("***\"" + word + "\"" + " is correct!***");
			System.out.println("***You have beaten the game, " + player.getUsername() + "!***");
			player.setTries(0);

		} else {
			System.out.println("***Sorry try again!***");
			player.setTries(player.getTries() - 1);
		}
	}
		
	public static void help() {
		System.out.println("              ***Help***");
		System.out.println("You will be given a word to try and guess.");
		System.out.println("Your number of trials will depend on the length of the word.");
		System.out.println("You can guess it by letter or guess it directly.");
		System.out.println("Goodluck; Have fun!");
		System.out.println("              ***Help***");
	}
	
	public static void about() {
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
	
	public static boolean playerWantsToConcede(Player player) throws IOException {
		System.out.println("***Are you sure you want to concede?***");
		return answerYN();
	}
	
	public static boolean playerWantsToQuit() throws IOException {
		System.out.println("***Are you sure you want to Quit?***");
		return answerYN();
	}
	
	public static boolean answerYN() throws IOException{
		String yn = "";
		do {
			System.out.print("Y/N: ");
			yn = consoleReader.readLine();
			if(yn.toLowerCase().equals("y")) {
				return true;
			}
		} while (!yn.toLowerCase().equals("n"));
		return false;
	}
}
