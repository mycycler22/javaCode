package lab3;
import javax.swing.*;

import java.io.*;
import java.util.*;

/**
@author Mark Yan

**/


/**
The purpose of the program is to display data about states based on which option of info the user chooses.

Algorithm:
1. Files are imported into the program
2. File data is stored into respective ArrayList
3. Program introduction message is displayed to the user
4. Menu is displayed to the user
5. User inputs an integer corresponding to which type of data they would like to receive
6. Program uses either max or min method to find the desired number in the requested category
7. A switch is used in the main method to collect the remaining state data and print a results statement
8. Menu screen will reappear and loop until the user enters the value 0
9. Once the user enters '0', a closing message will be displayed to the user
10. Program terminates
* */

public class StateDataAnalyzerArrayList {
	private static int NUMBER_STATES = 50;
	private static ArrayList<String> stateData = new ArrayList<String>();
	private static ArrayList<Double> incomeData = new ArrayList<Double>();
	private static ArrayList<Double> populationData = new ArrayList<Double>();
	private static ArrayList<Double> sizeData = new ArrayList<Double>();

	/**
	 * This method reads the state from the file and stores the data to ArrayLists.
	 * @param fileName
	 * @throws Exception
	 * This method also reads the numbers in the file and stores it to the relevant ArrayList
	 */
	public static void loadFromFile(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner fileScan = new Scanner(file);

		//stores the data into the ArrayLists until there are no more data in the list
		for(int row = 0; row < NUMBER_STATES; row++){
			stateData.add(fileScan.next());
			incomeData.add(fileScan.nextDouble());
			populationData.add(fileScan.nextDouble());
			sizeData.add(fileScan.nextDouble());
			
			//add to all of the ArrayLists

			fileScan.nextLine();//read the end of line marker

		}
		fileScan.close();
	}

	/**
	 * This is the main method where the program starts and what calls all the other methods.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws IOException {
		int indexFound=0;

		displayIntro(); //displays the introduction of the program

		String fileName = "State_Data.csv"; //tells the program what file to use

		//Load the data into the separate ArrayLists
		loadFromFile(fileName); //load the state names
		System.out.println(populationData);
		//update this method  to load the other ArrayLists. Remember to skip over the data as needed, 
		//or load them all, one piece of data at a time, in the same method.

		int menu = menu(); //calls menu method

		while (menu != 0) { //loops until the user inputs a sentinel value of 0
			switch (menu){//switch that will use whichever number they inputted to decide on what to output
			case 1:
				//if they choose 1 it will find the state with the maximum land size from the max index method
				indexFound = findMaxIndex(sizeData);
				JOptionPane.showMessageDialog(null, stateData.get(indexFound) + " has the largest land area at: " + sizeData.get(indexFound) +
						" square miles. \n" + stateData.get(indexFound) + " also has a population of : " + populationData.get(indexFound) +
						" people, and an average income of: $" + incomeData.get(indexFound));
				//get all the matching data and output with an appropriate message
				break;

			case 2:
				//if they choose 2 it will find the state with the minimum land size from the min index method
				indexFound = findMinIndex(sizeData);
				JOptionPane.showMessageDialog(null,
						stateData.get(indexFound) + " has the smallest land area at: " + sizeData.get(indexFound)
						+ " square miles.\n" + stateData.get(indexFound) + " also has a population of "
						+ populationData.get(indexFound) + " people, and an average income of $" + 
						incomeData.get(indexFound));
				//get all the matching data and output with an appropriate message
				break;

			case 3:
				//if they choose 3 it will find the state with the maximum population from the max index method
				indexFound = findMaxIndex(populationData);
				JOptionPane.showMessageDialog(null, stateData.get(indexFound) + " has the largest population with " +populationData.get(indexFound)
				+ " people. \n" + stateData.get(indexFound) + " also has a land area of " + sizeData.get(indexFound)
				+ " square miles, and an average income of $" + incomeData.get(indexFound));
				//get all the matching data and output with an appropriate message
				break;

			case 4:
				//if they choose 4 it will find the state with the lowest population from the min index method
				indexFound = findMinIndex(populationData);
				JOptionPane.showMessageDialog(null, stateData.get(indexFound) + " has the lowest population with " + populationData.get(indexFound) +
				" people. \n" + stateData.get(indexFound) + " also has a land area of " + sizeData.get(indexFound) + 
				" square miles, with an average income of $" + incomeData.get(indexFound));
				//get all the matching data and output with an appropriate message
				break;

			case 5:
				//if they choose 5 it will find the state with the largest average salary from the max index method
				indexFound = findMaxIndex(incomeData);
				JOptionPane.showMessageDialog(null, stateData.get(indexFound) + " has the highest average salary with $" + incomeData.get(indexFound) +
				"\n" + stateData.get(indexFound) + " also has a population of " + populationData.get(indexFound) + " people and a land area of " +
						sizeData.get(indexFound) + " square miles.");
				//get all the matching data and output with an appropriate message
				break;

			case 6:
				//if the choose 6 it will find the state with the smallest average salary from the min index method
				indexFound = findMinIndex(incomeData);
				JOptionPane.showMessageDialog(null, stateData.get(indexFound) + " has the lowest average income of $" + incomeData.get(indexFound) +
						"\n" + stateData.get(indexFound) + " also has a population of " + populationData.get(indexFound) + " people, and a land area of " +
						sizeData.get(indexFound) + " square miles.");
				//get all the matching data and output with an appropriate message
				break;
			}
			menu = menu();
		}
		displayEnding();
	}

	/**
	 * This method display the introduction/explanation to the program.
	 */
	public static void displayIntro(){
		JOptionPane.showMessageDialog(null, "Hello! This program will allow you to choose from a list of options \nregarding state information and display the information that corresponds to your demand.");
	}

