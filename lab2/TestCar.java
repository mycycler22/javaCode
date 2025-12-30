package lab2;

import java.util.Scanner;
import java.util.List;


/**
 * TestCar
 * Tests the collections.Car object class by
 * simulating three cars driving home and back to school.
 * This does not match reality. We don't first accelerate, and then move.
 * You don't need to match the driving instructions perfectly either.
 * This is just to practice the use of objects.
 *
 * CSC222
 * Lab 2
 * @author Mark Yan
 */
public class TestCar {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
        Car sherriCar = new Car("Dr. WeitlHarms", 90);
        // Get on the interstate at 75 mph
        for (int i = 0; i * 5 < 75; i++)
            sherriCar.accelerate(); //we accelerate 5 mph at a time
        //Drive Dr. WeitlHarms to see her kids in Lincoln - 50 minutes at 75 mph
        for (int i = 0; i < 50; i++)
            sherriCar.move(); //move  one mile at a time
        //when she gets to the Lincoln city limits, slow her car to 65 mph and then drive for 10 miles
        for (int i = 0; i < 2; i++)
            sherriCar.brake();
        for (int i = 0; i < 10; i++)
            sherriCar.move();
        for(int i = 0; i < 13; i++) {
        	sherriCar.brake();
        }
        
        //output car information - showing how far she drove
        System.out.println(sherriCar);

        //create a car for you if you can drive home (or another CSC222 student if your home is across the ocean)
        // drive your car home - exact details are not necessary, this is just for fun
        //output car info
        
        
        Car markRide = new Car("Mark Yan", 120);
        
        for(int i = 0; i * 5 < 45; i++) { // max speed on road is 45 mph
        	markRide.accelerate();
        }
        
        for(int i = 0; i < 10; i++) { // 45 mph for 10 miles
        	markRide.move();
        }
        for(int i = 0; i < 3; i++) { // speed limit is 30 mph
        	markRide.brake();
        }
        for(int i = 0; i < 5; i++) { // 30 mph for the next 5 miles
        	markRide.move();
        }
        for(int i = 0; i < 6; i++) {
        	markRide.brake();
        }
        
        
        System.out.println(markRide);

        //create a car for a second CSC222 student
        //bonus to ask the user for the values
        //drive their car home (exactness is not necessary), this is just for fun
        //output car info
        
        System.out.println("Who is the owner of the car?");
        String owner = scanner.nextLine();
        System.out.println("What's the max speed of the car?");
        int maxSpeed = scanner.nextInt();
        
        Car randomRide = new Car(owner, maxSpeed);
        
        for(int i = 0; i * 5 < 80; i++) { // interstate speed limit is 80 mph
        	randomRide.accelerate();
        }
        for(int i = 0; i < 300; i++) {
        	randomRide.move();
        }
        for(int i = 0; i < 7; i++) { // speed limit down to 45 mph
        	randomRide.brake();
        }
        for(int i = 0; i < 10; i++) { // 10 miles on local road
        	randomRide.move();
        }
        for(int i = 0; i < 3; i++) { // speed limit down to 30 mph
        	randomRide.brake();
        }
        for(int i = 0; i < 2; i++) { // 2 miles on local road
        	randomRide.move();
        }
        for(int i = 0; i < 6; i++) {
        	randomRide.brake();
        }
        
        System.out.println(randomRide);
        
        

        //check to see who drove the farthest (in code)
        //output the car that drove the farthest
        // output the car that drove the longest amount of time
        
        if(sherriCar.getdistanceTraveled() > randomRide.getdistanceTraveled() && sherriCar.getdistanceTraveled() > markRide.getdistanceTraveled()) {
        	System.out.println("Most distance: " + sherriCar.getdistanceTraveled() + " miles by: " + sherriCar.getOwner());
        }
        else if(markRide.getdistanceTraveled() > randomRide.getdistanceTraveled() && markRide.getdistanceTraveled() > sherriCar.getdistanceTraveled()) {
        	System.out.println("Most distance: " + markRide.getdistanceTraveled() + " miles by: " + markRide.getOwner());
        }
        else {
        	System.out.println("Most distance: " + randomRide.getdistanceTraveled() + " miles by: " + randomRide.getOwner());
        }
        
        
        if(sherriCar.getTripTime() > markRide.getTripTime() && sherriCar.getTripTime() > randomRide.getTripTime()) {
        	System.out.println("Longest duration of travel: " + String.format("%.2f", sherriCar.getTripTime()) + " minutes by: " + sherriCar.getOwner());
        }
        else if(markRide.getTripTime() > sherriCar.getTripTime() && markRide.getTripTime() > randomRide.getTripTime()) {
        	System.out.println("Longest duration of travel: " + String.format("%.2f", markRide.getTripTime()) + " minutes by: " + markRide.getOwner());
        }
        else {
        	System.out.println("Longest duration of travel: " + String.format("%.2f", randomRide.getTripTime()) + " minutes by: " + randomRide.getOwner());
        }
        
        
        
         //Bonus: test the car copy constructor

    }
}
