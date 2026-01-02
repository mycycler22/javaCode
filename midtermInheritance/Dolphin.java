package midtermPractice;

/**
 * Stores information about a Dolphin
 * 
 */

public class Dolphin extends Animal implements Swimmable{
	
	private String bottleNoseType;
	
	/**
	 * Constructor for a new Dolphin project
	 * 
	 * @param animal_name
	 * @param animal_age
	 * @param nose
	 */
	public Dolphin(String animal_name, int animal_age, String nose) {
		super(animal_name, animal_age);
		bottleNoseType = nose;
	}

	/**
	 * Getter method to get the Dolphin's nose type
	 * 
	 * @return nose type
	 */
	public String getNoseType() {
		return bottleNoseType;
	}
	
	/**
	 * Method from Swimmable interface
	 * @return swim instance
	 */
	public String swim() {
		return "Dolphin swims gracefully";
	}
	
	/**
	 * Void method that prints a dolphin speak
	 * 
	 */
	@Override
	public void speak() {
		System.out.println("Dolphin Clicks.");
	}


}
