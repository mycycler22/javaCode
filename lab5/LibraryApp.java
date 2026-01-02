package Lab5;

/** 
 * /**
 * This class simulates a library application driver
 *  using a blockchain for storage
 * Original code from Marquette University
 * 	K. Lejmbach and D. Perouli,
 * “Developing a Modular and Interactive Blockchain Learning Tool for Undergraduate Computer Science Programs,” 
 * in Proceedings of the 54th ACM Technical Symposium on Computer Science Education V. 2, 
 * Toronto ON Canada: ACM, Mar. 2022, pp. 1324–1324. doi: 10.1145/3545947.3576271.
 * K. Lejmbach, D. Perouli, and M. Magiera, 
 * “Embedding Blockchain Concepts into Common Computer Science Courses,” 
 * in 2024 IEEE Frontiers in Education Conference (FIE), Washington, DC, USA:
 *  IEEE, Oct. 2024, pp. 1–5. doi: 10.1109/FIE61694.2024.10893052.
 *  
 *  @version September 2025, 
 *  Sherri Weitl-Harms
 *  Creighton University
 */


public class LibraryApp {
	public static void main(String[] args) {
		
		//------------First Test Case-------
		/*
    Create a library called Testing Library,
    Create a librarian and assign them to the library object.
    This is done because the librarian can call methods on behalf of the library object, so we establish a link
    subsequent method calls are done through the librarian object
		 */
		
		
		  Library library1 = new Library("Testing Library1"); Library library3 = new
		  Library("Fake Library"); Librarian librarian1 = new
		  Librarian("Librarian1 First", "Librarian1 Last",1000,library1); //
		  library1.addLibrarian(librarian1); librarian1.addPatron(new
		  Patron("Patron First", "Patron Last", 2000)); librarian1.addBook(new
		  Book("Book1Title","Book1AuthorFirst","Book1AuthorLast","111",4));
		  System.out.println("---State of Blockchain-Test 1--");
		  System.out.println(library1);
		 
		
		//----------Second Test Case---------
		/*
    The second test case creates dedicated patron and book objects
    The checkout method is run and the patron checks out the b2 book
    Finally the state of the blockchain is printed
		 */

		System.out.println("---Test 2--");

		
		  Library library2 = new Library("Testing library2"); Patron p2= new
		  Patron("p2 First","p2 Last", 2000); Librarian l2 = new
		  Librarian("l2 First","l2 Last", 1000, library2); Book b2 = new
		  Book("b2 Title","b2 AuthorFirst","b2 AuthorLast","111",4); //
		  library2.addLibrarian(l2); l2.addPatron(p2); l2.addBook(b2);
		  System.out.println("Copies available after add book b2 with 4 copies: "+b2.
		  getCopiesAvailable()); String checkOutMessage = l2.patronCheckout(p2,b2);
		  System.out.print(checkOutMessage); System.out.
		  println("Copies available after patron checked out 1 copy of book b2: "+b2.
		  getCopiesAvailable());
		  
		 System.out.println("\n\n---State of Blockchain- Test 2--");
		 System.out.println(library2);

		 
		 
		System.out.println("---------Mark's Test--------");
		
		Library library7 = new Library("The Sonk Cafe");
		Patron buyer = new Patron("Derek", "Singleton", 4532);
		Librarian admin = new Librarian("Gina", "Smith", 3212, library7);
		Book book4 = new Book("The Seventh Heaven", "Mikey", "DeRosa", "334", 40);
		library7.addLibrarian(admin);
		admin.addPatron(buyer);
		admin.addBook(book4);
		System.out.println("Copies available after add book book4 with 40 copies: " + 
		book4.getCopiesAvailable());
		String checkoutMessage = admin.patronCheckout(buyer, book4);
		System.out.println(checkoutMessage);
		System.out.println("Copies available after patron checked out 1 copy of book4 :" +
		book4.getCopiesAvailable());
		
		System.out.println("\n\n---State of Blockchain- Mark's Test--");
		System.out.println(library7);
		
		
		
		

	}
}
