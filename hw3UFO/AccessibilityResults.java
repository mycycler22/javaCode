package hw3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * The results file to display the results of the AccessibilityTest object
 * 
 * @author Mark Yan
 * @version 9.24.25
 * 
 */
public class AccessibilityResults {
	private ArrayList<AccessibilityTest> results;
	
	/**
	 * 
	 * 
	 * Creates a new ArrayList as well as reading through filename and putting it
	 * in an ArrayList
	 * @param filename
	 * 
	 */
	public AccessibilityResults(String filename) {
		this.results = new ArrayList<AccessibilityTest>();
		
		try
		{
			Scanner infile = new Scanner(new File(filename));
			while(infile.hasNextLine()) {
				String category = infile.next();
				String google = infile.next();
				String wave = infile.next();
				String sortsite = infile.next();
				String asline = infile.next();
				String test = infile.nextLine().trim();
				
				AccessibilityTest result = new AccessibilityTest(category, google, wave, sortsite, asline, test);
				
				this.results.add(result);
			}
		infile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: Cannot find file: "+filename);
		}
	}
	
	/**
	 * 
	 * Void method that prints out the test cases with the given description
	 * Prints the tests that contain the description
	 * Adds the tests to a new ArrayList (valid)
	 * Splits the String by the ":"
	 * Adds each word to a new ArrayList (words)
	 * Counts the number of times "error" or "manual" appears in the ArrayList
	 * Matching tests = "error" and "manual" results
	 * Prints the number of matching tests
	 * @param desc
	 * 
	 */
	
	public void showTestResults(String desc) {
		int count = 0;
		ArrayList<String> valid = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		String lower = desc.toLowerCase();
		for(AccessibilityTest t: results) {
			if(t.getTestCase().contains(desc) || t.getTestCase().contains(lower)) {
				System.out.println(t);
				valid.add(t.toString());
			}
		}
		for(String s : valid) {
			String[] parts = s.split(":");
			words.addAll(Arrays.asList(parts));
			
		}
		for(String w: words) {
			if(w.contains("error")) {
				count+=1;
			}
			else if(w.contains("manual")) {
				count+=1;
			}
		
	}
		System.out.println("");	
		System.out.println("Total tests matching: " + count);
		
	}

	/**
	 * A void method that prints all of the tests in a given category (cat)
	 * @param cat
	 * Tests if the category contains the cat parameter
	 * If the category contains the parameter, the test is printed and count increments by 1
	 * Lowercase conditional included to serve the same function in the event cat has capital letters
	 * within the parameter. 
	 * 
	 * Prints the number of tests in a given category
	 */
	
	public void showByCategory(String cat) {
		int count = 0;
		String lowerCat = cat.toLowerCase();
		for(AccessibilityTest t: results) {
			if(t.getCategory().equals(cat) || t.getCategory().contains(cat)) {
				System.out.println(t);
				count+=1;
			}
			else if(t.getCategory().toLowerCase().equals(lowerCat) || t.getCategory().toLowerCase().contains(lowerCat)) {
				System.out.println(t);
				count+=1;
			}
		}
		System.out.println("");
		System.out.println("Total Tests in Category: " + count);
	}
	
	/**
	 * 
	 * Void method to show the tests where all the accessibility checkers failed
	 * Creates a new ArrayList
	 * Test failure = "notfound"
	 * Nested if statements to check if a test had all of its checkers = "notfound"
	 * If all conditions are met, then the test is printed and added to a new ArrayList
	 * Count = the number of times all the checkers failed
	 * 
	 */
	public void showAllFailed() {
		int count = 0;
		String failure = "notfound";
		ArrayList<String> valid = new ArrayList<>();
		for(AccessibilityTest t: results) {
			if(t.getGoogleResult().equals(failure)) {
				if(t.getWaveResult().equals(failure)) {
					if(t.getSortsiteResult().equals(failure)) {
						if(t.getAslintResult().equals(failure)) {
							System.out.println(t);
							valid.add(t.toString());
						}
					}
				}
			}	
		}
		count = valid.size();

		
		System.out.println("");
		System.out.println("Total tests failed: " + count);
		
	}
	
	/**
	 * Int method that returns the number of tests within a category
	 * 
	 * Counts the number of times a category appears in the category column in the ArrayList
	 * If the category column == cat or contains cat, count increments by 1
	 * Else if the cat parameter has capital letters, everything is converted to lowercase
	 * If the cat parameter is empty, the count value is the number of tests
	 * @param cat
	 * @return the number of tests in a category
	 */
	
	public int numTests(String cat) {
		int count = 0;
		String lowerCat = cat.toLowerCase();
		for(AccessibilityTest t: results) {
			if(t.getCategory().equals(cat) || t.getCategory().contains(cat)) {
				count+=1;
			}
			else if(t.getCategory().toLowerCase().equals(lowerCat) || t.getCategory().toLowerCase().contains(lowerCat)) {
				count+=1;
			}
			else if(cat == "") {
				count = results.size();
			}

		}
		
		return count;
	}
	/**
	 * Int method that returns the number of times a certain accessibility checker was successful
	 * within a given category. 
	 * New AccessibilityTest object to contain the tests from the cat parameter
	 * If the category equals or contains the cat parameter, the test is added to an ArrayList
	 * If there are capital letters present, the else if statement converts everything to lowercase and
	 * follows the same concept as the previous if statement
	 * If the cat parameter contains nothing, all the tests are added to the ArrayList
	 * 
	 * New AccessibilityTest object used to test each accessibility checker
	 * Successful test = "error" or "error_paid"
	 * Count increments by 1 if the checker returns "error" or "error_paid"
	 * 
	 * @param checker
	 * @param cat
	 * 
	 * @return the number of times an accessibility checker was successful within a given category
	 */
	
	
	public int numPass(String checker, String cat) {
		int count = 0;
		ArrayList<AccessibilityTest> category = new ArrayList<>();
		String lowerCat = cat.toLowerCase();	
		String valid = "error";
		String paid_valid = "error_paid";
		String google = "google";
		String wave = "wave";
		String sortsite = "sortsite";
		String aslint = "aslint";
		
		for(AccessibilityTest t: results) {
			if(t.getCategory().equals(cat) || t.getCategory().contains(cat)) {
				category.add(t);
			}
			else if(t.getCategory().toLowerCase().equals(lowerCat) || t.getCategory().toLowerCase().contains(lowerCat)) {
				category.add(t);
			}
			else if(cat == "") {
				category.add(t);
			}

		}
		
		for(AccessibilityTest x: category) {
			String lowerCheck = checker.toLowerCase();
			
			if(lowerCheck.equals(google) || google.toLowerCase().contains(lowerCheck)) {
				if(x.getGoogleResult().equals(valid) || x.getGoogleResult().equals(paid_valid)) {
					count+=1;
				}
			}
			else if(lowerCheck.equals(wave) || wave.toLowerCase().contains(lowerCheck)) {
				if(x.getWaveResult().equals(valid) || x.getWaveResult().equals(paid_valid)) {
					count+=1;
				}
			}
			else if(lowerCheck.equals(sortsite) || sortsite.toLowerCase().contains(lowerCheck)) {
				if(x.getSortsiteResult().equals(valid) || x.getSortsiteResult().equals(paid_valid)) {
					count+=1;
				}
			}
			else if(lowerCheck.equals(aslint) || aslint.toLowerCase().contains(lowerCheck)) {
				if(x.getAslintResult().equals(valid) || x.getAslintResult().equals(paid_valid)) {
					count+=1;
				}
			}
		}
		

		
		return count;
	}
	
}
