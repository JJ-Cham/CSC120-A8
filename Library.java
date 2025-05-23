/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

    // Attributes
    private Hashtable<String, Boolean> collection; // A collection of books, where the key is the book title and the value is whether it's available or not

    /**
     * Constructs a Library with a given collection, address, and number of floors.
     *
     * @param collection A Hashtable containing book titles as keys and availability as values.
     * @param address    The address of the library.
     * @param floors     The number of floors in the library.
     */
    public Library(String name, String address, int floors, Hashtable<String, Boolean> collection) {
        super(name, address, floors); // Call the constructor of the Building class
        this.collection = new Hashtable<>(); // Initialize the collection with the provided Hashtable
        System.out.println("You have built a library: 📖");
    }

    //overloading the constructor
    /**
    * Constructs a Library with an address and number of floors only.
    *
    * @param address The address of the library.
    * @param floors  The number of floors in the library.
    */
    public Library(String name, String address, int floors) {
       super(name, address, floors); // Call the constructor of the Building class
       this.collection = new Hashtable<>(); // Default to an empty collection
      System.out.println("You have built a library with no initial collection: 📖");
   }


     /**
     * Adds a book title to the collection if it does not already exist.
     *
     * @param title The title of the book to add.
     */
    public void addTitle(String title) {
      // Add a title to the collection
      if (!this.collection.containsKey(title)) { // Check if the title is already in the collection
        this.collection.put(title, true); // Add the title with an available status
        System.out.println("Added title: " + title);
      } else {
        System.out.println("Title already exists: " + title);
      }
    }


    /**
     * Removes a book title from the collection.
     *
     * @param title The title of the book to remove.
     * @return The removed title, or null if the title was not found.
     */
    public String removeTitle(String title){ // return the title that we removed
      // Remove a title from the collection
      if (this.collection.containsKey(title)) { // Check if the title is in the collection
        this.collection.remove(title); // Remove the title from the collection
        System.out.println("Removed title: " + title);
        return title; // Return the removed title
      } else {
        System.out.println("Title not found: " + title);
        return null; // Return null if the title was not found
      }
    }

     /**
     * Checks whether the collection contains a given title.
     *
     * @param title The title to check.
     * @return True if the title is in the collection, false otherwise.
     */
    public boolean containsTitle(String title){ // returns true if the title appears as a key in the Libary's collection, false otherwise
      // Check if the title is in the collection
      return this.collection.containsKey(title); // Return true if the title is found, false otherwise
    }

     /**
     * Checks if a book title is currently available.
     *
     * @param title The title to check.
     * @return True if the title is available, false otherwise.
     */
    public boolean isAvailable(String title){ // returns true if the title is currently available, false otherwise
      // Check if the title is available
      if (this.collection.containsKey(title)) { // Check if the title is in the collection
        return this.collection.get(title); // Return the availability status of the title
      } else {
        System.out.println("Title not found: " + title);
        return false; // Return false if the title was not found
      }
    }

    /**
     * Prints the entire collection, including each book's availability status.
     */
    public void printCollection(){ // prints out the entire collection in an easy-to-read way (including checkout status)
      // Print the collection
      System.out.println("Library Collection: ");
      for (String title : this.collection.keySet()) { // Iterate through the keys (titles) in the collection
        boolean available = this.collection.get(title); // Get the availability status of the title
        System.out.println(title + " - " + (available ? "Available" : "Checked Out")); // Print the title and its status
      }
    }

    //overloading the printCollection method
    /**
    * Prints the collection based on the specified availability status.
    * 
    * @param onlyAvailable If true, prints only available books; if false, prints only checked-out books.
    */
    public void printCollection(boolean onlyAvailable) {
      System.out.println("Filtered Library Collection: ");
      for (String title : this.collection.keySet()) { // Iterate through the keys (titles) in the collection
        boolean available = this.collection.get(title); // Get the availability status of the title
        if (available == onlyAvailable) { // Print only titles that match the specified status
           System.out.println(title + " - " + (available ? "Available" : "Checked Out"));
       }
  } 
}

  
    /**
     * Checks out a book by marking it as unavailable.
     *
     * @param title The title of the book to check out.
     */
    public void checkOut(String title) {
      if (this.collection.containsKey(title) && this.collection.get(title)) {
          this.collection.replace(title, false);
          System.out.println("Checked out: " + title);
      } else {
          System.out.println("Cannot check out: " + title + " (Either doesn't exist or is already checked out).");
      }
  }
  
      /**
     * Returns a book by marking it as available.
     *
     * @param title The title of the book to return.
     */
     public void returnBook(String title) {
      if (this.collection.containsKey(title) && !this.collection.get(title)) {
          this.collection.replace(title, true);
          System.out.println("Returned: " + title);
      } else {
          System.out.println("Cannot return: " + title + " (Either doesn't exist or is not checked out).");
      }
  }

     //override showOptions method from Building class
    /**
     * Displays the available options for the library.
     */
    public void showOptions() {
      super.showOptions(); // Call the showOptions method from the Building class
      System.out.println("Available options at " + this.getName() + ":\n + addTitle(String title) \n + removeTitle(String title) \n + containsTitle(String title) \n + isAvailable(String title) \n + printCollection() \n + checkOut(String title) \n + returnBook(String title)");
    }

    //override goToFloor method from the building class
    /**
     * Navigates to a specific floor in the library.
     *
     * @param floorNum The floor number to navigate to.
     */ 
    public void goToFloor(int floorNum) {
      super.goToFloor(floorNum); // Allows movement to any valid floor, including non-adjacent ones
  }
  
  


    public static void main(String[] args) {
      Library JJsLibrary = new Library("JJ's Library", "456 Elm St", 3); // Create a new Library object

      JJsLibrary.showOptions(); // Show available options in the library
      System.out.println(JJsLibrary); // Print the library details
      //Create a collection of books
      JJsLibrary.addTitle("The Great Gatsby by F. Scott Fitzgerald"); // Add a title to the collection
      JJsLibrary.addTitle("To Kill a Mockingbird by Harper Lee"); // Add another title to the collection
      JJsLibrary.addTitle("The Lorax by Dr.Seuss"); // Add another title to the collection

      System.out.println("Is 'The Great Gatsby' available? " + JJsLibrary.isAvailable("The Great Gatsby")); // Check availability of a title

      JJsLibrary.checkOut("The Great Gatsby"); // Check out a title
      JJsLibrary.printCollection(); // Print the collection to see the status of all titles

      JJsLibrary.returnBook("The Great Gatsby"); // Attempt to return a null title (should not work)
      JJsLibrary.printCollection(); // Print the collection to see the status of all titles
      JJsLibrary.removeTitle("The Lorax by Dr.Seuss"); // Remove a title from the collection

      //testing overloaded constructor
      Library JJsLibrary2 = new Library("JJ's Second Library", "789 Oak St", 2); // Create a new Library object with no initial collection
      JJsLibrary2.addTitle("1984 by George Orwell"); // Add a title to the new library
      JJsLibrary2.addTitle("Brave New World by Aldous Huxley"); // Add another title to the new library
      JJsLibrary2.printCollection(); // Print the collection of the new library
      JJsLibrary2.checkOut("1984 by George Orwell"); // Check out a title from the new library
      JJsLibrary2.printCollection(); // Print the collection to see the status of all titles

      //testing overloaded printCollection method
      JJsLibrary2.printCollection(true); // Print only available books 
      JJsLibrary2.printCollection(false); // Print only checked-out books
      JJsLibrary2.printCollection(); // Print the entire collection

      //test goToFloor method
      Library myLibrary = new Library("My Library", "123 Main St", 3); // Create a new Library object
      myLibrary.enter(); // Use the variable by calling a method on it
      myLibrary.goToFloor(2); // Move to floor 2
      myLibrary.goToFloor(3); // Move to floor 3
  } 

}