package Lab5;
/**
 * Simulates storing a librarian object for a library
 */
public class Librarian extends Person{
	private Library library;
	public Librarian(String firstName, String lastName, int identifier, Library newLibrary) {
		super(firstName, lastName, identifier);
		library = newLibrary;
		library.addLibrarian(this);
	}
	
	public void addPatron(Patron addPatron) {
		library.addPatron(addPatron);
	}
	public String patronCheckout(Patron checkout, Book bookCheckOut) {
		return library.checkOutBook(checkout, bookCheckOut);
	}
	public void addBook(Book book) {
		library.addBook(book);
	}
	
	
  }
