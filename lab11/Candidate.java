package lab11;

/**
 * Stores the grade information about a CS job candidate with 
 * the candidate ID
 * @author Catie Baker and Sherri WeitlHarms
 * @version 11/6/25
 *
 */
public class Candidate implements Comparable<Candidate>
{ 
	private String candidateID;
	private double overallGPA;
	private double csGPA;
	private double cs1;
	private double cs2;
	private double dataStructures;
	private double algs;
	private double softEng;
	private double capstone;
	private int communicationSkills;
	
	/**
	 * This creates a a Candidate object that stores the 
	 * data about a single candidate
	 * @param candidateID the id used to link candidate personal information
	 * @param gpa the candidates overall GPA
	 * @param major the candidates CS major GPA
	 * @param cs1 the candidates grade in CS1 in GPA points (e.g. 4.0 or 3.5)
	 * @param cs2 the candidates grade in CS2 in GPA points (e.g. 4.0 or 3.5)
	 * @param ds the candidates grade in data structures in GPA points (e.g. 4.0 or 3.5)
	 * @param algs the candidates grade in algorithms in GPA points (e.g. 4.0 or 3.5)
	 * @param se the candidates grade in software engineering in GPA points (e.g. 4.0 or 3.5)
	 * @param cap the candidates grade in capstone in GPA points (e.g. 4.0 or 3.5)
	 * @param communicate the candidates ability to communicate about their skills as self-ranked (0-10)
 */
	public Candidate(String candidateID, double gpa, double major, double cs1, double cs2, 
			double ds, double algs, double se, double cap, int communicate) {
		this.candidateID = candidateID;
		this.overallGPA = gpa;
		this.csGPA = major;
		this.cs1 = cs1;
		this.cs2 = cs2;
		this.dataStructures = ds;
		this.algs = algs;
		this.softEng = se;
		this.capstone = cap;
		this.communicationSkills=communicate;
	}
	
	/** FINISH
	* Calculates a quality score for the candidate based off their data. Higher numbers are
	* stronger candidates.
	* Stronger value given to software engineering and the capstone
	* Weaker value given to overall GPA and Communication Skills - we're trying to find good Comp Sci candidates
	* @return the quality score of the candidate
	**/
	public double getQualityScore() {
		double score = (overallGPA * .9) + csGPA + cs1 + cs2 + dataStructures + algs + (softEng * 1.15) + (capstone * 1.15) + (communicationSkills * .7);
		
		score = Math.round(score * 100.0)/100.0;
		
		return score;
	}

	
 /** FINISH
     * Compares this Candidate object with other using the score method.
     * @param other the Candidate object being compared with
     * @return a negative int if the candidate score is < the candidate score of other,
     *         0 if the candidate score == the candidate score of  other
     *         a positive int if the candidate score is > the candidate score other,
     */
	public int compareTo(Candidate other) {
		if(this.getQualityScore() == other.getQualityScore()) {
			return 0;
		}
		else if(this.getQualityScore() > other.getQualityScore()) {
			return 1;
		}
		else {
			return -1;
		}
		
     }

	
	/**
	 * Gets the id that links the candidate data to their personal data
	 * @return the candidates id that links to their personal data
	 */
	public String getCandidateID() {
		return this.candidateID;
	}

	/**
	 * Gets the candidates overall gpa
	 * @return the candidates overall gpa
	 */
	public double getOverallGPA() {
		return overallGPA;
	}

	/**
	 * Gets the candidates cs major gpa
	 * @return the candidates cs major gpa
	 */
	public double getCSGPA() {
		return csGPA;
	}

	/**
	 * Gets the candidates grade in CS1
	 * @return the candidates grade in CS1
	 */
	public double getCS1() {
		return cs1;
	}

	/**
	 * Gets the candidates grade in CS2
	 * @return the candidates grade in CS2
	 */
	public double getCS2() {
		return cs2;
	}

	/**
	 * Gets the candidates grade in data structures
	 * @return the candidates grade in data structures
	 */
	public double getDataStructures() {
		return dataStructures;
	}

	/**
	 * Gets the candidates grade in algorithms
	 * @return the candidates grade in algorithms
	 */
	public double getAlgs() {
		return algs;
	}

	/**
	 * Gets the candidates grade in software engineering
	 * @return the candidates grade in software engineering
	 */
	public double getSoftEng() {
		return softEng;
	}

	/**
	 * Gets the candidates grade in capstone
	 * @return the candidates grade in capstone
	 */
	public double getCapstone() {
		return capstone;
	}
	
	
	/**
	 * Gets the candidates communication skill rating
	 * @return candidates communication skill rating
	 */
	public int getCommunicationSkills() {
		return communicationSkills;
	}
	
	/**
	 * Gets the string representation of the candidate. Prints their ID followed by 
	 * relevant grades
	 * @return summary data about the candidate
	 */
	public String toString() {
		return "Candidate "+ this.candidateID + " SCORE: " + getQualityScore() + " - Overall GPA: "+this.overallGPA + 
				" CS GPA: "+this.csGPA +
				" CS1: "+this.cs1 + " CS2: "+this.cs2 +
				" Data Structures: "+this.dataStructures +
				" Algos: "+this.algs + 
				"Software Engineering: "+this.softEng + 
				" Capstone: "+this.capstone+
				" Communication skills: "+this.communicationSkills;
	}
	
}
