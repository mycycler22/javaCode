package inheritanceBonus;

/**
 * Fish class that inherits the Animal class in the construction of a Fish object
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */

public class Fish extends Animal{
	
	private String waterType;
	
	/**
	 * Fish constructor
	 * 
	 * @param name
	 * @param waterType
	 */
	public Fish(String name, String waterType) {
		// TODO Auto-generated constructor stub
		super(name);
		this.waterType = waterType;
	}
	
	/**
	 * Method that returns the sound the animal makes
	 * 
	 */
	@Override
	public String makeSound() {
		return "bubble";
	}
	
	/**
	 * toString method that prints the Fish object
	 * 
	 */
	@Override
	public String toString() {
		return name + " lives in " + waterType + " and says " + makeSound();
	}
	
}
