package Lab5;

/**
 * Simulates storing a library book object
 */
public class Book {
	private String title;
	private String first_name;
	private String last_name;
	private String id_number; //ISBN identifier
	private int copies;
	
	
	public Book(String bookTitle, String author_first, String author_last, String id, int available) {
		title = bookTitle;
		first_name = author_first;
		last_name = author_last;
		id_number = id;
		copies = available;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String first, String last) {
		this.first_name = first;
		this.last_name = last;
	}
	public void setID(String isbn) {
		this.id_number = isbn;
	}
	public void setCopiesAvailable(int available) {
		this.copies = available;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthorFirst() {
		return first_name;
	}
	public String getAuthorLast() {
		return last_name;
	}
	public String getID() {
		return id_number;
	}
	public int getCopiesAvailable() {
		return copies;
	}
	
	public String toString() {
		return "Title: " + getTitle() +
				" Author: " + getAuthorFirst() + ", " + getAuthorLast() + 
				" ISBN #: " + getID();
				
	}
	
	
	
	
  }


