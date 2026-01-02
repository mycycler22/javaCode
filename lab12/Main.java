package lab12;

//The Main class to test the functionality of Box and Safe.
public class Main {
	
	public static void main(String[] args) {
     // Create a Box with a capacity of 3.
     Box box = new Box(3);
     // Store items in the Box.
     box.store("Book");
     box.store("Pen");
     box.store("Notebook");
     // Try to store one more item than the capacity allows.
     box.store("Pencil"); // Should print error message.

     // Retrieve items from the Box and print them.
     System.out.println("Retrieved from Box: " + box.retrieve()); // Should print "Notebook".
     System.out.println("Retrieved from Box: " + box.retrieve()); // Should print "Pen".

     // Create a Safe with a capacity of 2.
     Safe safe = new Safe(2);
     // Store items in the Safe.
     safe.store(100);
     safe.store(200);
     // Try to store one more item than the capacity allows.
     safe.store(300); // Should print error message.

     // Retrieve items from the Safe and print them.
     System.out.println("Retrieved from Safe: " + safe.retrieve()); // Should print 200.
     System.out.println("Retrieved from Safe: " + safe.retrieve()); // Should print 100.
 }
}


