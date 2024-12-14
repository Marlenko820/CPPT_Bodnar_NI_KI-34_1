package KI_304.BodnarN;

public class HouseholdPackageDriver {
    public static void main(String[] args) {
        // Create package for electronic items
        HouseholdPackage<Electronics> electronicsPackage = new HouseholdPackage<>();

        // Add some electronics
        electronicsPackage.addItem(new Electronics("TV", 1000.0, 24));
        electronicsPackage.addItem(new Electronics("Laptop", 1500.0, 12));
        electronicsPackage.addItem(new Electronics("Phone", 800.0, 12));

        // Create package for furniture
        HouseholdPackage<Furniture> furniturePackage = new HouseholdPackage<>();

        // Add some furniture
        furniturePackage.addItem(new Furniture("Sofa", 700.0, "Leather"));
        furniturePackage.addItem(new Furniture("Table", 300.0, "Wood"));
        furniturePackage.addItem(new Furniture("Chair", 150.0, "Wood"));

        // Test methods for electronics package
        System.out.println("Electronics Package:");
        System.out.println("All items:");
        for (Electronics item : electronicsPackage.getItems()) {
            System.out.println(item);
        }
        System.out.println("Most expensive electronic: " + electronicsPackage.findMaxItem());
        System.out.println("Total value: " + electronicsPackage.getTotalValue());

        // Test methods for furniture package
        System.out.println("\nFurniture Package:");
        System.out.println("All items:");
        for (Furniture item : furniturePackage.getItems()) {
            System.out.println(item);
        }
        System.out.println("Most expensive furniture: " + furniturePackage.findMaxItem());
        System.out.println("Total value: " + furniturePackage.getTotalValue());

        // Test removal
        System.out.println("\nRemoving an item from electronics package...");
        electronicsPackage.removeItem(0);
        System.out.println("Updated electronics package:");
        for (Electronics item : electronicsPackage.getItems()) {
            System.out.println(item);
        }
    }
}
