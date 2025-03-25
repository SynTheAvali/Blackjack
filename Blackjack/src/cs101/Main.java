package cs101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		print.clear();

		System.out.println("You're gambling your life's posessions away");
		System.out.println("Your car, your house, everything that has value to you.");
		System.out.println("Why? Cus LETS GO GAMBLING!");
		System.out.println("You sit at blackjack, a game that can be won with skill");

		System.out.println("");

		Scanner input = new Scanner(System.in); // Create a Scanner object
		Dealer jess = new Dealer();

		// deal dealer's cards
		String[] dealerCards = jess.deal(2);
		System.out.println("Dealer shows: [" + dealerCards[0] + "]");
		System.out.println("Value: " + getHandValue(new String[] { dealerCards[0] }));

		System.out.println("");

		String[] playerCards = jess.deal(2);
		System.out.println("Here's your hand: " + Arrays.toString(playerCards));
		System.out.println("Value: " + getHandValue(playerCards));

		System.out.println("");

		playerCards = Main.inPlay(input, jess, playerCards);

		int dealerValue = getHandValue(dealerCards);
		int playerValue = getHandValue(playerCards);

		print.line();

		System.out.println("Your Deck is " + Arrays.toString(playerCards));
		System.out.println("Value: " + getHandValue(playerCards));

		System.out.println("");

		System.out.println("Dealer reveals their deck: " + Arrays.toString(dealerCards));
		System.out.println("Value: " + getHandValue(dealerCards));

		System.out.println("");

		if (playerValue > 21) {
			System.out.println("Your deck is over 21!");
			System.out.println("You lose your car and your house.");
			System.out.println("Your greed has made you lose everything.");
		} else {
			System.out.println("\"You've activated my trap card!\"");

			System.out.println("");

			System.out.println("Dealer has a value of " + dealerValue);
			System.out.println("You have a value of " + playerValue);

			System.out.println("");

			if (dealerValue >= playerValue) {
				System.out.println("The dealer's cards is greater or equal to your cards!");
				System.out.println("You lose your car and your house.");
				System.out.println("Your lack of confidence made you lose everything.");
			} else {
				System.out.println("YOU WON!");
				System.out.println("");
				System.out.println(
						"Before you could get out of the casino with your winnings, you were suddenlly hit on the back of the head.");
				System.out.println("You regain consciousness in an alley, with nothing but the clothes on your back.");
				System.out.println(
						"In the corner of your eye, you see a van start to drive away with the dealer driving.");
				System.out.println("\"The house awalys wins\"");
				System.out.println("As you stare at the van speed off, you realise that the worse decision you've made in your life was to gamble");
				System.out.println("");
				System.out.println("DO NOT GAMBLE");
				System.out.println("YOU DO NOT WIN.");
				System.out.println("WHY?");
				System.out.println("");
				System.out.println("Because");
			}

		}
		System.out.println("The house awalys wins...");

		System.out.println("");
	}

	public static String[] inPlay(Scanner input, Dealer jess, String[] playerCards) {

		System.out.println("Hit or Stand?");
		String hitOrStandInput = input.nextLine();

		while (hitOrStandInput.toLowerCase().equals("hit")) {
			String[] newCards = jess.deal(1);
			playerCards = mergeLists(playerCards, newCards);

			System.out.println("");

			System.out.println("New Hand: [" + concatHand(playerCards) + "]");
			System.out.println("Value: " + getHandValue(playerCards));

			if (getHandValue(playerCards) > 21) {
				break;
			}

			System.out.println("");

			System.out.println("Hit or Stand?");
			hitOrStandInput = input.nextLine();
		}

		return playerCards;
	}

	public static int getCardValue(String card, boolean highAce) {
		String[] split = card.split(" ");

		String cardType = split[0];
		String cardValue = split[1];

		try {
			int parsed = Integer.parseInt(cardValue);
			return parsed;
		} catch (Exception e) {
			if (cardValue.equals("ACE")) {
				if (highAce) {
					return 11;
				} else {
					return 1;
				}
			} else {
				return 10;
			}
		}

	}

	public static int getHandValue(String[] hand) {
		int value = 0;

		for (String card : hand) {
			value += getCardValue(card, (value < (21 - 11)));
		}

		return value;
	}

	public static String concatHand(String[] hand) {
		String text = "";
		for (int i = 0; i < hand.length; i++) {
			text += hand[i];
			if (i < (hand.length - 1)) {
				text += ", ";
			}
		}
		return text;
	}

	public static String[] mergeLists(String[] list1, String[] list2) {
		String[] merged = new String[list1.length + list2.length];
		int i = 0;
		for (String item : list1) {
			merged[i] = item;
			i++;
		}
		for (String item : list2) {
			merged[i] = item;
			i++;
		}
		return merged;
	}
}