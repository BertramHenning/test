package diceGame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Player("TestPlayer");
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
	}

	/**
	 * Tests if this method can roll 2 dice and add the values together
	 */
	@Test
	public void testRollDice() {
		p1.rollDice();
		int expected = Player.d1.getValue() + Player.d2.getValue();
		int actual = p1.getCurrent();
		assertEquals(expected, actual);
	}
	
	/**
	 * Rolls dice until both values are 1 and then tests if points are reset
	 */
	@Test
	public void testDoubleOneRollDice() {
		while(Player.d1.getValue() != 1 || Player.d2.getValue() != 1){
			p1.rollDice();
		}
		p1.addPoints();
		int expected = 0;
		int actual = p1.getPoints();
		assertEquals(expected, actual);
	}

	/**
	 * Rolls dice until both values are equal and then tests if extra turn is true
	 */
	@Test
	public void testCheckExtraTurn() {
		while(Player.d1.getValue() != Player.d2.getValue()){
			p1.rollDice();
		}
		boolean expected = true;
		boolean actual = p1.checkExtraTurn();
		assertEquals(expected, actual);		
	}

	/**
	 * Rolls dice until both values are 6 two times in a row and tests if win is 1
	 */
	@Test
	public void testCheckDoubleWin() {
		while(p1.getCurrent() != 12 || p1.getLast() != 12){
			p1.rollDice();
			p1.addPoints();
		}
		p1.checkDoubleWin();
		int expected = 1;
		int actual = p1.getWin();
		assertEquals(expected, actual);	
		
	}
	
	/**
	 * Rolls dice until both values are equal and points are 40 or over and tests if win is 1
	 */
	@Test
	public void testCheckNormalWin() {
		while(true){
			p1.rollDice();
			if (p1.getPoints() > 39 && Player.d1.getValue() == Player.d2.getValue() ){
				p1.checkNormalWin();
				break;
			}
			p1.addPoints();
		}
		int expected = 1;
		int actual = p1.getWin();
		assertEquals(expected, actual);	
	}

	@Test
	public void testAddPoints() {
		p1.rollDice();
		p1.addPoints();
		int expected = p1.getCurrent();
		int actual = p1.getPoints();
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testMultipleAddPoints() {
		int expected = 0;
		p1.rollDice();
		p1.addPoints();
		expected += p1.getCurrent();
		p1.rollDice();
		p1.addPoints();
		expected += p1.getCurrent();
		p1.rollDice();
		p1.addPoints();
		expected += p1.getCurrent();
		int actual = p1.getPoints();
		assertEquals(expected, actual);	
	}


}
