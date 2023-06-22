package working_with_abstractions._card_ranks_suit;

import java.util.Scanner;

import com.sun.nio.sctp.SctpSocketOption;
import working_with_abstractions._2_card_ranks.CardRanks;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        System.out.printf("%s:\n", command);
        switch (command) {
            case "Card Suits":
                printOrdinalAndNameValues(CardSuit.values());
                break;
            case "Card Ranks":
                printOrdinalAndNameValues(CardRanks.values());
                break;
        }
    }
    private static <E extends Enum<E>>void printOrdinalAndNameValues(Enum<E>[] values) {
        for (Enum<E> value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",
                              value.ordinal(),
                              value);
        }
    }
}
