/**
Purpose: Playing rock,paper, scissors
@Author: Mark Yan
@Date: 8/26/25
@version
Outline: the user inserts their choice and computer selects a choice as well. 
Plays according to normal rules of rock,paper, scissors

 */
package lab1;

import javax.swing.JOptionPane;
 import java.util.Random;
 
 public class Lab1Start{
 
   public static void main(String[] args) {
 
     greeting();
 
     int numRounds = 3;
     int ties = 0; 
     int userWins = 0;
     int computerWins = 0;
 
     for(int i = 1; i <= numRounds; i++) {
 
       char computerChoice = generateComputersChoice();
       char userChoice = enterPlayersChoice(i);
 
       String result = getRoundResult(computerChoice, userChoice);
 
       if(result.equals("It's a tie!")) {
         ties++;
       }
       else if(result.contains("User")) {
         userWins++;
       }
       else {
         computerWins++;
       }
 
       displayRoundResult(i, computerChoice, userChoice, result);
 
     }
 
     displaySummary(numRounds, ties, userWins, computerWins);
 
   }
 
   public static void greeting() {
     JOptionPane.showMessageDialog(null, "Let's play Rock Paper Scissors!"); 
   }
 
   /**
    * generate a random integer
    * based on the integer, return character 'R', 'P', or 'S'
    * @return
    */
   public static char generateComputersChoice() {
 
     Random rand = new Random();
     int choice = rand.nextInt(3);
     //    * based on the integer choice, return character 'R', 'P', or 'S'
     char answer =' ';
     if(choice == 1) {
    	 answer = 'R';
     }
     else if(choice == 2) {
    	 answer = 'P';
     }
     else {
    	 answer = 'S';
     }
     
     	return answer;
   }
 
   /**
    * capture the player's choice using showInputDialog
    * @param round
    * @return the first character of the players choice, such as response.charAt(0)
    */
   public static char enterPlayersChoice(int round) {

    
     String response = JOptionPane.showInputDialog("Rock, Paper, or Scissors?");
     response = response.toUpperCase();
     return response.charAt(0);
 
   }
 
   /**
    * get the results of one round
    * @param computerChoice
    * @param userChoice
    * @return one of the following sayings:
    * "It's a tie!"
    * "Computer wins!"
    * User wins!"
    */
   public static String getRoundResult(char computerChoice, char userChoice) {
	   String result = "";
	   if(computerChoice == 'R' && userChoice == 'S') {
		   result = "Computer Wins!";
	   }
	   else if(computerChoice == 'R' && userChoice == 'P') {
		   result = "User Wins!";
	   }
	   else if(computerChoice == 'S' && userChoice == 'P') {
		   result = "Computer Wins!";
	   }
	   else if(computerChoice == 'S' && userChoice == 'R') {
		   result = "User Wins!";
	   }
	   else if(computerChoice == 'P' && userChoice == 'R') {
		   result = "Computer Wins!";
	   }
	   else if(computerChoice == 'P' && userChoice == 'S') {
		   result = "User Wins!";
	   }
	   else if(computerChoice == userChoice) {
		   result = "It's a tie!";
	   }
	   
	   return result;
   }
 
   /**
    * maps the character choice to the word for output
    * @param choice
    * @return
    */
   public static String mapChoice(char choice) {
	 String result = "";
	 if(choice == 'S') {
		 result = "Scissors";
	 }
	 else if(choice == 'P') {
		 result = "Paper";
	 }
	 else if(choice == 'R') {
		 result = "Rock";
	 }
     return result;
   }
 
   /**
    * display the round results
    * @param round
    * @param computerChoice
    * @param userChoice
    * @param result
    */
   public static void displayRoundResult(int round, char computerChoice, char userChoice, String result) {
     
     String computer = mapChoice(computerChoice);
     String player = mapChoice(userChoice);
 
     JOptionPane.showMessageDialog(null,  
       "For game " + round + "\n" +
       "Computer played " + computer + "\n" +
       "Player played " + player + "\n" +
       "Result: " + result);
   }
 
   /**
    * display the summary of all rounds
    * @param rounds
    * @param ties
    * @param userWins
    * @param computerWins
    */
   public static void displaySummary(int rounds, int ties, int userWins, int computerWins) {
 
     JOptionPane.showMessageDialog(null, 
       "For a total of " + rounds + "games," +
       "\nThere were " + ties + " ties" +
       "\nThere were " + userWins + " wins for you" +
       "\nThere were " + computerWins + " wins for the computer");
 
   }
 
 }