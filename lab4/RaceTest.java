package lab4;

import java.util.ArrayList;

/**
 * Race driver
 * 
 * @author Mark Yan
 */
public class RaceTest {

    public static void main(String[] args) {

        Car sherriCar = new Car("Sherri", 85);
        Car labPartnerCar = new Car("Lab Partner", 100);
        Car yourCar = new Car("Dummy", 100);

          Race race = new Race();
			race.setDistance(500);
			race.addCar(sherriCar);
			race.addCar(labPartnerCar);
			race.addCar(yourCar);
			race.runRace();

			System.out.println("The results of the race is: ");
			System.out.println(race.toString());
			System.out.println("_______________________");

			
			// Second Race test statements:

	
			Race secondRace = new Race(); // a copy of the race - lets race with copies of the cars!
            secondRace.setDistance(500);
    		ArrayList<Car> carsCopy = race.getCars();
			for (int i = 0; i < carsCopy.size(); i++) {
				Car copy = carsCopy.get(i);
				copy.setMaxSpeed(copy.getMaxSpeed() * 2);  //first we will modify the cars, making them faster
				copy.setOwner(copy.getOwner()+" COPY");
				copy.resetCurrentSpeed();    //reset copy car engine
				copy.resetDistance();        //reset copy car distance to 0
				copy.resetTime();            //reset copy car time
				secondRace.addCar(copy);    //add the copy car to the race
				System.out.println("Copied car: " + copy);
			}

			Car anotherCar = new Car("Santa", 100);
			secondRace.addCar(anotherCar);
			System.out.println("Additional car: " + anotherCar);
			System.out.println("_______________________");

			// check winner at beginning of race
			System.out.println("Second race winner: " + secondRace.getWinner());
			System.out.println("_______________________");

			secondRace.runRace();

			System.out.println("The results of the second race is: ");
			System.out.println(secondRace.toString());
			System.out.println("_______________________");

			System.out.println("To verify that the second race did not change the cars in the first race.");
			ArrayList<Car> carsInFirstRace = race.getCars();
			for (Car c : carsInFirstRace) {
				System.out.println(c.getOwner() + "\t" + c.getDistanceTraveled());
			}
			System.out.println("_______________________");
			ArrayList<Car> carsInSecondRace = secondRace.getCars();
			for (Car c : carsInSecondRace)
				System.out.println(c.getOwner() + "\t" + c.getDistanceTraveled());

    }

}
