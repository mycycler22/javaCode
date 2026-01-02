package midtermPractice;

/**
 * Stores information about a Parrot
 * 
 */

public class Parrot extends Animal{

	private String featherColor;
	
	/**
	 * Constructs a Parrot object
	 * 
	 * @param animal_name
	 * @param animal_age
	 * @param color
	 */
	
	public Parrot(String animal_name, int animal_age, String color) {
		super(animal_name, animal_age);
		featherColor = color;
	}
	
	/**
	 * Getter method to get the Parrot's feather color
	 * 
	 * @return the Parrot's feather color
	 */
	public String getColor() {
		return featherColor;
	}
	
	/**
	 * Void method that prints what a Parrot says
	 * Overrides the speak() method in the Animal class
	 */
	@Override
	public void speak() {
		System.out.println("Parrot Speaks");
	}

}
