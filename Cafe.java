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
        
    public static void main(String[] args) {
        // Create a Cafe object
        Cafe JJsCafe = new Cafe(100, 50, 50, 20, "123 Main St", 1);

        // Sell coffee and check restocking behavior
        JJsCafe.sellCoffee(8, 2, 1);
        JJsCafe.sellCoffee(8, 2, 1);
        JJsCafe.sellCoffee(200, 10, 5); // Should trigger restocking
        JJsCafe.sellCoffee(8, 2, 1); 
        JJsCafe.sellCoffee(200, 10, 5); // Large request, may fail even after restocking
        JJsCafe.sellCoffee(8, 100, 1); // Not enough sugar
        JJsCafe.sellCoffee(8, 2, 100); // Not enough cream
    }
}
