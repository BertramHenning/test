package diceGame;

import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {

		Player[] players = new Player[2];

		players[0] = new Player("Player 1");
		players[1] = new Player("Player 2");

		Scanner sc = new Scanner(System.in);

		int whoseTurn = 0;

		while (true) {

			System.out.println("Your turn " + players[whoseTurn]);
			System.out.println("Press enter to roll");

			if (sc.nextLine().equals("stop")) {
				break;
			}

			System.out.println("____________________________");
			System.out.println();

			players[whoseTurn].rollDice();
			players[whoseTurn].checkNormalWin();
			players[whoseTurn].checkDoubleWin();
			players[whoseTurn].addPoints();

			System.out.print(" ");
			if (Player.d1.getValue() != 1) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d1.getValue() == 6) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d1.getValue() > 3) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.print("   ");
			if (Player.d2.getValue() != 1) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d2.getValue() == 6) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d2.getValue() > 3) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.println();

			System.out.print("  ");
			if (Player.d1.getValue() % 2 != 0) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.print("     ");
			if (Player.d2.getValue() % 2 != 0) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.println();

			System.out.print(" ");
			if (Player.d1.getValue() > 3) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d1.getValue() == 6) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d1.getValue() != 1) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.print("   ");
			if (Player.d2.getValue() > 3) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d2.getValue() == 6) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			if (Player.d2.getValue() != 1) {
				System.out.print("●");
			} else {
				System.out.print(" ");
			}
			System.out.println();
			System.out.println();
			System.out.println(players[whoseTurn] + " rolled: " + players[whoseTurn].getCurrent());
			System.out.println(players[whoseTurn] + "'s points: " + players[whoseTurn].getPoints());

			System.out.println();

			if (players[whoseTurn].getWin() == 1) {
				System.out.println("Congratulations " + players[whoseTurn] + " you won the game!");
				break;
			}

			if (!players[whoseTurn].checkExtraTurn()) {
				if (whoseTurn == 0) {
					whoseTurn = 1;
				} else {
					whoseTurn = 0;
				}
			}

		}

		sc.close();

	}

}
