package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import player.*;

public class Launcher {
	private static BufferedReader consoleReader;
	
	public static void main(String[] args) throws IOException {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name:");
		String username = consoleReader.readLine();
		
		Player P1 = new Player(username);
		System.out.println("Welcome " + username + "!");
		
		//TODO Generate word
		//TODO Set number of tries available (80% rounded down the length of the string)
	}

}
