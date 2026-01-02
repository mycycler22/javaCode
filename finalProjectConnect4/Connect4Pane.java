package hw6Connect4;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;


/**
 * Pane where the action is drawn for the Connect 4 game.
 * 
 * @author Mark Yan
 * @version 12.10.25
 * 
 */

public class Connect4Pane extends Pane {
    private int col; //number of columns for the game board
    private int row; //number of rows for the game board
    private double circleRad = 20.0;//radius of the token
    private int gap = 10; //pixel gap between columns
    private double columnWidth = (circleRad * 2.0) + gap; //column width
    private Label label = new Label();//update the info on the game - who's turn
    private Con4Game con4Game; //game engine, model data
    private Color player0Color = Color.YELLOW;
    private Color player1Color = Color.RED;
    private String player0Shape = "circle";
    private String player1Shape = "circle";
    private String tokenShape = "circle";
    
    
    /**
     * constructor - 
     * be sure to 
     * create a new con4Game object
     * set up a mouse handler
     *  and paint the initial gameboard
     */
    public Connect4Pane(int row, int col, Con4Game game) {
    	this.row = row;
    	this.col = col;
    	this.con4Game = game;
    	this.setBackground(new Background(new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    	this.setOnMouseClicked(e -> {
    		int clickedCol = (int)(e.getX()/columnWidth);
    		
    		if(clickedCol >= 0 && clickedCol < col) {
    			con4Game.makeMove(clickedCol);
    			//label.setText("Player " + con4Game.getCurrentPlayer() + "'s Turn.");
    			paint();
    		}
    	});
    	
    	paint();
    }
    
    /**
     * Default Connect4Pane constructor
     * 
     */
    public Connect4Pane() {
    	this(10, 10, new Con4Game(10, 10));
    	
    }

    /**
     * add all the children items - rectangles, circles, boxes, to the pane
     * I usually clear the old children and add the children again.
     * Remember to paint the circles on top of the rectangles.
     */
    public void paint() {
    	label.setTextFill(Color.WHITE);
    	
    	if(con4Game.isGameOver()) {
    		if(con4Game.getWinner() != -1) {
    			label.setText("Player " + con4Game.getCurrentPlayer() + " Wins!");
    			if(con4Game.getWinner() == 0) {
    				label.setTextFill(player0Color);
    			}
    			else {
    				label.setTextFill(player1Color);
    			}
    		}
    		else {
    			label.setText("The Game has ended in a Tie.");
    		}
    	}
    	else {
    		label.setText("It is Player " + con4Game.getCurrentPlayer() + "'s Turn.");
    	}
    	
    	getChildren().clear();
    	getChildren().add(label);
    	
    	double topOffset = 40;
    	double rowHeight = (circleRad * 2) + gap;
    	
    	
    	for(int c = 0; c < col; c++) {
    		for(int r = 0; r < row; r++) {
    			double x  = c * columnWidth + circleRad;
    			double y = r * rowHeight + circleRad + topOffset;
    			
    			//Circle circle = new Circle(x, y, circleRad);
    			//circle.setStroke(Color.BLACK);
    			
    			Shape shape;
    			
    			int token = con4Game.getToken(r, c);
    			
    			if (token == 0) {
    				shape = createShape(player0Shape, x, y, circleRad);
    				shape.setFill(player0Color);
    			}
    			else if(token == 1) {
    				shape = createShape(player1Shape, x, y, circleRad);
    				shape.setFill(player1Color);
    			}
    			else {
    				shape = createShape("circle", x, y, circleRad);
    				shape.setFill(Color.WHITE);
    			}
    			
    			shape.setStroke(Color.BLACK);
    			this.getChildren().add(shape);
    		}
    	}
    	
    	
    }
    /**
     * Getter method for the game object
     * 
     * @return game object
     */
	public Con4Game getGame() {
		return con4Game;
	}
	
	/**
	 * Getter method for player 0's token color
	 * 
	 * @return - player 0's color
	 */
	public Color getPlayer0Color() {
		return player0Color;
	}
	/**
	 * Getter method for player 1's token color
	 * 
	 * @return - player 1's color
	 */
	public Color getPlayer1Color() {
		return player1Color;
	}
	
	/**
	 * Setter method for player 0's token color
	 * 
	 * @param c
	 */
	public void setPlayer0Color(Color c) {
		if(c != null) {
			player0Color = c;
			paint();
		}
	}
	
	/**
	 * Setter method for player 1's token color
	 * 
	 * @param c
	 */
	public void setPlayer1Color(Color c) {
		if(c != null) {
			player1Color = c;
			paint();
		}
	}
	
	/**
	 * Setter method for player 0's token shape
	 * 
	 * @param shape
	 */
	public void setPlayer0Shape(String shape) {
		player0Shape = shape;
	}
	
	/**
	 * Setter method for player 1's token shape
	 * 
	 * @param shape
	 */
	public void setPlayer1Shape(String shape) {
		player1Shape = shape;
	}
	
	/**
	 * Getter method for player 0's token shape
	 * 
	 * @return - player 0's token shape
	 */
	public String getPlayer0Shape() {
		return player0Shape;
	}
	
	/**
	 * Getter method for player 1's token shape
	 * 
	 * @return - player 1's token shape
	 */
	public String getPlayer1Shape() {
		return player1Shape;
	}
	/**
	 * Getter method of the user's chosen token shape
	 * 
	 * @return - selected token shape
	 */
	public String getTokenShape() {
		return tokenShape;
	}
	
	/**
	 * Private method that creates the shape object
	 * 
	 * @param shapeName
	 * @param x
	 * @param y
	 * @param rad
	 * @return - circle if the shapeName is invalid or unknown
	 */
	private Shape createShape(String shapeName, double x, double y, double rad) {
		if(shapeName.equals("square")) {
			Rectangle square = new Rectangle(x - rad, y - rad, rad * 2, rad * 2);
			square.setArcHeight(0);
			square.setArcWidth(0);
			return square;
		}
		else if(shapeName.equals("triangle")) {
			Polygon triangle = new Polygon(
				x, y - rad,
				x + rad, y + rad,
				x - rad, y + rad
			);
			return triangle;
		}
		else if(shapeName.equals("diamond")) {
			Polygon diamond = new Polygon(
				x, y - rad,
				x + rad, y,
				x, y + rad,
				x - rad, y
			);
			return diamond;
		}
		else if(shapeName.equals("hexagon")) {
			Polygon hex = new Polygon(
				x - rad, y,
				x - rad/2, y - rad,
				x + rad/2, y - rad,
				x + rad, y,
				x + rad/2, y + rad,
				x - rad/2, y + rad
			);
			return hex;
		}
		
		return new Circle(x, y, rad);
	}
	
	/**
	 * Void method used in the creation of the Change Token Shape MenuItem
	 * 
	 */
	public void showShapeDialog() {
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("Select Token Shape");
		
		ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
		
		ToggleGroup group = new ToggleGroup();
		
		RadioButton circle = new RadioButton("Circle");
		circle.setToggleGroup(group);
		
		RadioButton square = new RadioButton("Square");
		square.setToggleGroup(group);
		
		RadioButton triangle = new RadioButton("Triangle");
		triangle.setToggleGroup(group);
		
		RadioButton diamond = new RadioButton("Diamond");
		diamond.setToggleGroup(group);
		
		RadioButton hexagon = new RadioButton("Hexagon");
		hexagon.setToggleGroup(group);
		
		switch(tokenShape) {
			case "square":
				square.setSelected(true);
				break;
			case "triangle":
				triangle.setSelected(true);
				break;
			case "diamond":
				diamond.setSelected(true);
				break;
			case "hexagon":
				hexagon.setSelected(true);
				break;
			default:
				circle.setSelected(true);
		}
		
		VBox box = new VBox(10, circle, square, triangle, diamond, hexagon);
		box.setPadding(new Insets(10));
		
		dialog.getDialogPane().setContent(box);
		
		dialog.setResultConverter(button -> {
			if(button == okButton) {
				RadioButton select = (RadioButton) group.getSelectedToggle();
				if(select != null) {
					return select.getText().toLowerCase();
				}
			}
			return null;
		});
		
		dialog.showAndWait().ifPresent(result -> {
			tokenShape = result;
			paint();
		});
		
	}
	
	/**
	 * Void method used in the Load Game MenuItem
	 * 
	 */
	public void refreshGame() {
		row = con4Game.getRows();
		col = con4Game.getCols();
		paint();
	}
	

 }
