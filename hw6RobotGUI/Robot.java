package HW6RobotWithCells;

/** 
 * The abstract class for creating a Robot object
 * 
 * @author Mark Yan
 * @version 10.27.25
 * 
 * 
 */

public abstract class Robot {

	private int currentRow;
	private int currentCol;
	private char robotName;
	
	/**
	 * Constructor for the Robot object
	 * 
	 * @param row
	 * @param col
	 * @param name
	 */
	public Robot(int row, int col, char name) {
		this.currentRow = row;
		this.currentCol = col;
		this.robotName = name;
	}
	/**
	 * Getter method for the row of the robot's current location
	 * 
	 * @return the row where the robot is currently located
	 */
	public int getCurrentRow() {
		return currentRow;
	}
	/**
	 * Getter method for the column of the robot's current location
	 * 
	 * @return the column where the robot is currently located
	 */
	public int getCurrentCol() {
		return currentCol;
	}
	/**
	 * Getter method for the type of robot
	 * 
	 * @return the type of robot
	 */
	public char getRobotName() {
		return robotName;
	}
	/**
	 * Void method that sets the row of the robot's location
	 * 
	 * @param row
	 */
	public void setCurrentRow(int row) {
		this.currentRow = row;
	}
	/**
	 * Void method that sets the column of the robot's location
	 * 
	 * @param col
	 */
	public void setCurrentCol(int col) {
		this.currentCol = col;
	}
	/**
	 * Method that lets the robot keep track of where its at and the validity of the move
	 * 
	 * @param direction
	 * @return if the move is valid (true) or invalid (false)
	 */
	public boolean move(int direction) {
		int newRow = currentRow;
		int newCol = currentCol;
		
		switch(direction) {
			case 0: 
				newRow--; 
				break;
			case 1: 
				newCol++; 
				break;
			case 2: 
				newRow++; 
				break;
			case 3: 
				newCol--; 
				break;
			default: 
				return false;
			
		}
		this.currentRow = newRow;
		this.currentCol = newCol;
		
		return true; 
	}
	/**
	 * Boolean method that tests if the move that the robot makes hits a wall or not
	 * 
	 * @param direction
	 * @param maze
	 * @return whether the robot's move goes to a white space (true) or hits a wall (false)
	 */
	public boolean validMove(int direction, Maze maze) {
		int newRow = currentRow;
		int newCol = currentCol;
		
		switch(direction) {
			case 0:
				newRow--;
				break;
			case 1:
				newCol++;
				break;
			case 2:
				newRow++;
				break;
			case 3:
				newCol--;
				break;
			default:
				return false;
				
		}
		
		if(newRow < 0 || newCol < 0 || newRow > maze.getRows() || newCol > maze.getCols()) {
			return false;
		}
		
		char nextCell = maze.getCell(newRow, newCol);
		if(nextCell == '*') {
			return false;
		}
		
		return true;
		
	}
	/**
	 * 
	 * Boolean method that detects if the robot is at a dead end or not and is not at the start
	 * or end of the maze
	 * 
	 * @param maze
	 * @return true if at dead end, false if not at dead end or at the start or the end of the maze
	 */
	
	public boolean atDeadEnd(Maze maze) {
		if(maze.getCell(currentRow, currentCol) == 'S' || maze.getCell(currentRow, currentCol) == 'X') {
			return false;
		}
		int validMoves = 0;
		
		if(validMove(0, maze)) {
			validMoves++;
		}
		if(validMove(1, maze)) {
			validMoves++;
		}
		if(validMove(2, maze)) {
			validMoves++;
		}
		if(validMove(3, maze)) {
			validMoves++;
		}
		
		return validMoves == 1;
		
		
	}
	
	public boolean solved(Maze maze) {
		return currentRow == maze.getExitRow() && currentCol == maze.getExitCol();
	}
	

	/**
	 * Abstract method for all robots
	 * 
	 * @param maze
	 * 
	 */
	public abstract int chooseMoveDirection(Maze maze);
	

	
}
