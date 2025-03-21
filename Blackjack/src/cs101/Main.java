package cs101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Create a Scanner object
		Dealer jess = new Dealer();

		// deal dealer's cards
		String[] dealerCards = jess.dealTwo();
		System.out.println("Dealer shows: " + dealerCards[0]);

		String[] startCards = jess.dealTwo();
		String totalHand = startCards[0] + ", " + startCards[1];

		while (true) {
			Main.inPlay(input, jess, startCards, totalHand);
		}

		// ending - dealer shows cards
		System.out.println("You've activated my trap card! " + Arrays.toString(dealerCards));

	}

	public static void inPlay(Scanner input, Dealer jess, String[] startCards, String totalHand) {

		System.out.println("Here's your hand: " + Arrays.toString(startCards));

		System.out.println("Hit or Stand?");
		String hitOrStandInput = input.nextLine();

		if (hitOrStandInput.equals("hit")) {
			// deal another card
			String newCard = jess.dealOne();
			totalHand += ", " + newCard;

			System.out.println("New Hand: " + totalHand);

		} else if (hitOrStandInput.equals("stand")) {
			// move to the end

		}

	}

}
