package hw5;
import java.util.Random;

/** 
 * Class that creates a RandomRobot object that inherits the Robot class
 * RandomRobot object - movement of the Robot is randomized
 * 
 * @author Mark Yan
 * @version 10.27.25
 * 
 * 
 */

public class RandomRobot extends Robot {
	private Random rand;
	
	/**
	 * Constructor for the RandomRobot object
	 * 
	 * @param row
	 * @param col
	 */
	public RandomRobot(int row, int col) {
		super(row, col, 'r');
		rand = new Random();
		
	}
	
	/**
	 * Method that returns the direction of the robot
	 * 
	 * @param maze
	 * @return the direction that the robot is taking
	 */
	@Override
	public int chooseMoveDirection(Maze maze) {
		int direction = rand.nextInt(4);
		int maxAttempts = 4;
		
		direction = rand.nextInt(4);
		
		for(int i = 0; i < maxAttempts; i++) {
			if(validMove(direction, maze)) {
				return direction;
			}
			direction = (direction + 1) % 4;
		}
		
		
		return direction;
	}

}
