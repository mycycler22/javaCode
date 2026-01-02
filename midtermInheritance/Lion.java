package midtermPractice;

/**
 * Stores information about a Lion
 * 
 */

public class Lion extends Animal {
	
	private double maneLength;
	
	/**
	 * Constructor for a Lion object
	 * 
	 * @param animal_name
	 * @param animal_age
	 * @param length
	 */
	public Lion(String animal_name, int animal_age, double length) {
		super(animal_name, animal_age);
		maneLength = length;
	}
	
	/**
	 * Getter method for the Lion's mane length
	 * 
	 * @return Mane length of the Lion object
	 */
	
	public double getMane() {
		return maneLength;
	}
	
	/**
	 * Method that prints what a Lion says
	 * Overrides the speak() method in the Animal class
	 * 
	 */
	@Override
	public void speak() {
		System.out.println("Lion Roars");
	}

}
