package hw3;
/**
 * Class for creating an AccessibilityTest object
 * 
 * @author Mark Yan
 * @version 9.24.25
 * 
 */
public class AccessibilityTest {
	private String category;
	private String googleResult;
	private String waveResult;
	private String sortsiteResult;
	private String aslintResult;
	private String testCase;
	
	/**
	*
	* Constructs an ArrayList object initializing the category, google check result,
	* wave result, sortsite result, aslint result, and the test case. 
	*/
	public AccessibilityTest(String categoryString, String googleString, String waveString, String sortsiteString, String aslintString, String testString) 
	{
		this.category = categoryString;
		this.googleResult = googleString;
		this.waveResult = waveString;
		this.sortsiteResult = sortsiteString;
		this.aslintResult = aslintString;
		this.testCase = testString;
	
	
	}
	
	
	/**
	 * Getter method that returns the test category
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * Getter method that returns the Google checker's test result
	 * @return the result from the Google checker
	 */
	public String getGoogleResult() {
		return this.googleResult;
	}
	/**
	 * Getter method that returns the WAVE checker's test result
	 * @return the result from the WAVE checker
	 */
	public String getWaveResult() {
		return this.waveResult;
	}
	/**
	 * Getter method that returns the Sortsite checker's test result
	 * @return the result from the sortsite checker
	 */
	public String getSortsiteResult() {
		return this.sortsiteResult;
	}
	/**
	 * Getter method that returns the asLint checker's test result
	 * @return the result of the ASlint checker
	 */
	public String getAslintResult() {
		return this.aslintResult;
	}
	/**
	 * Getter method that returns the comments attached to the test case
	 * @return the test case comments
	 */
	public String getTestCase() {
		return this.testCase;
	}
	/**
	 * toString method that makes the test results readable
	 * @return the result in a String format
	 */
	public String toString() {
		return this.category + ": " + this.testCase + " Google: " + this.googleResult + " WAVE: " + this.waveResult + " SortSite: " + this.sortsiteResult
				+ " ASLint: " + this.aslintResult;
	}
	
	
}
