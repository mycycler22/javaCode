package midtermPractice;

import java.util.ArrayList;

public class ZooApp {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Lion("Simba", 5, 12.5));
        animals.add(new Parrot("Polly", 2, "Green"));
        animals.add(new Dolphin("Flipper", 7, "Long"));

        for (Animal animal : animals) {
            animal.speak();
            if(animal instanceof Dolphin) {
            	System.out.println(((Dolphin) animal).swim());//prints the instances where a dolphin object appears
            }
            
        }
    }
}
