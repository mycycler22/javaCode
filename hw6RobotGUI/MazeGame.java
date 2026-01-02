package HW6RobotWithCells;

import java.io.File;
import java.io.IOException;


/** Maze Game for robot simulation program.
 * @author Sherri Weitl-Harms 
 * @version@4.0 Fall 2025
 * 
 * You are NOT to modify this program
 * 
 * This version is for HW6  and is a slight modification from the version used in HW4 and 5.
 */


public class MazeGame  {
	Maze maze;
	Robot bot;

	/**
	 * construct the game from the file
	 * @param inputFile - input file to share with the Maze to set the maze structure
	 * @param bot - the bot this game is going to use
	 * @throws IOException
	 */
	public MazeGame(File inputFile, Robot bot) 
	{
		maze = new Maze(inputFile);
		if (bot!=null)
		{
			this.bot = bot;//create the robot and let it know where it is
			this.bot.setCurrentCol(maze.getStartCol()); 
			this.bot.setCurrentRow(maze.getStartRow());
			maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //set the robot in the maze
		}
	}

	public Maze getMaze() {return maze;}

	/**
	 * Detect if the robot is at the exit of the maze
	 * @return
	 */
	public boolean solved()
	{
		if (bot.getCurrentCol()==maze.getExitCol()&&bot.getCurrentRow()==maze.getExitRow())
			return true;
		else return false;
	}

	public void setRobot(Robot r)
	{
		if (r!=null&& maze!=null)
		{
			this.bot = r;//create the robot and let it know where it is
			this.bot.setCurrentCol(maze.getStartCol()); 
			this.bot.setCurrentRow(maze.getStartRow());
			maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //set the robot in the maze
		}
	}
	
	/**
	 * simulate the robot moving one step in the maze
	 * the robot chooseMoveDirection method MUST verify that the move is LEGAL
	 */
	public void move()
	{
		//		int dir = bot.chooseMoveDirection(maze);//this method MUST verify that it is a legal move in this current maze
		//		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), ' '); //make the old bot spot back to space
		//		bot.move(dir);//calls the robot move to let the robot know its new location
		//		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //update the robot in the maze

		char oldSpot = ' ';
		int dir = bot.chooseMoveDirection(maze);//this method MUST verify it is a legal move
		//		if (bot instanceof LookAheadRobot)
		//			if (((LookAheadRobot) bot).atDeadEnd(maze)) // method return true if robot is at deadend
		if ( bot.atDeadEnd(maze)) // method return true if robot is at deadend
			oldSpot='D';
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), oldSpot); //make the old bot spot
		bot.move(dir);//calls the robot move to let the robot know its new location
	//	System.out.println(maze.toString());
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //update the robot
	}



	/** show the maze with the robot in it
	 * 
	 */
	public String toString()
	{
		return maze.toString();
	}


}
