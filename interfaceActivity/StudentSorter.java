package interfaceBonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that puts students in a list and sorts them based on student GPA
 * 
 * @author Mark Yan
 * @version 12.7.25
 * 
 */

public class StudentSorter {

	/**
	 * Method that returns a sorted list of students
	 * 
	 * @param students
	 * @return sortedStudents
	 */
	public List<Student> sortStudents(List<Student> students){
		List<Student> sortedStudents = new ArrayList<>(students);
		Collections.sort(sortedStudents);
		
		return sortedStudents;
	}

}