	/**
	 * This method displays the menu and allows the user to choose which type of information they would like to see.
	 * @return menu
	 */
	public static int menu(){
		String input = JOptionPane.showInputDialog("Please enter the number that corresponds to the desired action.\nExample: If you wanted to find the state with the largest land mass, you would enter the integer 1.\n\n1 - Find state with maximum land mass\n" +
				"2 - Find state with minimum land mass\n" +
				"3 - Find state with maximum population\n" +
				"4 - Find state with minimum population\n" +
				"5 - Find state with maximum average income\n" +
				"6 - Find state with minimum average income\n0 - Terminate program\n");
		int menu = Integer.parseInt(input); //converts the user input to integer
		return menu;
	}

	/**
	 * This method goes through the selected ArrayListList and stores/returns the index of the largest value.
	 * @param ArrayList
	 * @return maxIndex
	 */
	public static int findMaxIndex(ArrayList<Double> list){
		int indexFound=0;
		double maxValue = Double.MIN_VALUE;
		int maxIndex = -1;
		for(double stat: list) {
			if(stat > maxValue) {
				maxValue = stat;
				maxIndex = indexFound;
			}
			indexFound++;
		}
			
		
		return maxIndex;
	}

	/**
	 * This method goes through the selected ArrayList and stores/returns the index of the smallest value.
	 * @param ArrayList
	 * @return minIndex
	 */
	public static int findMinIndex(ArrayList<Double> list){
		int indexFound= 0;
		double minValue = Double.POSITIVE_INFINITY;
		int minIndex = -1;
		
		for(double stat: list) {
			if(stat < minValue) {
				minValue = stat;
				minIndex = indexFound;
			}
			indexFound++;	
		}
			
		
		
		return minIndex;
	}

	/**
	 * This method displays the closing for the program.
	 */
	public static void displayEnding(){
		JOptionPane.showMessageDialog(null, "Thank you for using this program.\nProgram now ending.");
	}
}


