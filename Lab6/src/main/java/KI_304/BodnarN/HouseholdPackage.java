package KI_304.BodnarN;


import java.util.ArrayList;
import java.util.List;

/**
 * Generic container class for household items
 * @param <T> Type parameter extending HouseholdItem
 */
public class HouseholdPackage<T extends HouseholdItem> {
    private List<T> items;

    /**
     * Constructor for HouseholdPackage
     */
    public HouseholdPackage() {
        items = new ArrayList<>();
    }

    /**
     * Add item to package
     * @param item Item to add
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Remove item from package
     * @param index Index of item to remove
     * @return Removed item
     */
    public T removeItem(int index) {
        return items.remove(index);
    }

    /**
     * Find maximum priced item in package
     * @return Item with maximum price
     */
    public T findMaxItem() {
        if (items.isEmpty()) {
            return null;
        }
        T maxItem = items.get(0);
        for (T item : items) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    /**
     * Get total value of all items
     * @return Sum of all item prices
     */
    public double getTotalValue() {
        double total = 0;
        for (T item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * Get all items in package
     * @return List of items
     */
    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

