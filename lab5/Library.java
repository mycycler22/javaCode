package Lab5;
import java.util.ArrayList;

/**
 * This class stores the information for a single library 
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
 
public class Library {
    private ArrayList<Book> collection = new ArrayList<Book>();
    private ArrayList<Patron> patrons = new ArrayList<Patron>();
    private ArrayList<Librarian> librarians = new ArrayList<Librarian>();

    private Blockchain chain = null;
    private String LibraryName = null;

    public Library(String LibraryName){
        this.LibraryName = LibraryName;
    }

    public ArrayList<Book> getCollection() {
        return collection;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

	
	 
	  
	  public String checkOutBook(Patron patron, Book book){ String
	  returnMessage=""; int location = patrons.indexOf(patron); int bookLocation =
	  collection.indexOf(book); if(location > -1 && bookLocation > -1){ int
	  available = collection.get(bookLocation).getCopiesAvailable(); if(available >
	  0) { patron.getCheckedOutList().add(book);
	  collection.get(bookLocation).setCopiesAvailable(available-1); Block next =
	  new Block(collection.toString() + patrons.toString() +
	  librarians.toString()); if (chain == null) { chain = new Blockchain(next); }
	  else { chain.append(next); }
	  returnMessage+="Checked out book "+book+" to patron "+patron+" using chain "
	  +chain+"\n"; } else { returnMessage+="Book:"+book+
	  " is not available at this time, at this library. Perhaps create a waitlist for the book?\n"
	  ; } } if (location <0) { returnMessage+="Patron:"+patron+
	  " is not a patron at this library and cannot check out a book. \nEncourage the person to become a patron!\n"
	  ; } if (bookLocation <0){ returnMessage+="Book:"+book+
	  " is not a book in the colleciton at this library.\n"; }
	  
	  return returnMessage; }
	 
    
    public void addLibrarian(Librarian librarian){
        int location = librarians.indexOf(librarian);
        if(location == -1){
            librarians.add(librarian);
            Block next = new Block(collection.toString()+patrons.toString()+librarians.toString());
            if(chain == null){
                chain = new Blockchain(next);
            }
            else{
                chain.append(next);
            }
        }
    }

    public void addPatron(Patron patron){
        int location = patrons.indexOf(patron);
        if(location == -1) {
            patrons.add(patron);
            Block next = new Block(collection.toString() + patrons.toString() + librarians.toString());
            if (chain == null) {
                chain = new Blockchain(next);
            } else {
                chain.append(next);
            }
        }
    }

	
	 

	  public void addBook(Book book){ int location = collection.indexOf(book);
	  if(location > -1){ int copies =
	  collection.get(location).getCopiesAvailable();
	  collection.get(location).setCopiesAvailable(copies + 1); Block next = new
	  Block(collection.toString()+patrons.toString()+librarians.toString());
	  if(chain == null){ chain = new Blockchain(next); } else { chain.append(next);
	  } } else{ collection.add(book); Block next = new
	  Block(collection.toString()+patrons.toString()+librarians.toString());
	  if(chain == null){ chain = new Blockchain(next); } else { chain.append(next);
	  } } }
	 
    
    public String getLibraryName(){
        return this.LibraryName;
    }

    public Blockchain getChain(){
        return chain;
    }

    @Override
    public String toString() {
        return getChain().printChainVerbose();
    }
}
