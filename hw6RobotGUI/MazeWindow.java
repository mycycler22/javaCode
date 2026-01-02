package HW6RobotWithCells;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.MenuBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import javafx.util.Duration;

/**
 * @author Sherri Weitl-Harms
 * 
 *
 * MazeWindow will animate the Robot class moving through a Maze 
 * in a Javafx environment.
 * The robot will be "in" a Maze in a MazePane for JavaFX output. 
 * There is no "driver" class,
 * the start/stop and selection of maze and 
 * robot is all done through menus within MazeWindow.
 *
 * Algorithm:
 * 1. Create window, menus, and MazePane object
 * 3. Read a Maze into a MazePane and paint the maze
 * 4. Set the robot in the start position
 * 5. Animate movement
 */

public class MazeWindow extends Application {

    Stage stage;
    Maze maze;
    Robot robot;
    MazePane pane;
    Menu robotMenu;
    Menu fileMenu;
    Menu goMenu;
    MenuItem randomRobot, rightHand, lookAhead, leftHand;
    MenuItem runItem, resetItem;
    MenuItem loadFile;
    Timeline timeline;
    int height=200; //default - it is nice to adjust based on the maze size
    int width=200; //default - it is nice to adjust based on the maze size

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    /**
     * (This method is complete already.)
     * "Main" method. Creates the menus, puts the painted maze and menu bar
     * into a VBox, and adjusts to the size of the maze
     * You can chose to add a help and about menus as well.
     * @param primaryStage - stage to display everything on
     */
    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;

        MenuBar bar=new MenuBar();

        fileMenu=BuildFileMenu();
        goMenu=BuildGoMenu();
        robotMenu=BuildRobotMenu();

        bar.getMenus().addAll(fileMenu, goMenu, robotMenu);
        
        pane=new MazePane();
        
        VBox box=new VBox(bar, pane);

        Scene scene=new Scene(box, width, height);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * FINISH
     * Constructs a robot menu that chooses a robot class to
     * solve the maze
     * create and add menu items for each of your types of robots
     * set the action for each of the robot menu items - and set the robot in the maze
     * @return menu that chooses a robot class
     */
    private Menu BuildRobotMenu() {
        Menu robotMenu=new Menu("Robot");
// finish here
        randomRobot = new MenuItem("RandomRobot");
        rightHand = new MenuItem("RightHandRobot");
        lookAhead = new MenuItem("LookAheadRobot");
        leftHand = new MenuItem("LeftHandRobot");
        
        robotMenu.getItems().addAll(randomRobot, rightHand, lookAhead, leftHand);
        
       randomRobot.setDisable(true);
       rightHand.setDisable(true);
       lookAhead.setDisable(true);
       leftHand.setDisable(true);
        
        randomRobot.setOnAction(e -> {
        	Maze m = pane.getMaze();
        	if(m == null) {
        		return;
        	}
        	robot = new RandomRobot(maze.getStartRow(), maze.getStartCol());
        	pane.setRobotInMaze(robot);
        	enableGoMenu(true);
        	pane.paint();
        });
        
        rightHand.setOnAction(e -> {
        	Maze m = pane.getMaze();
        	if(m == null) {
        		return;
        	}
        	robot = new RightHandRobot(maze.getStartRow(), maze.getStartCol());
        	pane.setRobotInMaze(robot);
        	enableGoMenu(true);
        	pane.paint();
        });
        
        lookAhead.setOnAction(e -> {
        	Maze m = pane.getMaze();
        	if(m == null) {
        		return;
        	}
        	robot = new LookAheadRobot(maze.getStartRow(), maze.getStartCol());
        	pane.setRobotInMaze(robot);
        	enableGoMenu(true);
        	pane.paint();
        });
        
        leftHand.setOnAction(e -> {
        	Maze m = pane.getMaze();
        	if(m == null) {
        		return;
        	}
        	robot = new LeftHandRobot(maze.getStartRow(), maze.getStartCol());
        	pane.setRobotInMaze(robot);
        	enableGoMenu(true);
        	pane.paint();
        });
        
        
        
        return robotMenu;
    }

