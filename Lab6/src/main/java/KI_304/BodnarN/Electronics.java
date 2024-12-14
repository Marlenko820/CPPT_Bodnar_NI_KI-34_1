package KI_304.BodnarN;

/**
 * Class representing electronic household items
 */
public class Electronics extends HouseholdItem {
    private int warrantyMonths;

    /**
     * Constructor for Electronics
     * @param name Item name
     * @param price Item price
     * @param warrantyMonths Warranty period in months
     */
    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months";
    }
}
