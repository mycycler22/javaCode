package hw4;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/** Maze driver method for robot simulation program.
 * @author Mark Yan
 * @version@3.0  Fall2025
 * 
 * the only change you need to make in this program is selecting the robot to run through the MazeGame.
 */
public class MazeDriver {

	public static void main(String[] args) throws IOException {
		File inputFile = getFile();  //sample: testmaze.txt
		//Robot bot = new RandomRobot(0, 0);//set the kind of robot
		Robot bot = new RightHandRobot(0, 0);//set the kind of robot
		MazeGame mygame = new MazeGame(inputFile,bot);
		System.out.println(mygame);
		System.out.println("\n");
		int k=0;
		
		for (k = 0; k < 10000&& !mygame.solved(); k++) //this prevents an infinite loop if the robot gets stuck
		{
			mygame.move();
			System.out.println(mygame);
		}
		if (mygame.solved())
			System.out.println("The robot solved the maze in "+(k-1) +" steps");
		else
			System.out.println("After "+(k-1) +" steps, the robot failed to solve the maze.");
		
		//System.out.println(maze.getStartRow() + "," +  maze.getStartCol());
		
	}
		

	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{
			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}

}