package hw2;
import java.util.Scanner;

/**
 * This class allows a player to simulate the Game Show Game
 * 
 * @author Mark Yan
 * @version 9.15.25
 * 
 * ****************************
 */
public class GameShowDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to Let's Make a Deal! A car is waiting for you...");
		GameShowStats game = new GameShowStats();
		Scanner keyboard = new Scanner(System.in);
		//while(true) {
		System.out.println("What door are you going to pick (1-3)?");
		int door = keyboard.nextInt();
		while(door < 1 || door > 3) {
			System.out.println("Pick a number between 1 and 3.");
			door = keyboard.nextInt();
		}
		System.out.println("Are you going to stay or switch?");
		String ans = keyboard.next();
		
		while(!ans.equalsIgnoreCase("stay") && !ans.equalsIgnoreCase("switch")) {
			System.out.println("Are you going to stay or switch?");
			ans = keyboard.next();
		}
		boolean win;

		System.out.println("How may rounds do you want to play with these options?");
		int rounds = keyboard.nextInt();
			
		for(int i = 0; i < rounds; i++) {
			String option = ans;
			int doorChoice = door;
			
			if(option.equalsIgnoreCase("stay")) {
				win = game.playGame(doorChoice, true);
			}
			else {
				win = game.playGame(doorChoice, false);
			}
				
		}
			
			
			//if(win) {
					//System.out.println("You won!");
			//}
			//else {
				//System.out.println("Aww, it was a goat.");
			//}
			
			//System.out.println("Do you want to play again? y or n");
			//ans = keyboard.next();
			//if(ans.equalsIgnoreCase("n")) {
				//break;
			//

				
				
			//}
			
		
		
		//}
		System.out.println(game.showStats());
		System.out.println("Thank you for playing! See you next time!!");
	}

}



