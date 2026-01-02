package interfaceBonus;

/**
 * Student class that creates a student object with a student ID, name, and GPA
 * 
 * @author Mark Yan
 * @version 12.7.25
 * 
 */

public class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private double gpa;
	
	/**
	 * Constructor for the student object
	 * 
	 * @param id
	 * @param name
	 * @param gpa
	 */
	
	public Student(int id, String name, double gpa) {
		
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		
	}
	
	/**
	 * Getter method that returns the student ID
	 * 
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Getter method that returns the student's name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method that returns the student's GPA
	 * 
	 * @return gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	/**
	 * To String method
	 * @return student information
	 */
	public String toString() {
		return "Student{id = " + id + ", name = '" + name + "', gpa = " + gpa + "}";
	}
	
	/**
	 * compareTo method that reorders students by their GPA
	 * 
	 */
	@Override
	public int compareTo(Student other) {
		int compareGPA = Double.compare(this.gpa, other.gpa);
		if(compareGPA == 0) {
			return this.name.compareTo(other.name);
		}
		return compareGPA;
		
	}

}
