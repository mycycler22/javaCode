package lab2;

/********************************************************************
 Car.java
 @author Mark Yan
@version 
 Represents a car that can accelerate, brake, and move
 Used in the TestCar program;
 ********************************************************************/

public class Car {
    private static final int DEFAULTMAXSPEED = 100;
    //declare private member variables here
    private String owner;
    private double currentSpeed;  //in terms of mph
    private double distanceTraveled;  // in terms of miles
    private double tripTime;
    private int maxSpeed; //in terms of mph

    /**
     * Constructor initializes a car
     *
     * @param newOwner    - owner of the car
     * @param newMaxSpeed - max speed of the car
     */
    public Car(String newOwner, int newMaxSpeed) {
        owner = newOwner;
        currentSpeed = 0;
        maxSpeed = newMaxSpeed;
        distanceTraveled = 0;
        tripTime = 0;
    }

    /**
     * Default constructor
     */
    public Car() {
        this("no owner", DEFAULTMAXSPEED);
    }

    //BONUS - add copy constructor. Be sure to test it in the TestCar program.
    
    
    

    /**
     * Moves 1 mile + time of the movement segment
     */
    public void move() {
        distanceTraveled += 1;
        tripTime += (1.0/currentSpeed) * 60;
    }

    /**
     * Add 5 miles per hour to current speed
     */
    public void accelerate() {
        if(currentSpeed <= maxSpeed) {
        	currentSpeed = currentSpeed + 5;
        }
        
    }

    /**
     * Reduces the speed to the given speed limit
     */
    public void brake() {
        if(currentSpeed > 0) {
        	currentSpeed = currentSpeed - 5;
        }
    	
    }


    //ADD MUTATOR METHODS for:
    //owner
    //max speed
    
    /**
     * Mutator method for the owner of the vehicle
     */
    
    public void setOwner(String newOwner) {
    	this.owner = newOwner;
    	
    }
    
    /**
     * Mutator method for the max speed of the vehicle
     */
    
    public void setMaxSpeed(int newMaxSpeed) {
    	this.maxSpeed = newMaxSpeed;
    }

    //UPDATE ALL JAVA DOC as needed
    
    
    /**
     * @return the current speed of the car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the max speed of the car
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @return the distance traveled for the car
     */
    public double getdistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * @return the owner of the car
     */
    public String getOwner() {
        return owner;
    }
    
    /**
     * @return the duration of the trip in minutes
     */
    public double getTripTime() {
    	return tripTime;
    }

    /**
     * @return the car values as a String
     */
    public String toString() {
        String carValue = owner + "'s car current speed: " + currentSpeed +
                " MPH, distance traveled: " + String.format("%8.2f",distanceTraveled) +
                " miles, trip time in minutes: "+String.format("%8.2f",tripTime);
        return carValue;
    
    
    }
    
    
    	    
}


