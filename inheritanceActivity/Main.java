package inheritanceBonus;

public class Main {

	public static void main(String[] args) {
	    // Creating instances of Bird and Fish
	    Bird sparrow = new Bird("Sparrow", 25.0);
	    Fish clownfish = new Fish("Clownfish", "Saltwater");

	    // Creating habitats for birds and fish
	    Habitat<Bird> birdHabitat = new Habitat<>();
	    Habitat<Fish> fishHabitat = new Habitat<>();

	    // Adding animals to their respective habitats
	    birdHabitat.addAnimal(sparrow);
	    fishHabitat.addAnimal(clownfish);

	    // Printing out details of the animals in each habitat
	    System.out.println("Bird Habitat:");
	    birdHabitat.printAnimals();

	    System.out.println("\nFish Habitat:");
	    fishHabitat.printAnimals();

	}

}
