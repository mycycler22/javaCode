package inheritanceBonus;

/**
 * Bird class that inherits the Animal class in the construction of a Bird object
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */
public class Bird extends Animal {
	
	private double wingSpan;
	
	/**
	 * Constructor of the Bird object
	 * 
	 * @param name
	 * @param wingSpan
	 */
	public Bird(String name, double wingSpan) {
		super(name);
		this.wingSpan = wingSpan;
	}
	
	/**
	 * Method that returns the sound of the Bird
	 * 
	 */
	@Override
	public String makeSound() {
		return "tweet";
	}
	
	/**
	 * toString method that returns the name and the sound of the bird object
	 * 
	 */
	@Override
	public String toString() {
		return name + " has a wing span of " + wingSpan + " and says " + makeSound();
	}

}
