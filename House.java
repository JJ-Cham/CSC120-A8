/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  // Attributes
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  // Constructor
    /**
   * Constructs a House with the specified address, number of floors, and dining room availability.
   * 
   * @param address The address of the house.
   * @param floors The number of floors in the house.
   * @param hasDiningRoom True if the house has a dining room, false otherwise.
   */
  public House(String address, int floors, boolean hasDiningRoom) {
    super("myHouse",address, floors); // Call the constructor of the Building class
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom; 
    System.out.println("You have built a house: 🏠");
  }

  // Accessor methods
    /**
   * Checks if the house has a dining room.
   * 
   * @return True if the house has a dining room, false otherwise.
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Retrieves the list of residents in the house.
   * 
   * @return The list of residents.
   */
  public int nResidents() {
    return this.residents.size();
  }

  // Move-in method
  /**
   * Moves a student into the house.
   * 
   * @param s The student to move in.
   */
  public void moveIn(Student s) {
    this.residents.add(s);
    System.out.println(s.getName() + " has moved in.");
  }

  // Move-out method
  /**
   * Moves a student out of the house.
   * 
   * @param s The student to move out.
   * @return The moved-out student, or null if the student was not a resident.
   */
  public Student moveOut(Student s) {
    if (this.residents.remove(s)) {
      System.out.println(s.getName() + " has moved out.");
      return s;
    } else {
      System.out.println(s.getName() + " is not a resident of this house.");
      return null;
    }
  }

  // Check if a student is a resident
  /**
   * Checks if a student is a resident of the house.
   * 
   * @param s The student to check.
   * @return True if the student is a resident, false otherwise.
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }


  public static void main(String[] args) {

    House myHouse = new House("123 Main St", 2, true); // House with a dining room

    // Create valid Student objects
    Student JJ = new Student("JJ", "991234560", 2029);
    Student Kevin = new Student("Kevin", "991234567", 2008); 

    myHouse.moveIn(JJ);
    myHouse.moveIn(Kevin);

    System.out.println("Number of residents: " + myHouse.nResidents()); // Should print 2
    System.out.println("Has dining room? " + myHouse.hasDiningRoom()); // Should print true

    myHouse.moveOut(JJ);
    System.out.println("Is JJ a resident? " + myHouse.isResident(JJ)); // Should print false

    myHouse.moveOut(Kevin);
    System.out.println("Number of residents: " + myHouse.nResidents()); // Should print 0
  }
}