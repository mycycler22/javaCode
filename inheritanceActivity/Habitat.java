package inheritanceBonus;

import java.util.ArrayList;
import java.util.List;

/**
 * Habitat class that adds Animal objects to a list and prints out each element
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */

public class Habitat<T extends Animal> {
	
	private List<T> animals;
	
	/**
	 * Constructor for a habitat object
	 * 
	 */
	public Habitat() {
		// TODO Auto-generated constructor stub
		animals = new ArrayList<>();
	}
	
	/**
	 * Void method that adds the animal to the animals list
	 * 
	 * @param animal
	 */
	public void addAnimal(T animal) {
		animals.add(animal);
	}
	
	/**
	 * Void method that prints the animals in the habitat
	 * 
	 * 
	 */
	public void printAnimals() {
		if(animals.isEmpty()) {
			System.out.println("There are no animals in the habitat");
		}
		else {
			for(T animal: animals) {
				System.out.println(animal);
			}
		}
	}

}
