
package working_with_abstractions.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);
        // Bag -> capacity, List<Item> items
        // Item -> name, amount, ItemType
        // enum ItemType

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            ItemType itemType = getType(name);

            Item item = new Item(itemType, name, amount);

            bag.put(item);
        }

        bag.printItems();
    }

    private static ItemType getType(String name) {
        ItemType itemType = null;
        if (name.length() == 3) {
            itemType = ItemType.valueOf("Cash");
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = ItemType.valueOf("Gem");
        } else if (name.equalsIgnoreCase("gold")) {
            itemType = ItemType.valueOf("Gold");
        }
        return itemType;
    }
}