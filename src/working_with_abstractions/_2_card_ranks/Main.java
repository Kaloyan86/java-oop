package working_with_abstractions._2_card_ranks;

public class Main {

    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRanks cardRank : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",
                              cardRank.ordinal(),
                              cardRank);
        }
    }
}
