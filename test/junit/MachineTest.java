package junit;

import static org.junit.Assert.*;

import java.io.IOException;

import machine.Machine;

import org.junit.Before;
import org.junit.Test;

import player.Player;

public class MachineTest {
	private Player p1;
	private Machine machine;

	@Before
	public void initPlayer() throws IOException {
		p1 = new Player("Player");
	}
	
	@Test
	public void testSetDifficultyEasy() throws IOException {
		p1.setDifficulty(1);
		machine = new Machine(p1);
		
		machine.setAnswerDifficulty(p1);
		assertTrue(machine.getAnswer().length() <= 5);
	}
	
	@Test
	public void testSetDifficultyNormal() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		
		machine.setAnswerDifficulty(p1);
		assertTrue(machine.getAnswer().length() > 5);
	}
	
	@Test
	public void testSetPlayerTriesEasy() throws IOException {
		p1.setDifficulty(1);
		machine = new Machine(p1);
		
		assertEquals((int) (machine.getAnswer().length() * .8), p1.getTries());
	}
	
	@Test
	public void testSetPlayerTriesNormal() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		
		assertEquals((int) (machine.getAnswer().length() * .8), p1.getTries());
	}
	
	@Test
	public void testIsLetterInWord() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		machine.setAnswer("test");
		
		assertTrue(machine.isLetterInWord(p1, machine.getAnswer(), "t"));
	}
	
	@Test
	public void testIsGuessCorrect() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		machine.setAnswer("test");
		
		assertTrue(machine.isGuessCorrect(p1, machine.getAnswer(), "test"));
	}
	
	@Test
	public void testRemoveOneTry() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		int beforeRemove = p1.getTries();
		machine.removeOneTry(p1);
		
		assertTrue(p1.getTries() < beforeRemove);
	}
	
	@Test
	public void testIsGameOver() throws IOException {
		p1.setDifficulty(2);
		machine = new Machine(p1);
		
		p1.setTries(0);
		assertTrue(machine.isGameOver(p1, machine));
	}

}
