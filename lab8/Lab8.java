package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

/***********************************************************************************************************
 * CSC 222 Lab 8 
 *
 * Imagine that you are developing a software package that requires users to enter their own
 passwords. Your software requires that user passwords meet the following criteria:

 The password should be at least six characters long.
 The password should contain at least one uppercase and at least one lowercase letter.
 The password should have at least one digit and one special character.
 (A special character is not alphabetic and is not a digit).
 The password should not be in the file - ArrayList of not allowed passwords.
 In general, this array may include several words, or be null.
 For testing purposes, do not allow passwords to be one of  the following strings: "Password1","Mypassw0rd".
 Ask for the user name and password.
 Keep asking for a password until the user enters a password that meets the criteria above.
 Output the username and the password. Then, output the user and the hidden password ******.

 Add JavaDoc comments to this program.
 ********************************************************************************************************/

public class Lab8 {

	public static void main(String[] args) {
		String badFile = getFileName();
		ArrayList<String> notAllowed = loadBadList(badFile);
		boolean valid;
		boolean allowed;
		String userName;
		String password;
		Scanner scanner = new Scanner(System.in);
		
		
		
		System.out.println("Enter your username: ");
		userName = scanner.nextLine();
		System.out.println("Enter your password: ");
		password = scanner.nextLine();
		
		
		allowed = isAllowed(password, notAllowed);
		valid = isValidPassword(password);
		
		while(!valid || !allowed) {
			System.out.println("Enter a new password");
			password = scanner.nextLine();
			allowed = isAllowed(password, notAllowed);
			valid = isValidPassword(password);
		}
		
		String hidden = encryptPassword(password);
		
		
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		System.out.println("User: " + userName);
		System.out.println("Hidden password: " + hidden);
		
		
		
	
	}

	/**
	 * Loads the content from a text file into an ArrayList. Program terminates if the filename is invalid
	 * Returns the ArrayList
	 * 
	 * @param filename
	 * @return badpass ArrayList
	 */
	
	public static ArrayList<String> loadBadList(String filename)
	{
		ArrayList<String> badpass = new ArrayList<String>();
		
		try {
			Scanner infile = new Scanner(new File(filename));
			while(infile.hasNextLine()) {
				String badWord = infile.nextLine().trim();
				badpass.add(badWord);
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(filename + " not found.");
			System.exit(1);
		}

		return badpass;
	}
	
	/**
	 * Tests if the password is in the badPasses ArrayList. If the password is in the ArrayList, then it's invalid
	 * 
	 * @param pass
	 * @param badPasses
	 * @return true if the password isn't located in the ArrayList, false if the password is located in the ArrayList
	 */
	
	public static boolean isAllowed(String pass, ArrayList<String> badPasses) {
		for(int i = 0; i < badPasses.size(); i++) {
			if(badPasses.get(i).equals(pass)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Tests if the password meets the requirements (lowercase letter, special character, capital letter, number)
	 * 
	 * @param pass
	 * @return if the password meets/does not meet the requirements
	 */
	
	public static boolean isValidPassword(String pass) {
		String lowercase = "qwertyuiopasdfghjklzxcvbnm";
		String uppercase = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String specials = "!#$%&()*+,-.:;<=>?@[]^_`{|}~";
		String numbers = "0123456789";
		
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasSpecial = false;
		boolean hasNumber = false;
		
		
		if(pass.length() < 6) {
			return false;
		}
		else if(pass.contains(" ")) {
			return false;
		}
		
		for(int i = 0; i < pass.length(); i++) {
			char character = pass.charAt(i);
			String ch = String.valueOf(character);
			boolean isValidChar = lowercase.contains(ch) || uppercase.contains(ch) || specials.contains(ch) || numbers.contains(ch);
			if(!isValidChar) {
				return false;
			}
			if(lowercase.contains(ch)) {
				hasLower = true;
			}
			else if(uppercase.contains(ch)) {
				hasUpper = true;
			}
			else if(specials.contains(ch)) {
				hasSpecial = true;
			}
			else if(numbers.contains(ch)) {
				hasNumber = true;
			}
			
			
		}
		

		
		return hasLower && hasUpper && hasSpecial && hasNumber;
		
	}
	
	/**
	 * 
	 * Returns the user's password but all of the characters are encrypted in asterisks
	 * 
	 * @param pass
	 * @return the encrypted password
	 */
	
	public static String encryptPassword(String pass) {
		char replacement = '*';
		
		String encrypted = pass.replaceAll(".", pass.valueOf(replacement));
		
		return encrypted;
		
	}
	
	

	/**
	 * Prompts the user to enter the name of the file that contains the bad password list
	 * @return filename
	 * 
	 */
	public static String getFileName() {
		String fileName = "";
		String prompt = "Please input the name of the file that contains the bad password list";
		fileName = JOptionPane.showInputDialog(null, prompt,
				"Enter File Name", 1);
		
		
		return fileName;
	
	
	}
	
}
