package lab6;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
	The purpose of this program is to display the temperature of the first day of each month over 6 years.
	It also calculates and displays the average and standard deviation for each month and each year.

	@author Sherri Weitl-Harms
	@date 1/30/2024

	Algorithm
 **/

public class Lab6 {
	final static int MONTHS = 12;
	final static int NUMYEARS = 6;

	/**
	 * This is the main method that calls all other methods and displays the output to the user.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Weather Report");
		File inputFile = getInputFile();
		String [] months = {"January", "February", "March", "April", 
				"May", "June", "July", "August", "September",
				"October", "November", "December"
		};
		//create double array for temperatures that stores the data returned from the readFile method
		double[][] temps = readFile(inputFile);
		//loops and displays data for all 12 months
		for(int i = 0;i < temps.length;i++) {
			for(int j = 0; j < temps[i].length; j++) {
				System.out.println(temps[i][j]);
			}
			System.out.println();
		}
		
		
		
		//end program prompt
	}

	/**
	 * This method prompts the user to choose a file from their home directory. If no file is chosen, the program terminates
	 * @return inputFile
	 */
	private static File getInputFile() {
		//allows user to choose file with temperature data from folders
		JFileChooser chooser = new JFileChooser();
		File home = new File(System.getProperty("user.home"));
		chooser.setCurrentDirectory(home);

		//if the user doesn't choose a file, the program will terminate
		int status = chooser.showOpenDialog(null);
		if (status != JFileChooser.APPROVE_OPTION) {
			System.out.println("No File Chosen");
			System.exit(0);
		}
		return chooser.getSelectedFile();
	}
	
	/**
	 * This method reads the temperature data from the file into a two dimensional double array.
	 * @param inputFile
	 * @return double array temperatures
	 * @throws IOException
	 */
	private static double [][] readFile(File inputFile) throws IOException {
		Scanner inputScanner = new Scanner(inputFile);
		int m = 0;//current month value to store temperatures
		double[][] temperatures = new double[MONTHS][NUMYEARS];

		while (inputScanner.hasNext()) {
			String monthData = inputScanner.nextLine();
			String [] splitData = monthData.split(","); //separates each piece of data into its own spot in a String array
			for(int colCount = 0; colCount < (splitData.length-1); colCount++){ //loops through each number in a row
				temperatures[m][colCount]=Double.parseDouble(splitData[colCount+1]); //converts each piece of data (except month name) into a double and stores it in a 2-d array
			}
			m++; //increments row number
		}
		inputScanner.close();
		return temperatures;
	}

	/**
	 * This method finds the average of all the numbers in the row that is called.
	 * @param monthTemps
	 * @return double row average
	 */
	
	public double getRowAverage(double[]monthTemps) {
		double total = 0.0;
		for(int i = 0; i < monthTemps.length; i++) {
			total+=monthTemps[i];
		}
		double mean = total/monthTemps.length;
		
		return mean;
	}
	

	/**
	 * This method finds the average of all the numbers in the column that is called.
	 * @param temperatures
	 * @param colCount
	 * @return double column average
	 */
	
	public double getColAverage(double[][]temps, int colCount) {
		double total = 0;
		int count = 0;
		
		for(int i = 0; i < temps.length; i++) {
			if(colCount < temps[i].length) {
				total+=temps[i][colCount];
				count+=1;
			}
		}
		double average = total/count;
		return average;
	}

	/**
	 * This method converts a row in the temperatures array into a String and formats the String
	 * @param temperatures
	 * @param rowCount
	 * @return output String
	 */
	public String getRowValues(String[] temperatures, int rowCount) {
		String output = Arrays.toString(temperatures[rowCount]);
		
		return output;
	}
	
	

	/** BONUS
	 * This method calculates the standard deviation of all the numbers in the row that is called by the main method.
	 * @param monthTemps
	 * @return row standard deviation
	 */

	/** BONUS
	 * This method calculates the standard deviation of all the numbers in the column that is called by the main method.
	 * @param temperatures
	 * @param colCount
	 * @return
	 */
}
