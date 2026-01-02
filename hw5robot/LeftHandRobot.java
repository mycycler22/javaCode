package hw5;

/** 
 * Class that creates a LeftHandRobot object that inherits the Robot class
 * LeftHandRobot object - primary move of the robot is to turn left
 * 
 * @author Mark Yan
 * @version 11.6.25
 * 
 * 
 */

public class LeftHandRobot extends Robot{
	private int direction;
	
	/**
	 * Constructor for the LeftHandRobot object
	 * 
	 * @param r
	 * @param c
	 */
	
	public LeftHandRobot(int r, int c) {
		super(r, c, 'L');
		this.direction = 2;
	}
	
	/**
	 * Method that returns the direction that the robot is taking
	 * 
	 * @param maze
	 * @return the direction that the robot is taking
	 */
	
	@Override
	public int chooseMoveDirection(Maze maze) {
		int left = (this.direction + 3) % 4;
		if(validMove(left, maze)) {
			this.direction = left;
			return left;
		}
		int straight = this.direction;
		if(validMove(straight, maze)) {
			this.direction = straight;
			return straight;
		}
		int right = (this.direction + 1) % 4;
		if(validMove(right, maze)) {
			this.direction = right;
			return right;
		}
		int back = (this.direction + 2) % 4;
		if(validMove(back, maze)) {
			this.direction = back;
			return back;
		}
		
		return this.direction;
		
	}

}
