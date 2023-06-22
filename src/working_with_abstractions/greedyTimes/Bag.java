package working_with_abstractions.greedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {

    private static final Comparator<Item> COMPARE_ITEM_BY_NAME = Comparator.comparing(Item::getItemName);
    private static final Comparator<Item> COMPARE_ITEM_BY_AMOUNT = Comparator.comparing(Item::getAmount);

    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    void printItems() {

        getAllTypesTotalAmount().entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() != 0)
                                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                .forEach(entry -> {
                                    System.out.printf("<%s> $%s\n", entry.getKey(), entry.getValue());
                                    this.items.stream()
                                              .filter(item -> item.getItemType().equals(entry.getKey()))
                                              .sorted(COMPARE_ITEM_BY_NAME.reversed().thenComparing(COMPARE_ITEM_BY_AMOUNT))
                                              .forEach(item -> {
                                                  System.out.printf("##%s - %d\n", item.getItemName(), item.getAmount());
                                              });
                                });
    }

    public void put(Item itemToAdd) {
        if (canAdd(itemToAdd)) {
            // check whether the given itemToAdd exists
            Item item = getItemByName(itemToAdd.getItemName());
            if (item != null) {
                item.setAmount(item.getAmount() + itemToAdd.getAmount());
            } else {
                this.items.add(itemToAdd);
            }
        }
    }

    private Item getItemByName(String itemName) {
        return this.items.stream()
                         .filter(item -> item.getItemName().equals(itemName))
                         .findFirst()
                         .orElse(null);
    }

    private boolean canAdd(Item item) {

        // if there is no capacity can't add
        if (this.capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }

        // if there is no such items can't add
        if (item.getItemType() == null) {
            return false;
        }

        switch (item.getItemType()) {
            case Gem:
                // The gold amount in your bag should always be more than or equal to the gem amount at any time
                if (item.getAmount() + getTotalAmountByType(ItemType.Gem) > getTotalAmountByType(ItemType.Gold)) {
                    return false;
                }
                break;
            case Cash:
                // The gem amount should always be more than or equal to the cash amount at any time
                if (item.getAmount() + getTotalAmountByType(ItemType.Cash) > getTotalAmountByType(ItemType.Gem)) {
                    return false;
                }
                break;
        }
        return true;
    }

    private long getTotalAmount() {
        return this.items.stream()
                         .mapToLong(Item::getAmount)
                         .sum();
    }

    private Long getTotalAmountByType(ItemType itemType) {
        return this.items.stream()
                         .filter(item -> item.getItemType().equals(itemType))
                         .mapToLong(Item::getAmount)
                         .sum();
    }

    private Map<ItemType, Long> getAllTypesTotalAmount() {
        Map<ItemType, Long> map = new HashMap<>();
        for (ItemType itemType : ItemType.values()) {
            map.put(itemType, getTotalAmountByType(itemType));
        }
        return map;
    }
}
