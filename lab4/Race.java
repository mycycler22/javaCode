package lab4;

import java.util.ArrayList;

/**
 * Race class used to simulate a race of cars
 * the cars are stored in an ArrayList
 * Uses a dice to decide which car and what action to take as the race progresses
 * Simulates a race between the number of cars in an ArrayList. 
 *
 * CSC222 lab 4
 *
 * @author Mark Yan
 */

public class Race {
    private static final double DEFAULTRACEDISTANCE = 500;
    private ArrayList<Car> raceCars;
    private double distance;
    private Car winner;  //starts as null - when the race is not finished.

    /**
     * Makes a default, empty ArrayList
     * Sets the distance to the default race distance (500)
     * The winner is unknown (null)
     */
    public Race() {
    	
    	raceCars = new ArrayList<Car>();
    	distance = DEFAULTRACEDISTANCE;
    	winner = null;
    	
   }

    /**
     * Sets the distance of the race
     * @param inDistance - distance of the race
     */
    public void setDistance(double inDistance) {
    	this.distance = inDistance;
    	
    }

    /**
     * Void method that sets the winner by pulling the list at the winning index
     * @param winningCarIndex - index in the ArrayList of the winning car
     */
    private void setWinner(int winningCarIndex) {
        winner = raceCars.get(winningCarIndex);
    }

    /**
     * Returns the String value of the winner
     * If the winner is unknown, return the phrase Race winner is unknown at this time
     * @return string value of the winning car
     */
    public String getWinner() {
    	if(winner == null) {
    		return "Winner is unknown at this time";
    	}
    	return winner.toString();
    	
    	
    }

    /**
     * Getter method that gets the number of cars in the race
     * @return number of cars in the race
     */
      public int getCarCount() {
    	  return raceCars.size();
      }

    /**
     * Void method that adds a car to the ArrayList/race
     * @param car - car to be added to the race
     */
    public void addCar(Car car) {
    	raceCars.add(new Car(car));
    	
    }

    /**
     * Getter method that gets the set distance of the race
     * @return distance of the race
     */
    public double getDistance() {
    	return distance;
    }

    /**
     * Copies the initial arrayList in this method
     * @return a copy of the arraylist of cars. Each car in the new arraylist, should also be a copy.
     */
    public ArrayList<Car> getCars() {
    	ArrayList<Car> copy = new ArrayList<Car>();
    	for(Car car:raceCars){
    		copy.add(new Car(car));
    	}
    	return copy;
    }

    /**
     * toString method
     * @return the results of the race
     */
  public String toString() {
	  String output="Race distance: "+ distance+
			  "\nCar count: "+ raceCars.size()+
			  "\nCars: ";
	  for (Car c:raceCars)
		  output+=c+"\n";
	  if (winner!=null)
		  output+="won by: "+winner;	
	  return output;
  }

  /**FINISH
  * method used to simulate running the race
  * Creates a dice according to the number of cars in the race
  * While loop while the winner is unknown
  * While the winner is unknown, diceRoll simulates a roll of the dice
  * The roll dictates which car in the ArrayList is selected
  * The roll also dictates the action the car takes
  * If the action = 0 - the car moves
  * If the action = 1 - the car brakes
  * If the action = 2 - the car accelerates
  * Loop ends once a car reaches the race distance
  */
    public void runRace() {
    	Dice raceDice = new Dice(raceCars.size()*3);
    	
    	while(winner == null) {
    		int diceRoll = raceDice.roll();
    		int carSelected = (diceRoll - 1)/3;
    		int action = (diceRoll - 1) % 3;
    		
    		if(action == 0) {
    			raceCars.get(carSelected).move();
    		}
    		else if(action == 1) {
    			raceCars.get(carSelected).brake();
    		}
    		else {
    			raceCars.get(carSelected).accelerate();
    		}
    		
    		if(raceCars.get(carSelected).getDistanceTraveled() >= distance) {
    			setWinner(carSelected);
    			break;
    			
    			
    		}
    	}
    	
    	
      }

}
