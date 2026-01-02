package lab4;

/********************************************************************
 Car.java
 Author: Mark Yan
Lab 4 CSC222 
 Represents a car that can accelerate, brake, and move
 Used in the racetest program
 ********************************************************************/

public class Car {
    private static final int DEFAULTMAXSPEED = 100;
    //declare private member variables here
    private String owner;
    private double currentSpeed;  //in terms of mph
    private double distanceTraveled;  // in terms of miles
    private double tripTime; //in terms of minutes
    private double maxSpeed; //in terms of mph

    /**
     * Constructor initializes a car
     * @param newOwner    - owner of the car
     * @param newMaxSpeed - max speed of the car
     */
    public Car(String newOwner, double newMaxSpeed) {
        this.setOwner(newOwner);
        this.setCurrentSpeed(0);
        this.setMaxSpeed(newMaxSpeed);
        this.setDistanceTraveled(0);
        this.setTripTime(0);
    }

    /**
     * Copy Constructor
     * @param another - the copied car
     */
    public Car(Car another) {
        this.setOwner(another.getOwner());
        this.setCurrentSpeed(another.getCurrentSpeed());
        this.setMaxSpeed(another.getMaxSpeed());
        this.setDistanceTraveled(another.getDistanceTraveled());
        this.setTripTime(another.getTripTime());
    }

    /**
     * Default constructor
     */
    public Car() {
        this("no owner", DEFAULTMAXSPEED);
    }

    /**
     * Move the car the distance it can travel at its current speed for 1 mile
     * (update the distance traveled and trip time variables)
     */
    public void move() {
    	if (currentSpeed>0)
    	{
         distanceTraveled ++ ;
         tripTime +=60.0/currentSpeed;
    	}
    }

    /**
     * Add 5 miles per hour to current speed
     * Remember: The most the current speed can be is the maxSpeed of the car
     */
    public void accelerate() {
        currentSpeed += 5;
        if (currentSpeed > maxSpeed)
            currentSpeed = maxSpeed;
    }

    /**
     * Subtracts 5 miles per hour from current speed
     * Remember: The minimum speed for the current speed is 0
     */
    public void brake() {
        currentSpeed -= 5;
        if (currentSpeed < 0)
            currentSpeed = 0;
    }

    /**
     * Get Current Speed
     * @return the current speed of the car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * set current speed - should not be used except by copy constructor
     * typically car is moved, rather than current speed just "set"
     * @param inSpeed - speed to set
     */
    public void setCurrentSpeed(double inSpeed) {currentSpeed =inSpeed;}

    /**
     * Get Max Speed
     * @return the max speed of the car
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Set Max speed
     * @param speed max speed to set
     */
    public void setMaxSpeed(double speed) {
        maxSpeed = speed;
    }

    /**
     * Get distance traveled
     * @return the distance traveled for the car
     */
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * set distance traveled
     * only used on constructors; typically "move" changes distance traveled
     * @param distance distance to set
     */
    public void setDistanceTraveled(double distance) {
        distanceTraveled=distance;
    }

    /**
     * get trip time
     * @return trip time
     */
    public double getTripTime() {return tripTime;}

    /**
     * maybe used in copy constructor. typically move changes trip time
     * @param time time to set
     */
    public void setTripTime(double time) {
        tripTime=time;
    }

    /**
     * Get owner
     * @return owner of the car
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set owner
     * @param o - new owner of the car
     */
    public void setOwner(String o) {
        owner = o;
    }

      /**
       * to string method for output
     * @return the car values as a String
     */
    public String toString() {
         String carValue = owner + "'s car current speed: " + currentSpeed +
                " MPH, distance traveled: " + String.format("%8.2f",distanceTraveled) + 
                " miles, trip time in minutes: "+String.format("%8.2f",tripTime);

        return carValue;
    }


    /**
     * reset the distance traveled, to start a new race.
     */
    public void resetDistance() {
        distanceTraveled = 0;
    }

    /**
     * reset the distance traveled, to start a new race.
     */
    public void resetTime() {
        tripTime = 0;
    }

    /**
     * reset the speed, to start a new race.
     */
    public void resetCurrentSpeed() {
        currentSpeed = 0;
    }
}
