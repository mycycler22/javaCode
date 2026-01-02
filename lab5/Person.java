package Lab5;
/**
 * simulates a person super class.
 * A patron and a librarian are both persons.
 */
public class Person {
	private String first_name;
	private String last_name;
	private int person_id;
	
	public Person(String firstName, String lastName, int identifier) {
		first_name = firstName;
		last_name = lastName;
		person_id = identifier;
	}
	public Person() {
		first_name = "unknown";
		last_name = "unknown";
		person_id = 0;
	}
	
	public void setAuthor(String firstName, String lastName) {
		this.first_name = firstName;
		this.last_name = lastName;
	}
	public void setID(int identifier) {
		this.person_id = identifier;
	}
	
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	public int getID() {
		return person_id;
	}
	
	public String toString() {
		return getID() + ": " + getFirstName() + " " + getLastName();
	}
	
	
	
}