package HW6RobotWithCells;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

/**
 * @author Sherri WeitlHarms
  *
 * MazePane "holds" a Robot and Maze for MazeWindow. 
 * It paints the maze and robot into a GUI, 
 * which is a graphical upgrade from System.out.print statements 
 * of the old driver program.
 */
public class MazePane extends Pane{
    private Maze inMaze;
    private Robot robotInMaze;
    private int mazeHeight;
    private int mazeWidth;
    private final double rectSide=30;//size of each square
    Circle robotImg; // the robot is simply drawn as a circle
    final double radius=7.0; //size of the robot circle

    /**
     * Constructor for MazePane
     * @param maze input Maze
     * @param robot input Robot
     */
    public MazePane(Maze maze, Robot robot){
        this.inMaze = maze;
        this.robotInMaze=robot;
        mazeHeight = (int)(inMaze.getRows()*rectSide+95);//add a cushion of pixels
        mazeWidth =  (int)(inMaze.getCols()*rectSide+25); //add a cusion of pixels
        
        
    }

    /**
     * Default constructor, will be used more than the other one.
     * inMaze and robotInMaze will be initialized in MazeWindow.
     */
    public MazePane(){
    	mazeHeight=200;//default value
    	mazeWidth=200; //default value
    	
    }
    
    public Maze getMaze() {
    	return inMaze;
    }

    /**
     * FINISH
     * paint() performs most of the work for MazePane. 
     * It's the primary reason to have
     * a MazePane object, instead of System.out.print
     * be sure to verify that the maze is not null before painting
     * its rows and cols
     * verify the robot is not null before painting it on top of the grid
     */
    public void paint()       
    {
    	
    	
    	if(inMaze == null) {
    		System.out.println("No maze to print");
    		return;
    	}
    	
    	this.getChildren().clear();
    	
    	for(int r = 0; r < inMaze.getRows(); r++) {
    		for(int c = 0; c < inMaze.getCols(); c++) {
    			char cell = inMaze.getCell(r, c);
    			
    			Rectangle rect = new Rectangle(rectSide, rectSide);
    			rect.setX(c * rectSide);
    			rect.setY(r * rectSide);
    			
    			switch(cell) {
    			case '*':
    				rect.setFill(Color.DARKBLUE);
    				break;
    			case ' ':
    				rect.setFill(Color.WHITE);
    				break;
    			case 'S':
    				rect.setFill(Color.GREEN);
    				break;
    			case 'X':
    				rect.setFill(Color.RED);
    				break;
    			default:
    				rect.setFill(Color.LIGHTGRAY);
    				break;
    				
    			}
    			getChildren().add(rect);
    			
    			
    		}
    	
    	}
    	
    	if(robotInMaze != null) {
    		Circle robotImg = new Circle();
    		robotImg.setCenterX(robotInMaze.getCurrentCol() * rectSide + rectSide / 2.0);
        	robotImg.setCenterY(robotInMaze.getCurrentRow() * rectSide + rectSide / 2.0);
        	robotImg.setRadius(radius);
        	robotImg.setFill(Color.BLACK);
        	getChildren().add(robotImg);
    	}

    }

    /**
     * FINISH 
     * calculate and return the height based on maze size
     */
    protected double getMazeHeight(){
    	//update height based on maze size
    	mazeHeight = inMaze.getRows();
    	
    	return mazeHeight;
    	}
  
    /**
     * FINISH 
     * calculate and return the width based on maze size
     */
    protected double getMazeWidth(){
    	//update width based on maze size
    	mazeWidth = inMaze.getCols();
    	
    	return mazeWidth;
    	}
    
    /** Initializes inMaze outside of the constructor
     * you may want to adjust the pane height and width based on the maze sizes
     * @param newMaze initializes inMaze to a Maze object
     */
    public void setMaze(Maze newMaze){
        if(newMaze == null) {
        	return;
        }
    	
        this.inMaze=newMaze;
        paint();
    }

    /**
     * Initializes robotInMaze outside of the constructor
     * @param newRobot initializes robotInMaze to a Robot object
     */
    public void setRobotInMaze(Robot newRobot){
        this.robotInMaze=newRobot;
    }
}
