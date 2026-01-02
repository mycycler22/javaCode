package inheritanceBonus;

/**
 * Animal class that constructs an Animal object
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */

public abstract class Animal {
	
	protected String name;
	
	/**
	 * Constructor of an Animal object
	 * 
	 * @param name
	 */
	public Animal(String name) {
		this.name = name;
	}
	
	/**
	 * Abstract method for the animal's sound
	 * 
	 * @return
	 */
	public abstract String makeSound();
	
	/**
	 * toString method for the Animal object
	 * 
	 */
	public String toString() {
		return "Animal name: " + name + "Sound: " + makeSound();
	}
	
	
	
}
