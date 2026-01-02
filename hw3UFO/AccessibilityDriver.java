package hw3;
import java.util.Scanner;
/**
 * Provides an interface for the user to print useful stats about the
 * accessibility checkers performance.
 * 
 *  @author Catie Baker, Sherri Weitl-Harms
 *  @version 9.24.25
 */
public class AccessibilityDriver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//System.out.println("What is the file that has the test results?");
		//String filename = keyboard.nextLine().trim();
		String filename = "a11yCheckersResults.txt";
		AccessibilityResults lookup = new AccessibilityResults(filename);
		
	//	lookup.showByCategory("Key"); //this can provide a simple test for you
	//	lookup.showTestResults("Colour"); //this can provide a simple test for you
		
		
		System.out.println(
				"\n\nPlease type one of the following options:\ncategory: prints the test results by category\n"
						+ "description: prints the results of the tests whose decription contains the text you enter\n"
						+ "failed: prints the tests that all checkers failed\n"
						+ "summary: prints a summary table of the test results by checker and category\n"
						+ "quit: quits the program");
		String input = keyboard.nextLine().trim();
		while (!input.startsWith("q")) {
			if (input.equals("category")) {
				System.out.println("What category do you want to print the results for?");
				String cat = keyboard.nextLine();
				lookup.showByCategory(cat);
			} else if (input.equals("description")) {
				System.out.println("What description do you want to print the results for?");
				String description = keyboard.nextLine();
				lookup.showTestResults(description);
			} else if (input.equals("failed")) {
				lookup.showAllFailed();
			} else if (input.equals("summary")) {
				AccessibilityDriver.printSummary(lookup);
			} else {
				System.out.println("Invalid command - try again");
			}
			System.out.println(
					"\n\nPlease type one of the following options:\ncategory: prints the test results by category\n"
							+ "description: prints the results of the tests whose decription contains the text you enter\n"
							+ "failed: prints the tests that all checkers failed\n"
							+ "summary: prints a summary table of the test results by checker and category\n"
							+ "quit: quits the program");
			input = keyboard.nextLine().trim();
	
		
		}
		
		
	}

	/**
	 * Prints a formatted table of the results broken down by category
	 * and checker
	 * @param a11y the object holding the test results data
	 */
	public static void printSummary(AccessibilityResults a11y) {
		String[] categories = { "content", "colour/contrast", "layout", "typography", "language", "title", "headings", "lists",
				"tables", "images", "multimedia", "links", "buttons", "forms", "navigation", "keyboard", "frames",
				"css", "html", "" };
		System.out.format("%15s%13s%13s%13s%13s%13s%13s%n", "Category", "google", "wave", "sortsite", "aslint",
				"average", "possible");
		for (String cat : categories) {
			int num = a11y.numTests(cat);
			double googlePer = 100.0 * a11y.numPass("google", cat) / num;
			double wavePer = 100.0 * a11y.numPass("wave", cat) / num;
			double sortsitePer = 100.0 * a11y.numPass("sortsite", cat) / num;
			double aslintPer = 100.0 * a11y.numPass("aslint", cat) / num;
			double avgPer = (googlePer + wavePer + sortsitePer + aslintPer) / 4.0;
			double avgCount = (a11y.numPass("google", cat) + a11y.numPass("wave", cat) + a11y.numPass("sortsite", cat)
					+ a11y.numPass("aslint", cat)) / 4.0;
			System.out.format("%16s %3d (%5.1f%%) %3d (%5.1f%%) %3d (%5.1f%%) %3d (%5.1f%%) %5.1f (%5.1f%%) %5d%n", cat,
					a11y.numPass("google", cat), googlePer, a11y.numPass("wave", cat), wavePer,
					a11y.numPass("sortsite", cat), sortsitePer, a11y.numPass("aslint", cat), aslintPer, avgCount,
					avgPer, a11y.numTests(cat));

		}
	}

}
