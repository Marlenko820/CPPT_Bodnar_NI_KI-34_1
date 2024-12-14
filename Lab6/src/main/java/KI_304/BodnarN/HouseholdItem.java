package KI_304.BodnarN;


/**
 * Abstract class representing a household item
 */
public abstract class HouseholdItem implements Comparable<HouseholdItem> {
    protected String name;
    protected double price;

    /**
     * Constructor for HouseholdItem
     * @param name Item name
     * @param price Item price
     */
    public HouseholdItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get item price
     * @return price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Compare items by price
     * @param other Other item to compare with
     * @return comparison result
     */
    @Override
    public int compareTo(HouseholdItem other) {
        return Double.compare(this.price, other.price);
    }

    /**
     * String representation of the item
     * @return String containing item details
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
}

