package lab9;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/*
 * Lab 9 starter code
 * Theater revenue problem
 * This demonstrates a GUI program, with a Model/View/Controller architecture
 *  * comments intentionally left brief to shorten code for printout
 *
 * written by Sherri WeitlHarms, CSC222 
 * @author harmssk
 */

public class TheaterRevenueWindow extends Application {

    TheaterRevenues theaterRev;
    TextField pricePerAdultTxt, numberAdultTxt, pricePerChildTxt, numberChildTxt;
    TextField grossAdultRevTxt, netAdultRevTxt, grossChildRevTxt, netChildRevTxt;
    TextField totalGrossRevTxt, totalNetRevTxt;
    Button calcButton, clearButton;
    Label  numberAdultsLabel, numberChildLabel, pricePerChildLabel, pricePerAdultLabel;
    MenuItem ExitFile;
    MenuItem About;
    MenuItem Help;
    

    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Theater Revenue Calculator");
        theaterRev = new TheaterRevenues();
        GridPane ticketPane = createTicketPane();
        GridPane revPane = createRevenuePane();
        HBox bottomHBox = createSouthPane();
        bottomHBox.setPadding(new Insets(10));

        VBox leftVBox = new VBox(ticketPane);
        leftVBox.setPadding(new Insets(10));

        VBox rightVBox = new VBox(revPane);
        rightVBox.setPadding(new Insets(10));

        // Create a BorderPane with a node in the center.
        BorderPane borderPane = new BorderPane();

        // Add the buttons to the BorderPane�s regions.
        borderPane.setBottom(bottomHBox);
        borderPane.setLeft(leftVBox);
        borderPane.setRight(rightVBox);
        
        VBox box = new VBox();
        
        MenuBar bar = buildMenuBar();
        box.getChildren().add(bar);
        box.getChildren().add(borderPane);
        // The Scene
        Scene scene = new Scene(box);
        scene.getStylesheets().add("lab9.css");

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Theatre Revenues");

