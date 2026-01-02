package hw5;

import java.util.Random;

/** 
 * Class that creates a LookAheadRobot object that inherits the Robot class
 * LookAheadRobot object - if the robot detects a valid direction, they will continue in that direction
 * until they run into a wall or dead end
 * 
 * @author Mark Yan
 * @version 11.6.25
 * 
 * 
 */


public class LookAheadRobot extends Robot {
	
	private Random rand;
	private int direction;
	
	/**
	 * Constructor for the LookAheadRobot object
	 * 
	 * @param r
	 * @param c
	 */
	
	
	public LookAheadRobot(int r, int c) {
		super(r, c, 'O');
		this.rand = new Random();
		this.direction = rand.nextInt(4);
	}
	
	/**
	 * Method that returns the direction that the robot is taking
	 * 
	 * @param maze
	 * @return the direction that the robot is taking
	 */
	
	@Override
	public int chooseMoveDirection(Maze maze) {
		if(validMove(direction, maze)) {
			return direction;
		}
		else {
			direction = rand.nextInt(4);
			return chooseMoveDirection(maze);
		}
		
	}
	
	

}
