package hw6Connect4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import java.io.File;
import java.util.Optional;




/**
 * Connect 4 Game Implementation/Window
 * @author Mark Yan
 * @version 12.10.25
 * 
 * 
 */

public class Connect4Window extends Application {
	
	private Con4Game game;
	private Connect4Pane pane;
	private Stage primaryStage;
	Menu fileMenu;
	Menu gameMenu;
	Menu infoMenu;
	MenuItem save, load;
	MenuItem reset, stats, custom, color, shape;
	MenuItem gameInfo;
	
	
	
	

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	pane = new Connect4Pane();
    	game = pane.getGame();
    	
    	BorderPane root = new BorderPane();
    	root.setCenter(pane);
    	
        
        MenuBar bar = new MenuBar();
        fileMenu = buildFileMenu();
        gameMenu = buildGameMenu();
        infoMenu = buildInfoMenu();
        bar.getMenus().addAll(fileMenu, gameMenu, infoMenu);
        
        root.setTop(bar);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect 4 Game");
        primaryStage.show();
        
        
    }
    
    private Menu buildFileMenu() {
    	Menu fileMenu = new Menu("File");
    	save = new MenuItem("Save Game");
    	load = new MenuItem("Load Game");
    	
    	save.setOnAction(e -> {
    		FileChooser chooser = new FileChooser();
    		chooser.setTitle("Save Game");
    		chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
    		
    		File selected = chooser.showSaveDialog(primaryStage);
    		if(selected != null) {
    			try {
    				game.saveGame(selected);
    			}
    			catch(Exception ex){
    				ex.printStackTrace();
    			}
    		}
    		
    		
    	});
    	
    	load.setOnAction(e -> {
    		FileChooser chooser = new FileChooser();
    		chooser.setTitle("Load Game");
    		chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
    		
    		File selected = chooser.showOpenDialog(primaryStage);
    		if(selected != null) {
    			try {
    				game.loadGame(selected);
    				pane.refreshGame();
    							}
    			catch(Exception ex){
    				ex.printStackTrace();
    			}
    		}
    		

    	});
    	
    	
    	fileMenu.getItems().addAll(save, load);
    	
    	return fileMenu;
    	
    	
    }
    

    
    private Menu buildGameMenu() {
    	Menu gameMenu = new Menu("Game");
    	reset = new MenuItem("Restart Game");
    	
    	reset.setOnAction(e -> {
    		game.resetBoard();
    		pane.paint();
    	});
    	
    	stats = new MenuItem("Game Stats");
    	stats.setOnAction(e -> {
    		String message = "Player 0 Wins: " + game.getPlayer0Wins() + "\n"
    				+ "Player 1 Wins: " + game.getPlayer1Wins();
    		showAlert(message, AlertType.INFORMATION);
    	});
    	
    	custom = new MenuItem("Customize Board");
    	
    	custom.setOnAction(e -> {
    		TextInputDialog dialog = new TextInputDialog("10, 10");
    		dialog.setHeaderText("Enter the Number of Rows and Columns");
    		dialog.setContentText("Format: rows, cols");
    		
    		Optional<String> result = dialog.showAndWait(); 
    		result.ifPresent(input -> {
    			try {
    				String[] parts = input.split(",");
    				int r = Integer.parseInt(parts[0].trim());
    				int c = Integer.parseInt(parts[1].trim());
    				
    				restartWithSize(r, c);
    				
    			}
    			catch(Exception ex) {
    				showAlert("Invalid", AlertType.ERROR);
    			}
    		});
    			
    	});
    	
    	
    	color = new MenuItem("Change Color");
    	
    	color.setOnAction(e -> {
    		Dialog<Void> dialog = new Dialog<>();
    		dialog.setTitle("Choose Marble Color.");
    		
    		ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    		dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
    		
    		VBox box = new VBox(10);
    		box.setPadding(new Insets(15));
    		
    		
    		ColorPicker p0 = new ColorPicker(pane.getPlayer0Color());
    		ColorPicker p1 = new ColorPicker(pane.getPlayer1Color());
    		
    		box.getChildren().addAll(
    			new Label("Player 0 Color: "), p0,
    			new Label("Player 1 Color: "), p1
    		);
    		
    		dialog.getDialogPane().setContent(box);
    		
    		dialog.setResultConverter(button -> {
    			if(button == okButton) {
    				pane.setPlayer0Color(p0.getValue());
    				pane.setPlayer1Color(p1.getValue());
    			}
    			return null;
    		});
    		dialog.showAndWait();
    		
    	});
    	
    	shape = new MenuItem("Change Token Shape");
    	
    	shape.setOnAction(e -> {
    		
    	pane.showShapeDialog();
    	String s = pane.getTokenShape();
    	pane.setPlayer0Shape(s);
    	pane.setPlayer1Shape(s);
    	pane.paint();
    	});
    	
    	
    	
    	gameMenu.getItems().addAll(reset, custom, color, stats, shape);
    	return gameMenu;
    	
    	
    	
    }
    
    private Menu buildInfoMenu() {
    	Menu infoMenu = new Menu("Info");
    	gameInfo = new MenuItem("Game Information");
    	gameInfo.setOnAction(e -> {
    		String infoText = "Connect 4 Rules: \n" +
    				"1. Each player plays 1 token per turn \n" + 
    				"2. First player to get 4 in a row vertically, horizontally, or diagonally wins!";
    		showAlert(infoText, AlertType.INFORMATION);
    	});
    	
    	infoMenu.getItems().addAll(gameInfo);
    	return infoMenu;
    	
    }
    
    private void showAlert(String message, AlertType type) {
    	Alert alert = new Alert(type);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
    
    private void restartWithSize(int r, int c) {
    	game = new Con4Game(r, c);
    	pane = new Connect4Pane(r, c, game);
    	
    	BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
    	root.setCenter(pane);
    	
    }
    
    
}
