package cs101;

import java.util.Random;

public class Dealer {

	private String[] deck;
	private int dealingIndex;

	public Dealer() {

		this.deck = new String[52];
		this.dealingIndex = 0;

		// make deck

		int index = 0;

		String[] suites = { "HEARTS", "CLUBS", "DIAMONDS", "SPADES" };
		String[] varients = { "JACK", "QUEEN", "KING", "ACE" };

		for (int s = 0; s < suites.length; s++) {

			// add number cards
			for (int i = 2; i < 11; i++) {
				// add card to deck
				this.deck[index] = suites[s] + " " + i;

				// move to next slot
				index++;
			}

			// add face cards, aces
			for (String varient : varients) {
				this.deck[index] = suites[s] + " " + varient;
				index++;
			}
		}

		this.shuffle(this.deck.length);
		// System.out.println(Arrays.toString(this.deck));

	}

	public void shuffle(int count) {

		Random rand = new Random();

		for (int e = 0; e < count; e++) {

			int random_index = rand.nextInt(this.deck.length);

			String temp = this.deck[random_index];
			this.deck[random_index] = this.deck[e];
			this.deck[e] = temp;

		}

	}

	// Don't call shuffle between!
	public String[] deal(int count) {

		String[] dealt = new String[count];

		for (int i = 0; i < count; i++) {
			dealt[i] = this.deck[this.dealingIndex];
			this.dealingIndex++;
		}

		return dealt;

	}

}

/*
 * Notes
 * 
 * Scanner myObj = new Scanner(System.in); // Create a Scanner object
 * 
 * String userName = myObj.nextLine();
 * 
 * 
 * Random rand = new Random();
 * 
 * // Generate random integers in range 0 to 999 int rand_int1 =
 * rand.nextInt(1000);
 * 
 */