package lab11;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Class for ranking and identifying good job candidates
 * @author Catie Baker and Sherri Weitl-Harms
 * @version 11/9/2025
 */
public class CandidateRanker {
	private ArrayList<Candidate> candidates;

	/**
	 * Reads in the file of candidates and stores them in a list
	 * @param filename the file with the candidate data
	 */
	public CandidateRanker(File file) {
		this.candidates = new ArrayList<Candidate>();

		try {
			Scanner infile = new Scanner(file);

			while (infile.hasNextLine()) {
				String id = infile.next();
				double overallGPA = infile.nextDouble();
				double csGPA = infile.nextDouble();
				double cs1 = infile.nextDouble();
				double cs2 = infile.nextDouble();
				double ds = infile.nextDouble();
				double algs = infile.nextDouble();
				double softEng = infile.nextDouble();
				double capstone = infile.nextDouble();
				int commSkills = infile.nextInt();
				infile.nextLine();
				Candidate cand = new Candidate(id, overallGPA, csGPA, cs1, cs2, ds, algs, softEng, capstone,commSkills);
				this.candidates.add(cand);
			}
			infile.close();
		}
		catch (java.io.FileNotFoundException e) {
			System.out.println("No such file: " + file);
		}
//		FINISH: call Collections.sort method here
		Collections.sort(candidates);
	}
	
	public String toString() {
		String output="";
		int count = candidates.size();
		for (Candidate c:candidates) {
			output+= count + ") "+ c+"\n";
			count-=1;
		}
		
		return output;
	}
	
	
	
	
	/** FINISH:
	 * If the rank is positive - get the element from that highest candidate from the end of the ArrayList
	 * if the rank is negative - get the element from that lowest candidate from the beginning of the ArrayList
	 * if it is more than the Size of the ArrayList, state that no candidate exists at that rank
	 */
	 public String lookupByRank(int rank)
	{	
		 if(rank > candidates.size()){
			 return "No such candidate exists at rank " + rank;
		 }
		 else if(rank > 0) {
			 return rank + ") " + candidates.get(candidates.size() - rank).toString();
		 }
		 else if(rank < 0) {
			 return (candidates.size() + 1 + rank) + ") " + candidates.get(0 - rank).toString();
			 
		 }

		 
		 return "Invalid";
		 
	}
	 
	 /**
	  * Bonus method; returns the top candidates based on the number of desired candidates
	  * 
	  * @param standard
	  * @return the list of those who have a ranking above the standard
	  */
	 
	 public String showTopCandidates(int standard) {
		 ArrayList<Candidate> filtered = new ArrayList<Candidate>(candidates.subList(candidates.size()-(standard), candidates.size()));
		 
		 Collections.sort(filtered, Collections.reverseOrder());
		 String output = "";
		 int count = 1;
		 
		 for(Candidate c: filtered) { 
			 output+= count + ") " +  c + "\n";
			 count+=1;
		 }
		 
		 
		 
		 return output;
		 
	 }
	 
	 /**
	  * Bonus method; returns the list of candidates with a quality score above the standard
	  * 
	  * @param standard
	  * @return String of candidates who meet the score standard
	  */
	 
	 public String showCandidatesAbove(double standard) {
		 //ArrayList<Candidate> filtered = new ArrayList<Candidate>();
		 String output = "";
		 Collections.reverse(candidates);
		 
		 for(int i = 0; i < candidates.size(); i++) {
			 Candidate c = candidates.get(i);
			 
			 if(c.getQualityScore() > standard) {
				 int rank = i + 1;
				 output += rank + ") " + c.toString() + "\n"; 
			 }
		 }
		 
		 
		 //for(Candidate c: candidates) {
			// if(c.getQualityScore() > standard) {
			//	 filtered.add(c);
			 //}
		 //}

		 
		 //for(Candidate f: filtered) {
			 //output+=f + "\n";
		 //}
		 
		 return output;
	 }
	
}
