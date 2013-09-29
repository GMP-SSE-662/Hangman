package junit.suite.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import machine.Machine;

import org.junit.Before;
import org.junit.Test;

import player.Player;

public class PlayerCase {
	private Player p1;
	private Machine machine;
	
	@Before
	public void initPlayer() {
		p1 = new Player("Player");
	}

	@Test
	public void testInitializeEasyGuess() throws IOException {
		p1.setDifficulty(1);
		machine = new Machine(p1);
		
		p1.initGuess(machine);
		assertTrue(machine.getAnswer().length() <= 5);
		assertEquals(machine.getAnswer().length(), p1.getGuess().length);
	}
	
	@Test
	public void testInitializeNormalGuess() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		
		p1.initGuess(machine);
		
		assertTrue(machine.getAnswer().length() >= 5);
		assertEquals(machine.getAnswer().length(), p1.getGuess().length);
	}
}