    /**
     * FINISH
     * Constructs a menu and sets the action for running a robot and resetting the maze.
     * that allows the user to 
     * run the robot in the maze - which sets up the timeline animation 
     * and calls the move method below when selected (if a robot and a maze are set)
     * menu item to reset the maze - start the robot back at the starting position.
     * @return functional goMenu with animation ready to go when "run" is selected
     * Be sure to verify that a maze and a robot have been selected.
     */
    private Menu BuildGoMenu() {
         Menu goMenu=new Menu("Go");
// finish here
         
         runItem = new MenuItem("Run");
         resetItem = new MenuItem("Reset");
         
         runItem.setDisable(true);
         resetItem.setDisable(true);
         
         runItem.setOnAction(e -> {
        	 Maze m = pane.getMaze();
        	 if(m == null || robot == null) {
        		 System.out.println("No Maze or Robot set");
        		 return;
        	 }
        	 
        	 timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
        		 int direction = robot.chooseMoveDirection(maze);
        		 robot.move(direction);
        		 pane.paint();
        		 
        		 if(robot.solved(m)) {
        			 timeline.stop();
        			 resetItem.setDisable(false);
        			 runItem.setDisable(true);
        		
        		 }
        		 
        	 }));
        	 
        	 timeline.setCycleCount(Animation.INDEFINITE);
        	 timeline.play();
        	 
        	 
         });
         resetItem.setOnAction(e -> resetMaze()
        	 
         );
         
         goMenu.getItems().addAll(runItem, resetItem);
         
         return goMenu;
      }

    /**
     * FINISH
     * Constructs a menu for the load and exit commands.
     * @return constructed file menu that loads a maze from a file (use JFileChooser to select the file).
     * You may want to adjust the stage size based on the maze size.
     * and a menu item that allows the user to exit the program
     */
    private Menu BuildFileMenu() {
        Menu fileMenu=new Menu("File");
        //finish here
        //if load file is selected:
        //  use JFileChoose to select the file (remember to use try/catch)/
        //	create the new maze based on that file - call maze constructor
        //	set the maze in the pane
        //	set the stage height and width based on the maze height and width recorded in the pane
        //  paint the pain
        
        MenuItem loadFile = new MenuItem("Load");
        loadFile.setOnAction(e -> {
        	SwingUtilities.invokeLater(() -> {
        		JFileChooser chooser = new JFileChooser();
        		int result = chooser.showOpenDialog(null);
        		
        		if(result == JFileChooser.APPROVE_OPTION) {
        			File file = chooser.getSelectedFile();
        			
        			try {
        				Maze newMaze = new Maze(file);
        				Platform.runLater(() -> {
        					
        					pane.setMaze(newMaze);
        					maze = newMaze;
        					enableRobotMenu(true);
        					
        					pane.paint();
        					
        				});
        				
        				} catch(Exception ex) {
        				ex.printStackTrace();
        			}
        		}
        		});
        	});
        	
        	
        	
        fileMenu.getItems().add(loadFile);
 
        return fileMenu;
     }
    
    /**
     * Void method that resets the robot to the start of the maze. 
     * Also freezes the program to give the user a chance to try a different maze
     * 
     */
    
    public void resetMaze() {
    	if(timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
    		return;
    	}
    	
    	if(maze == null) {
    		return;
    	}
    	if(timeline != null) {
    		timeline.stop();
    	}
    	
    	pane.setMaze(maze);
    	pane.requestLayout();
    	pane.applyCss();
    	pane.layout();
    	
    	robot.setCurrentRow(maze.getStartRow());
    	robot.setCurrentCol(maze.getStartCol());
    	
    	pane.paint();
    }
    
    
    /**
     * (This method is complete already.)
     * Paints the movement of the robot through the Maze
     * Assumes the chooseMoveDirection and move methods for each robot
     * operate on an int value for the direction
     */
    public void move(){
        int direction = robot.chooseMoveDirection(maze);
        robot.move(direction);

        pane.paint();

        if(robot.solved(maze)) {
            timeline.stop();
            randomRobot.setDisable(true);
            rightHand.setDisable(true);
            lookAhead.setDisable(true);
            leftHand.setDisable(true);
            
        	return;
        }
    }
    
    /**
     * Void method that enables the robot menu
     * 
     * @param enable
     */
    
    private void enableRobotMenu(boolean enable) {
        randomRobot.setDisable(!enable);
        rightHand.setDisable(!enable);
        lookAhead.setDisable(!enable);
        leftHand.setDisable(!enable);
    }

    /**
     * Void method that enables the Go menu
     * 
     * @param enable
     */
    
    private void enableGoMenu(boolean enable) {
        runItem.setDisable(!enable);
        resetItem.setDisable(!enable);
    }
    
}
