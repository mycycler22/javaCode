package hw5;

import java.io.File;
import java.io.IOException;

/** Maze Game for robot simulation program.
 * @author Sherri Weitl-Harms 
 * @version@3.0  Fall2025
 * 
 * You are NOT to modify this program, unless you want to only mark deadends for the LookAheadRobot.
 * If so, uncomment lines 53 and 54.
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
	public MazeGame(File inputFile, Robot bot) throws IOException
	{
		maze = new Maze(inputFile);
		this.bot = bot;//create the robot and let it know where it is
		this.bot.setCurrentCol(maze.getStartCol()); 
		this.bot.setCurrentRow(maze.getStartRow());
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //set the robot in the maze
	}

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

	/**
	 * simulate the robot moving one step in the maze
	 * the robot chooseMoveDirection method MUST verify that the move is LEGAL
	 */
	public void move()
	{

		char oldSpot = ' ';
		int dir = bot.chooseMoveDirection(maze);//this method MUST verify it is a legal move
		if (bot instanceof LookAheadRobot) //optional to only mark deadends for the LookAheadRobot
			if (((LookAheadRobot) bot).atDeadEnd(maze)) // method return true if robot is at deadend
				if ( bot.atDeadEnd(maze)) // method return true if robot is at deadend
					oldSpot='D';

		
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), oldSpot); //make the old bot spot
		bot.move(dir);//calls the robot move to let the robot know its new location
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
