/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    // Attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a Cafe object with the specified inventory and building details.
     *
     * @param nCoffeeOunces The initial number of ounces of coffee.
     * @param nSugarPackets The initial number of sugar packets.
     * @param nCreams       The initial number of cream splashes.
     * @param nCups         The initial number of cups.
     * @param address       The address of the cafe.
     * @param floors        The number of floors in the cafe building.
     */
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, String address, int floors) {
        super("JJsCafe", address, floors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    // Overloading the constructor
    /**
    * Constructs a Cafe object with default inventory values and specified building details.
    *
    * @param address The address of the cafe.
    * @param floors  The number of floors in the cafe building.
    */
    public Cafe(String address, int floors) {
        super("JJsCafe", address, floors); // Call the constructor of the Building class
        this.nCoffeeOunces = 100; // Default value for coffee ounces
        this.nSugarPackets = 50; // Default value for sugar packets
        this.nCreams = 30; // Default value for cream splashes
        this.nCups = 100; // Default value for cups
        System.out.println("You have built a cafe with default inventory: ☕");
   }


    /**
     * Sells a coffee with the specified size, sugar packets, and cream splashes.
     * If inventory is insufficient, it triggers restocking and retries the sale.
     *
     * @param size          The size of the coffee in ounces.
      * @param nSugarPackets The number of sugar packets requested.
     * @param nCreams       The number of cream splashes requested.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // Check if inventory is enough
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("☕ Coffee sold: " + size + "oz, " + nSugarPackets + " sugar(s), " + nCreams + " cream(s).");
        } else {
            System.out.println("⚠️ Not enough inventory. Restocking...");
            restock(100, 50, 50, 20); // Adjust restock values as needed

            // Retry selling after restocking
            if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups > 0) {
                sellCoffee(size, nSugarPackets, nCreams);
            } else {
                System.out.println("❌ Still not enough inventory after restocking. Order cannot be fulfilled.");
            }
        }
    }

    
    /**
     * Restocks the cafe's inventory with the specified amounts of coffee, sugar packets,
     * cream, and cups.
     * @param nCoffeeOunces The number of ounces of coffee to add.
     * @param nSugarPackets The number of sugar packets to add.
     * @param nCreams       The number of cream splashes to add.
     * @param nCups         The number of cups to add.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        // Restock inventory
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("✅ Restocked: +" + nCoffeeOunces + " coffee oz, +" + nSugarPackets + " sugar(s), +" + nCreams + " cream(s), +" + nCups + " cup(s).");
    }

    //overloading the restock method
    /**
    * Restocks the cafe's inventory with specified amounts for coffee, sugar, cream, or cups.
    * You can pass 0 for items you don't want to restock.
    *
    * @param nCoffeeOunces The number of ounces of coffee to add (optional).
    * @param nSugarPackets The number of sugar packets to add (optional).
    */
    private void restock(int nCoffeeOunces, int nSugarPackets) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        System.out.println("✅ Restocked: +" + nCoffeeOunces + " coffee oz, +" + nSugarPackets + " sugar(s).");
    }




     //override the showOptions method from the building class
    public void showOptions() {
        super.showOptions(); // Call the parent class's showOptions method
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(size, nSugarPackets, nCreams) \n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }   
    
    //override goToFloor method from the building class
    public void goToFloor(int floorNum) {
        if (floorNum == 1) {
            System.out.println("You are now on the ground floor of " + this.name);
        } else {
            super.goToFloor(floorNum); // Call the parent class's goToFloor method
        }
    }
    

    public static void main(String[] args) {
        // Create a Cafe object
        Cafe JJsCafe = new Cafe(100, 50, 50, 20, "123 Main St", 1);
        JJsCafe.showOptions(); // Show available options in the cafe
        System.out.println(JJsCafe); // Print the cafe details

        // Sell coffee and check restocking behavior
        JJsCafe.sellCoffee(8, 2, 1);
        JJsCafe.sellCoffee(8, 2, 1);
        JJsCafe.sellCoffee(200, 10, 5); // Should trigger restocking
        JJsCafe.sellCoffee(8, 2, 1); 
        JJsCafe.restock(50, 25); // Example usage of the overloaded restock method
        JJsCafe.sellCoffee(200, 10, 5); // Large request, may fail even after restocking
        JJsCafe.sellCoffee(8, 100, 1); // Not enough sugar
        JJsCafe.sellCoffee(8, 2, 100); // Not enough cream

        //testing overloaded constructor
        Cafe JJsCafe2 = new Cafe("456 Elm St", 2); // Create a new Cafe object with default inventory
        JJsCafe2.showOptions(); // Show available options in the cafe

        //testing the restock method 
        JJsCafe2.restock(50, 25, 10, 5); // Restock with specific amounts
        JJsCafe2.sellCoffee(8, 2, 1); // Sell coffee after restocking
    }
}
