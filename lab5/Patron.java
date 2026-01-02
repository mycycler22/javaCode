package Lab5;
import java.util.ArrayList;

/**
 * simulates a library patron object
 */

public class Patron extends Person {
	private ArrayList<Book>books = new ArrayList<>();
	
	public Patron(String firstName, String lastName, int identifier) {
		super(firstName, lastName, identifier);
		
	}
	
	public String showCheckedOutBooks() {
		return books.toString();
	}

	public ArrayList<Book> getCheckedOutList(){
		ArrayList<Book>checkout = new ArrayList<>();
		for(Book b: books) {
			System.out.println(b);
		}
		
		return checkout;
	}
	
}
