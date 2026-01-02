package lab11;

import java.io.File;
import javax.swing.JFileChooser;


/**
 * this class creates rectangle objects from a file's data and places them into an ArrayList that will be displayed
 * @author Sherri WeitlHarms
 * Algorithm:

 */
public class Lab11Driver {

	public static void main(String[] args)  {

		File fileName = getFile();
		CandidateRanker cr = new CandidateRanker(fileName);

		System.out.println(cr);
		
		
		System.out.println(cr.lookupByRank(1));
		System.out.println(cr.lookupByRank(-1));		
		System.out.println(cr.lookupByRank(2000));
		System.out.println("");
		System.out.println(cr.showTopCandidates(10));
		System.out.println(cr.showCandidatesAbove(38.0));
	}

	public static File getFile() {
		JFileChooser chooser;
		try {

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION) {
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}
}
