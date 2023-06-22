package working_with_abstractions._3_cards_with_power_deck;

import java.util.Scanner;
import working_with_abstractions._3_cards_with_power.Deck;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String card = scanner.nextLine();
        String suit = scanner.nextLine();

        Deck.CardRanks cardRank = Deck.CardRanks.valueOf(card);
        Deck.CardSuit cardSuit = Deck.CardSuit.valueOf(suit);

        Deck deck = new Deck(cardRank, cardSuit);


        System.out.printf("Card name: %s of %s; Card power: %d",
                          cardRank,
                          cardSuit,
                          deck.getPower()
                         );


    }
}
