package lab10;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

/**
 *  @author Mark Yan
 *  @version 11.6.25
 *
 *  Description: This program counts coins as they are clicked and totals them up. If the value is higher than a dollar
 *  the program indicates a win. The user can save the game to file and open an old game.
 *
 *  Algorithm:
 *  1. Build GUI elements
 *  2. Respond to user input
 *  3. Display output
 */

public class Lab10 extends Application
{
    // Fields
    private double total = 0.0;
    private double pennyAmt = 0.0;
    private double nickelAmt = 0.0;
    private double dimeAmt = 0.0;
    private double quarterAmt = 0.0;


    Label pennyCount, nickelCount, dimeCount, quarterCount, totalCount, info, title;

    /**
     * Launch method for GUI
     * @param args String Array with command line arguments
     */
    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    /**
     * Start Method to run the program
     * @param primaryStage Lab1Sol Stage
     */
    @Override
    public void start(Stage primaryStage)
    {
        //Set Primary Stage Title
        primaryStage.setTitle("Coin Counting!");

        //Build menu bar
        MenuBar newMenu = buildMenuBar(primaryStage);

        //Create Images
        Image pennyImage = new Image("file:Photos//penny.png");
        Image nickelImage = new Image("file:Photos//nickel.png");
        Image dimeImage = new Image("file:Photos//dime.png");
        Image quarterImage = new Image("file:Photos//quarter.png");

        // Create the ImageView controls.
        ImageView pennyIV = new ImageView(pennyImage);
        ImageView nickelIV = new ImageView(nickelImage);
        ImageView dimeIV = new ImageView(dimeImage);
        ImageView quarterIV = new ImageView(quarterImage);

        //Build dynamic labels
        pennyCount = new Label("0.00 Cents: 0 clicks");
        nickelCount = new Label("0.00 Cents: 0 clicks");
        dimeCount = new Label("0.00 Cents: 0 clicks");
        quarterCount = new Label("0.00 Cents 0 clicks");
        totalCount = new Label("$0.00 Total");
        info = new Label();

        //Build static labels
        Label pennies = new Label("Pennies");
        pennies.getStyleClass().add("coin-Label");
        Label nickels = new Label("Nickels");
        nickels.getStyleClass().add("coin-Label");
        Label dimes = new Label("Dimes");
        dimes.getStyleClass().add("coin-Label");
        Label quarters = new Label("Quarters");
        quarters.getStyleClass().add("coin-Label");

        // Create a title label
        title = new Label("Count Change");
        title.getStyleClass().add("title-Label");

        // Register event handler for the Label
        title.setOnMouseClicked(event ->
        {
            if (total >= 1.0)
                title.setText(String.format("%.2f You Won!", total));
            else
                title.setText(String.format("%.2f", total));
        });

        //Create Clear button here by calling the "buildButton" method. (or create a menu item for clearing.
        Button clearButton = buildButton();
        
   
        // Register event handlers for the coins
        pennyIV.setOnMouseClicked(event ->
        {
            total += 0.01;
            pennyAmt += 1;
            pennyCount.setText(String.format("%,.2f Cents:  %,.0f Clicks ", pennyAmt*.01, pennyAmt));
            totalCount.setText(String.format("$%,.2f Total", total));
        });

        nickelIV.setOnMouseClicked(event ->
        {
            total += 0.05;
            nickelAmt += 1;
            nickelCount.setText(String.format("%,.2f Cents:  %,.0f Clicks", nickelAmt*0.05, nickelAmt));
            totalCount.setText(String.format("$%,.2f Total", total));
        });

        dimeIV.setOnMouseClicked(event ->
        {
            total += 0.1;
            dimeAmt += 1;
            dimeCount.setText(String.format("%,.2f Cents: %,.0f Clicks", dimeAmt*0.1, dimeAmt));
            totalCount.setText(String.format("$%,.2f Total", total));
         });

        quarterIV.setOnMouseClicked(event ->
        {
            total += 0.25;
            quarterAmt += 1;
            quarterCount.setText(String.format("%,.2f Cents: %,.0f Clicks", quarterAmt*0.25, quarterAmt));
            totalCount.setText(String.format("$%,.2f Total", total));
        });

        //GridPane to display coins and labels
        GridPane newPane = new GridPane();
        newPane.addColumn(0, pennies, pennyIV, pennyCount);
        newPane.addColumn(1, nickels, nickelIV, nickelCount);
        newPane.addColumn(2, dimes, dimeIV, dimeCount);
        newPane.addColumn(3, quarters, quarterIV, quarterCount);
        newPane.setHgap(40);
        newPane.setVgap(40);
        newPane.setAlignment(Pos.BASELINE_CENTER);
        newPane.setHalignment(pennies, HPos.CENTER);
        newPane.setHalignment(nickels, HPos.CENTER);
        newPane.setHalignment(dimes, HPos.CENTER);
        newPane.setHalignment(quarters, HPos.CENTER);
        newPane.setHalignment(pennyIV, HPos.CENTER);
        newPane.setHalignment(nickelIV, HPos.CENTER);
        newPane.setHalignment(dimeIV, HPos.CENTER);
        newPane.setHalignment(quarterIV, HPos.CENTER);

        // Put everything into a VBox
        VBox mainVBox = new VBox(40, newMenu, title, newPane, totalCount, clearButton, info); //finish: add the total count here as well as the clear button
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPrefWidth(750);
        mainVBox.setPrefHeight(400);

        // Add the main VBox to a scene.
        Scene scene = new Scene(mainVBox);
        scene.getStylesheets().add("lab10.css");

        // Set the scene to the stage and display it.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Saves game to a file
     */
    public void saveFile()
    {
        //Create new file
        File newFile = new File("SavedData.txt");
        FileWriter writer = null;

        try {
            writer = new FileWriter(newFile);
             writer.write(Double.toString(pennyAmt) + "\n");
            writer.write(Double.toString(nickelAmt) + "\n");
            writer.write(Double.toString(dimeAmt) + "\n");
            writer.write(Double.toString(quarterAmt) + "\n");
            info.setText("File Saved");
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            writer.close();
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Opens information from a file
     */
    public void openFile()
    {
        //Open file
        File inputFile = new File("SavedData.txt");
        Scanner input = null;

        try {
            input = new Scanner(inputFile);
            while (input.hasNext())
            {
                pennyAmt = input.nextDouble();
                pennyCount.setText(String.format("%,.2f Cents:  ", pennyAmt*0.01));
                nickelAmt = input.nextDouble();
                nickelCount.setText(String.format("%,.2f Cents:  ", nickelAmt*0.05));
                dimeAmt = input.nextDouble();
                dimeCount.setText(String.format("%,.2f Cents: ", dimeAmt*0.1));
                quarterAmt = input.nextDouble();
                quarterCount.setText(String.format("%,.2f Cents: ", quarterAmt*0.25));
                info.setText("File Opened");
                input.close();
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Builds File Menu
     * @param p Stage instance for exit function
     * @return Menu Object with file values
     */
    private Menu buildFileMenu(Stage p)
    {
        Menu fileMenu = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().add(save);
        fileMenu.getItems().add(open);
        fileMenu.getItems().add(exit);

        //Set action for save
        save.setOnAction(event -> {
            saveFile();
        });

        //set action for open
        open.setOnAction(event -> {
            openFile();
        });

        //set action for exit
        exit.setOnAction(event -> {
            System.exit(0);
        });

        return fileMenu;
    }

    /**FINISH
     * Builds help menu
     * @return Menu with help menu values
     */
    public Menu buildHelpMenu()
    {
        Menu helpMenu = new Menu("Help");
//see Lab 9 for help
        MenuItem About = new MenuItem("About");
        
        helpMenu.getItems().addAll(About);
        
        About.setOnAction(event -> {
        	String infoText = "This program counts coins as they are clicked and totals them up. "
        			+ "\nIf the value is higher than a dollar, "
        			+ "the program indicates a win. "
        			+ "\nThe user can save the game to file and open an old game. "
        			+ "\nAuthor: Mark Yan "
        			+ "\nVersion: 11.6.25";
        		
        	Alert a = (new Alert(Alert.AlertType.INFORMATION, infoText, ButtonType.OK));
            a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            a.show();
        });
        
        
        return helpMenu;
    }
    


    /**
     * Builds the menu bar
     * @param primaryStage primarystage object reference for exit function
     * @return MenuBar Object with menu values
     */
    public MenuBar buildMenuBar(Stage primaryStage)
    {
        //Build menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add("menu-Bar");

        Menu fileMenu = buildFileMenu(primaryStage);
        //add help Menu: Uncomment when you get the buildHelpMenu method finished
        Menu helpMenu = buildHelpMenu();

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(helpMenu); //uncomment

        return menuBar;
    }

    /**
     * Builds the clear button
     * @return Button Object with clear button values
     */
    public Button buildButton()
    {
        Button clearButton = new Button("CLEAR");

        clearButton.setOnAction(event -> {
    // FINISH what you need to do here to clear the values and the display
        	total = 0;
        	pennyAmt = 0;
        	nickelAmt = 0;
        	dimeAmt = 0;
        	quarterAmt = 0;
        	pennyCount.setText("0.00 Cents: 0 Clicks");
        	nickelCount.setText("0.00 Cents: 0 Clicks");
        	dimeCount.setText("0.00 Cents: 0 Clicks");
        	quarterCount.setText("0.00 Cents: 0 Clicks");
        	totalCount.setText("$0.00 Total");
        	title.setText("Count Change");
        	info.setText("");
        	
        	
        	
        });

        return clearButton;
    }
}