package hw5;


/** 
 * Class that creates a RightHandRobot object that inherits the Robot class
 * RightHandRobot object - primary move of the robot is to turn right
 * 
 * @author Mark Yan
 * @version 10.27.25
 * 
 * 
 */

public class RightHandRobot extends Robot {
	
	private int direction;
	
	/**
	 * Constructor for the RightHandRobot object
	 * 
	 * @param r
	 * @param c
	 */
	public RightHandRobot(int r, int c) {
		super(r, c, 'R');
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
		int right = (this.direction + 1) % 4;
		if(validMove(right, maze)) {
			this.direction = right;
			return right;
		}
		int straight = this.direction;
		if(validMove(straight, maze)) {
			this.direction = straight;
			return straight;
		}
		int left = (this.direction + 3) % 4;
		if(validMove(left, maze)) {
			this.direction = left;
			return left;
		}
		int back = (this.direction + 2) % 4;
		if(validMove(back, maze)) {
			this.direction = back;
			return back;
		}
		
		return this.direction;
		
	}

}
