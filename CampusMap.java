import java.util.ArrayList;
import java.util.Hashtable;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "100 Park House Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("College Hall", "100 Main st Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Mwangi Cultural Center", "100 mall Northampton, MA 01063", 1)); 
        myMap.addBuilding(new Building("Chuckett House", "100 Pink Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Yolanda King House", "100 Blue House Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Ziskind House", "100 Park House Northampton, MA 01063", 3)); // Overloaded constructor
        //testing/implementing all of the overloaded methods/constructors 
        myMap.addBuilding(new Building("Nogi", "100 Orange Street Northampton, MA 01063", 5));
        //testing the overloaded House constructor with an elevator and dining room
        myMap.addBuilding(new House("100 Yellow House Northampton, MA 01063", 3, true, true)); // Overloaded House constructor with elevator and dining room
        myMap.addBuilding(new House( "100 Park House Northampton, MA 01063", 3)); // Overloaded House constructor
        myMap.addBuilding(new Library("Young Library", 5)); // Overloaded Library constructor
        myMap.addBuilding(new Cafe("CC Cafe", 2)); // Overloaded Cafe constructor with default inventory
        myMap.addBuilding(new Library(new Hashtable<>(), "Neilson Library", 5));

        System.out.println(myMap); // Print the map to see all buildings
    }
    
}
