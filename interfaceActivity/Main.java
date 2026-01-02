package interfaceBonus;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 3.5));
        students.add(new Student(2, "Bob", 3.7));
        students.add(new Student(3, "Charlie", 3.5));

        // Creating an instance of StudentSorter
        StudentSorter sorter = new StudentSorter();
        // Sorting the students
        List<Student> sortedStudents = sorter.sortStudents(students);

        // Printing the sorted list of students
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
	}

}
