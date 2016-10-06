package diceGame;

/**
 * Saves each players data and rolls dice
 *
 */

public class Player {

	private int points = 0, current, last, win;
	private String name;

	public static Dice d1 = new Dice(1);
	public static Dice d2 = new Dice(1);

	public Player(String a) {
		name = a;
	}

	public void rollDice() {
		d1.roll();
		d2.roll();
		current = d1.getValue() + d2.getValue();
		if (current == 2) {
			points = 0;
			current = 0;
		}
	}

	public boolean checkExtraTurn() {
		if (d1.getValue() == d2.getValue()) {
			return true;
		} else {
			return false;
		}
	}

	public void checkDoubleWin() {

		if (last == 12 && current == 12) {
			win = 1;
		}
	}

	public void checkNormalWin() {
		if (points > 39 && d1.getValue() == d2.getValue()) {
			win = 1;
		}

	}

	public void addPoints() {
		points += current;
		last = current;
	}

	public String toString() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public int getWin() {
		return win;
	}

	public int getLast() {
		return last;
	}

	public int getCurrent() {
		return current;
	}

}
