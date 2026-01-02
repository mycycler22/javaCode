package hw4;

import java.io.File;
import java.io.IOException;

/** Maze Game for robot simulation program.
 * @author Sherri Weitl-Harms 
 * @version@3.0  Spring2025
 * 
 * You are NOT to modify this program
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
		int dir = bot.chooseMoveDirection(maze);//this method MUST verify that it is a legal move in this current maze
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), ' '); //make the old bot spot back to space
		bot.move(dir);//calls the robot move to let the robot know its new location
		maze.setCell(bot.getCurrentRow(), bot.getCurrentCol(), bot.getRobotName()); //update the robot in the maze
	}

	/** show the maze with the robot in it
	 * 
	 */
	public String toString()
	{
		return maze.toString();
	}


}
