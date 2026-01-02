package midtermPractice;

/**
 * Stores information about an Animal
 * 
 */


public class Animal {
	private String name;
	private int age;
	
	/**
	 * Constructs an Animal object
	 * 
	 * @param animal_name
	 * @param animal_age
	 */
	
	public Animal(String animal_name, int animal_age) {
		name = animal_name;
		age = animal_age;
		
		
	}
	
	/**
	 * Getter method for the Animal's name
	 * @return name of the Animal
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method for the Animal's age
	 * 
	 * @return age of the animal
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Void method that prints what the animal says
	 * 
	 */
	public void speak() {
		System.out.println("Animal makes a sound");
	}

}
