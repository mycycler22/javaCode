package neonthal_baby;

import java.util.Scanner;

/**
 * Answers to HW1 Questions:
 * 1. D
 * 2. D
 * 3. A
 * 4. B
 * 5. A
 * 6. C
 * 7. D
 * 8. D
 * 9. A
 * 10. D
 */


/**
 * This program calculates Neonatal Infant Feeding tube placement

 * @author Mark Yan
 * @date 9/3/25
 * *****************************************
 * Algorithm:
 * Repeat until done:
 * 	Type of infant feeding (Oral/Nasal)
 *  Person's vitals (age (in days), length)
 *  Premature birth or not - if yes, the number of days premature is shown. 0 if no.
 *  Calculates the location of the tube placement
 *  Asks the user if they want to continue or not
 */

public class Baby {

	public static void main(String[] args) {
		
		boolean choice = true;
		
		do {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the type of tube: (oral/nasal)");
			String type = scanner.nextLine();
			type = type.toUpperCase();
			
			type = typeIdentifier(type);
			
			
			
			System.out.println("Enter the baby's age in days: ");
			int age = scanner.nextInt();
			System.out.println("Enter the baby's length in cm: ");
			double length = scanner.nextDouble();
			int premature = babyPremature(age);
			int result = 365 - premature;
			double placement = calculateInsert(result, length, type);
			System.out.println("Treatment type: " + type);
			System.out.println("age: " + age + " days");
			System.out.println("length: " + length + " cm");
			System.out.println("Days premature: " + premature + " days");
			
			
			System.out.println("For " + type.toLowerCase() + " treatment, the length of the tube should be: " + String.format("%.1f", placement) + " cm.");
		
		
			System.out.println("Do you want to continue? (y/n)");
			String option;
			option = scanner.next();
			option = option.toUpperCase();
		
			if(option.equals("N")){
				choice = true;
				scanner.close();
			}
			else {
				choice = false;
			}
		
		} while(!choice);
		
		
		

	}
	
	public static String typeIdentifier(String type) { // Tests if the type is valid
		
		Scanner scanner = new Scanner(System.in);
		while(!type.equals("ORAL") && !type.equals("NASAL")) {
			System.out.println("Enter the type of tube: (oral/nasal)");
			type = scanner.nextLine();
			type = type.toUpperCase();
		}

		
		return type;
		

		
		
		
	}
	
	public static double calculateInsert(int age, double length, String type) {
		// Calculates the distance of the tube given the type, length, and age of the baby.
		String method = type.toUpperCase();
		double result = 0.0;
		if(method.equals("ORAL")) {
			if(age < 365) {
				result = 13.3 + (.19 * length);
			}
			else {
				result = 16.8 + (.19 * length);
			}
		}
		else if(method.equals("NASAL")) {
			if(age < 365) {
				result = 14.8 + (.19 * length);
			}
			else {
				result = 18.3 + (.19 * length);
			}
		}
		
		
		return result;
		
	}
	public static int babyPremature(int age) {
		// Premature birth status and how many days premature
		
		Scanner scanner = new Scanner(System.in);
		String mature = "";
		int premature = 0;
		int result = 0;
		System.out.println("Was the baby born prematurely? (y/n)");
		mature = scanner.nextLine();
		mature = mature.toUpperCase();
		
		while(!mature.equals("Y") && !mature.equals("N")) {
			System.out.println("Was the baby born prematurely? (y/n)");
			mature = scanner.nextLine();
			mature = mature.toUpperCase();
		}
		
		if(mature.equals("Y")) {
			System.out.println("How many days premature?");
			premature = scanner.nextInt();
		}
		else {
			premature = 0;
		}
		

		
		return premature; 
		
		
		
	}

}