        // Show the window.
        primaryStage.show();
    }
    

    private class MyListener implements EventHandler<javafx.event.ActionEvent> {
    	public void handle(javafx.event.ActionEvent e) {
        //If the Exit but is select

        if (e.getSource() == ExitFile)
            System.exit(0);
            //If open file is selected
        else if(e.getSource() == About) {
        	InfoMenu();
        }
    	}
    }
    private class HelpList implements EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent e) {
            //If the About MiniTextEditor is clicked
            if(e.getSource() == Help){
                //Prompt to show help menu.
                AboutMenu();
            }
        }
    }
    private Menu buildFileMenu(){
        //Create the menu
        Menu file = new Menu("File");

        //Creates the items.
        About = new MenuItem("About");
        ExitFile = new MenuItem("Exit");

        //Add items to menu

        ObservableList<MenuItem> items = file.getItems();
        items.addAll(About, new SeparatorMenuItem(), ExitFile);

        // Hook up the menu items with the listener
        MyListener listener = new MyListener();

        About.setOnAction(listener);
        ExitFile.setOnAction(listener);
        return file;
    }
    
    private Menu buildHelpMenu(){
        //Create the menu
        Menu helpM = new Menu("Help");

        //The items in the menu
        Help = new MenuItem("Help");

        // Add the items with a separator
        helpM.getItems().addAll(Help);

        //Create the listener for the options in the help menu.
        HelpList listener = new HelpList();
        Help.setOnAction(listener);

        return helpM;
    }
    
    private MenuBar buildMenuBar(){
        //Create a menu bar
        //Add the various menu items
        Menu fileM = buildFileMenu();
        Menu HelpMe = buildHelpMenu();

        return new MenuBar(fileM, HelpMe);
    }
    
    
    private void showInfoDialog(String message){
        Alert a = (new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK));
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // stretch box to show all of message
        a.show();
    }
    private void AboutMenu() {
        //Displays this message
        showInfoDialog("This program calcualtes gross and net revenue at a movie theater");
    }
    
    private void InfoMenu() {
    	showInfoDialog("Calculator for revenue");
    }
    
    
    /**
     * create Ticket Panel
     *
     * @return
     */
    private GridPane createTicketPane() {
        GridPane tickPane = new GridPane();

        int row = 0;
        Label ticketsSoldLabel = new Label("Tickets sold");
        tickPane.add(ticketsSoldLabel, 0, row++);

        pricePerAdultLabel = new Label("   Adult ticket price");
        tickPane.add(pricePerAdultLabel, 0, row);

        pricePerAdultTxt = new TextField("" + theaterRev.getDefaultAdultPrice());
        tickPane.add(pricePerAdultTxt, 1, row++);

        numberAdultsLabel = new Label("   Number adult tickets sold");
        tickPane.add(numberAdultsLabel, 0, row);
        numberAdultTxt = new TextField("" + theaterRev.getDefaultAdultTickets());
        tickPane.add(numberAdultTxt, 1, row++);

        pricePerChildLabel = new Label("   Child ticket price");
        tickPane.add(pricePerChildLabel, 0, row);
        pricePerChildTxt = new TextField("" + theaterRev.getDefaultChildPrice());
        tickPane.add(pricePerChildTxt, 1, row++);

        numberChildLabel = new Label("   Number child tickets sold");
        tickPane.add(numberChildLabel, 0, row);
        numberChildTxt = new TextField("" + theaterRev.getDefaultChildTickets());
        tickPane.add(numberChildTxt, 1, row);

        return tickPane;
    }

    /**
     * create the revenue pane
     *
     * @return
     */
    private GridPane createRevenuePane() {
        // revenue pane
        int row=0;
        GridPane revPane = new GridPane();
        Label revenueLabel = new Label("Revenue");
        revPane.add(revenueLabel, 0, row++);

        Label lab = new Label("Gross Rev. Adult");
        revPane.add(lab, 0, row);
        grossAdultRevTxt = new TextField();
        grossAdultRevTxt.setEditable(false);
        grossAdultRevTxt.getStyleClass().add("text-field-output");

        revPane.add(grossAdultRevTxt, 1, row++);

        lab = new Label("Net Rev. Adult");
        revPane.add(lab, 0, row);
        netAdultRevTxt = new TextField();
        netAdultRevTxt.setEditable(false);
        netAdultRevTxt.getStyleClass().add("text-field-output");
        revPane.add(netAdultRevTxt, 1, row++);

        // child rev
        lab = new Label("Gross Rev. Child");
        revPane.add(lab, 0, row);
        grossChildRevTxt = new TextField();
        grossChildRevTxt.setEditable(false);
        grossChildRevTxt.getStyleClass().add("text-field-output");
        revPane.add(grossChildRevTxt, 1, row++);

        lab = new Label("Net Rev. Child");
        revPane.add(lab, 0, row);
        netChildRevTxt = new TextField();
        netChildRevTxt.setEditable(false);
        netChildRevTxt.getStyleClass().add("text-field-output");
        revPane.add(netChildRevTxt, 1, row);
        return revPane;
    }

    /**
     * Create the south pane
     * @return
     */
    private HBox createSouthPane() {
        calcButton =new Button("Calculate Revenues");
        calcButton.setOnAction(new ButtonClickHandler());

        Label TotalGrossLabel =new Label("Total Gross Rev:");
        totalGrossRevTxt =new TextField();
        totalGrossRevTxt.setEditable(false);
        Label TotalNetLabel =new Label("Total Net Rev:");
        totalNetRevTxt =new TextField();
        totalNetRevTxt.setEditable(false);
        clearButton = new Button("Clear");
        clearButton.setOnAction(new ButtonClickHandler());
        return new HBox(10, calcButton,TotalGrossLabel,totalGrossRevTxt,TotalNetLabel,totalNetRevTxt,clearButton);
    }

    private void clearAllFields()
    {
        numberChildLabel.getStyleClass().clear();
        numberChildLabel.getStyleClass().add("label");
        numberAdultsLabel.getStyleClass().clear();
        numberAdultsLabel.getStyleClass().add("label");
        pricePerChildLabel.getStyleClass().clear();
        pricePerChildLabel.getStyleClass().add("label");
        pricePerAdultLabel.getStyleClass().clear();
        pricePerAdultLabel.getStyleClass().add("label");

        pricePerAdultTxt.setText(""+theaterRev.getDefaultAdultPrice());
        numberAdultTxt.setText(""+theaterRev.getDefaultAdultTickets());
        pricePerChildTxt.setText(""+theaterRev.getDefaultChildPrice());
        numberChildTxt.setText(""+theaterRev.getDefaultChildTickets());
        grossAdultRevTxt.setText("");
        netAdultRevTxt.setText("");
        grossChildRevTxt.setText("");
        netChildRevTxt.setText("");
        totalGrossRevTxt.setText("");
        totalNetRevTxt.setText("");
    }
    
    

    //finish
    private void calcAdultRevs()
    {
    	theaterRev.setAdultPrice(Double.parseDouble(pricePerAdultTxt.getText()));
    	theaterRev.setAdultTickets(Integer.parseInt(numberAdultTxt.getText()));
    	netAdultRevTxt.setText(Double.toString(theaterRev.calcNetAdultSales()));
    	grossAdultRevTxt.setText(Double.toString(theaterRev.calcGrossAdultSales()));

    }

    //finish
    private void calcChildRevs()
    {
    	theaterRev.setChildPrice(Double.parseDouble(pricePerChildTxt.getText()));
    	theaterRev.setChildTickets(Integer.parseInt(numberChildTxt.getText()));
    	netChildRevTxt.setText(Double.toString(theaterRev.calcNetChildSales()));
    	grossChildRevTxt.setText(Double.toString(theaterRev.calcGrossChildSales()));
    }

    //finish
    private void calcRevs()
    {
    	calcAdultRevs();
    	calcChildRevs();
    	
    	totalGrossRevTxt.setText(Double.toString(theaterRev.calcTotalGross()));
    	totalNetRevTxt.setText(Double.toString(theaterRev.calcTotalNet()));
    	
    }

    private boolean validateFields()
    {
        String errorMessage = "";
        errorMessage += validateAdultPrice();
        errorMessage += validateNumberAdult();

        errorMessage += validateChildPrice();
        errorMessage += validateNumberChild();

        if(!errorMessage.equals(""))
        {
            System.out.println("Error in Data Entry:\n"+ errorMessage);
            return false;
        }
        return true;
    }

    private String validateNumberChild()
    {
        int cTicks = 0;
        String errorMessage = "";
        numberChildLabel.getStyleClass().clear();
        numberChildLabel.getStyleClass().add("label");
        if(numberChildTxt.getText().equals(""))
        {
            numberChildLabel.getStyleClass().clear();
           numberChildLabel.getStyleClass().add("label-red");
            errorMessage+="\nChild tickets field needs a value:\n"+
                    "      positive whole number ";
        }
        else
        {
            try {
                cTicks = Integer.parseInt(numberChildTxt.getText());
                if (cTicks < 0)
                {
                    numberChildLabel.getStyleClass().clear();
                    numberChildLabel.getStyleClass().add("label-red");
                    errorMessage += "\nNumber in child tickets field is"+
                            " negative\n"
                            + "     enter a positive whole number \n";
                }
            }catch(NumberFormatException nme) {
                numberChildLabel.getStyleClass().clear();
                numberChildLabel.getStyleClass().add("label-red");
                errorMessage+="\nNumber in child tickets field contains an"+
                        " invalid 'integer'\n"+
                        "     enter a positive whole number \n";
            }
        }
        return errorMessage;
    }

    private String validateNumberAdult()
    {
        int aTicks = 0;
        String errorMessage = "";
        numberAdultsLabel.getStyleClass().clear();
        numberAdultsLabel.getStyleClass().add("label");
        if(numberAdultTxt.getText().equals(""))
        {
            numberAdultsLabel.getStyleClass().clear();
            numberAdultsLabel.getStyleClass().add("label-red");
            errorMessage+="\nAdult tickets field needs a value:\n"+""
                    + "      enter a positive whole number\n";
        }
        else {
            try {
                aTicks = Integer.parseInt(numberAdultTxt.getText());
                if (aTicks < 0)
                {
                    numberAdultsLabel.getStyleClass().clear();
                    numberAdultsLabel.getStyleClass().add("label-red");
                    errorMessage += "\nNumber in adult tickets field is negative\n"
                            + "     enter a positive whole number \n";
                }
            }catch(NumberFormatException nme)
            {
                numberAdultsLabel.getStyleClass().clear();
                numberAdultsLabel.getStyleClass().add("label-red");
                errorMessage+="\nNumber in adult tickets field contains an"+""
                        + " invalid 'integer'\n"+
                        "     enter a positive whole number \n";
            }
        }
        return errorMessage;
    }

    private String validateAdultPrice()
    {
        double aPrice = 0;
        String errorMessage = "";
        pricePerAdultLabel.getStyleClass().clear();
        pricePerAdultLabel.getStyleClass().add("label");
        if(pricePerAdultTxt.getText().equals(""))
        {
            pricePerAdultLabel.getStyleClass().clear();
            pricePerAdultLabel.getStyleClass().add("label-red");
            errorMessage+="\nAdult price fields needs a value:\n    positive"+""
                    + " dollar amount\n";
        }
        else {
            try {
                aPrice = Double.parseDouble(pricePerAdultTxt.getText());

            if (aPrice < 1)
            {
                pricePerAdultLabel.getStyleClass().clear();
                pricePerAdultLabel.getStyleClass().add("label-red");
                errorMessage += "\nprice of adult tickets field is zero"+""
                        + " or less\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {   errorMessage+="\nAdult price fields contains an invalid"+""
                + " dollar amount\n"+
                "      enter a positive dollar amount \n";
            pricePerAdultLabel.getStyleClass().clear();
            pricePerAdultLabel.getStyleClass().add("label-red");
        }
        }
        return errorMessage;
    }

    private String validateChildPrice()
    {
        double cPrice = 0;
        String errorMessage = "";
        pricePerChildLabel.getStyleClass().clear();
        pricePerChildLabel.getStyleClass().add("label");
        if(pricePerChildTxt.getText().equals(""))
        {
            pricePerChildLabel.getStyleClass().clear();
            pricePerChildLabel.getStyleClass().add("label-red");;
            errorMessage+="\nChild price fields needs a value:\n"+
                    "     positive dollar amount\n";
        }
        else {
            try {
                cPrice = Double.parseDouble(pricePerChildTxt.getText());
            if (cPrice < 1)
            {
                pricePerChildLabel.getStyleClass().clear();
                pricePerChildLabel.getStyleClass().add("label-red");;
                errorMessage += "\nprice of child tickets field is"+
                        " zero or less\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {
            pricePerChildLabel.getStyleClass().clear();
            pricePerChildLabel.getStyleClass().add("label-red");;
            errorMessage+="\nChild price fields contains an invalid"+""
                    + " dollar amount\n"+
                    "     enter a positive dollar amount \n";
        }
        }
        return errorMessage;
    }

    /**
     * The listener to respond to  button events
     ** @author Sherri Harms
     *     */

    class ButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e) {
            if(e.getSource() == calcButton)
            {
                if(validateFields())
                {   calcRevs();
                }
            } else if(e.getSource() == clearButton){
                clearAllFields();
            }
        }
    }
    
    
    


}
