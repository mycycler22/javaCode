package lab7;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Starter code
 * The purpose of this class is to test words from a text file to see if it is a palindrome. A palindrome is a word that is the same word forward and backward.
 * Handle exceptions!
 * 
 * Author: Sherri Weitl-Harms
 * Last Edit Date: 3/06/25
 * Contributors: 
 * Algorithm:
 * 1. Welcome message explains the program
 * 2. User picks their file from folders
 * 3. Recursive palindrome method is called to check each line 
 * from the file
 * 4. If the word is a palindrome, it is added to the list and the count is increased
 * 5. Iterative palindrome method is called to check each line from the file
 * 6. If the word is a palindrome, it is added to the list and the count is increased
 * 7. Output method prints the number of palindromes and the palindromes for both
 * 
 * Number of times recursive method is called: XXX
 * Number of times iterative method is called: YYY

 */

public class Lab7 {
	static int palindromesCount;
	static String palindromes;
	static int numIterativePalindromesCount;
	static String iterativePalindromes;

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Please choose a file that contains a list of words. " +
				"This program will test each word to see if it is a palindrome."); //displays the instructions to the user
		File inputFile = getInputFile(); //calls the method that lets the user choose their file
		readFile(inputFile); //calls method that reads file and calls palindrome methods
		output();
	}

	/**
	 * This method allows the user to choose a file from their folders to test
	 * @return the file chosen by the user
	 */
	private static File getInputFile() {
		//allows user to choose file from folders
		JFileChooser chooser = new JFileChooser();
		File home = new File(System.getProperty("user.home"));
		chooser.setCurrentDirectory(home);

		//if the user doesn't choose a file, the program will terminate
		int status = chooser.showOpenDialog(null);
		if (status != JFileChooser.APPROVE_OPTION) {
			System.out.println("No File Chosen");
			System.exit(0);
		}
		return chooser.getSelectedFile();//returns the file that the user chose
	}

    /**
		 * Reads lines from file as strings and checks if they are palindromes
		 * If they are palindromes, the word is added to an arraylist of 
		 * palindromes
		 */
		public static void readFile (File inputFile) {
			palindromes= "";
			iterativePalindromes="";
			try {
				Scanner scanner = new Scanner(inputFile);
				while (scanner.hasNextLine()) {
					String string = scanner.nextLine();
					palindrome(string);
					if(palindrome(string) == true) { 
						palindromes += string+"\n";
						palindromesCount++;
					}

					palindromeIterative(string);
					if(palindromeIterative(string) == true) {
						iterativePalindromes += string+"\n";
						numIterativePalindromesCount++;
					}
				}
					
				scanner.close();
				} catch (FileNotFoundException e) {
					System.out.println("File: " + inputFile + " not found");
				}
		}


	/** FINISH
	 * Recursive method that determines if a string is a palindrome
	 * @param string
	 * @return if the string is a palindrome or not
	 */
	public static boolean palindrome(String string) {
		if(string.length() <= 1) {
			return true;
		}
		
		if(string.charAt(0) == string.charAt(string.length()-1)) {
			return palindrome(string.substring(1, string.length()-1));
		}
		
		return false;
	}

	//			notes:
	//			  String fullName = "Cynthia, Susan Lee;Sue Smith     ";
	//	        fullName.substring(8, 14)); //gets substring from positions 8 to 14
	//   string.charAt(0); //gets the character at the 0 position
	// string.length(); //gets the length of the string
	// string.charAt(string.length()-1) //gets the character in the last position
	
	
	
	
	/** FINISH Iterative method that determines if a string is a palindrome
	 * @param string
	 * @return if the string is a palindrome or not
	 */
	public static boolean palindromeIterative(String string) {
		int left = 0;
		int right = string.length()-1;
		
		while(left < right) {
			if(string.charAt(left) != string.charAt(right)) {
				return false;
			}
			left+=1;
			right-=1;
			
		}
		
		return true;
		
	} 

	/**
	 * output that is shown to the user
	 * @param palindromes
	 * @param palindromesCount 
	 */
	public static void output(){
		System.out.println("There are " + palindromesCount + " palindromes in this list, found recursively.");
		System.out.println("The words that are palindromes are: \n" + palindromes);
		System.out.println("There are " + numIterativePalindromesCount + " palindromes in this list, found iteratively.");
		System.out.println("The words that are palindromes are: \n" + iterativePalindromes);
	}
}

