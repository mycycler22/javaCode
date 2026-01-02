package hw2;
/**
 * Simulates the Monty Hall problem where given three doors,
 * two of which have goats and one has a car, a player can
 * try to win the car by either staying with their initial guess 
 * or changing doors after a goat is revealed. This class will allow the player
 * to play the game and see the stats for the games they have played
 * thus far.
 * 
 * @author Mark Yan
 * @version 9.15.25
 *
 */
public class GameShowStats {
	private StageDoors doorPicker;
	private int rounds;
	private int switches;
	private int stays;
	private int switchWins;
	private int stayWins;
	

	/**
	 * Constructs a game show object with three doors
	 * Initializes the number of times the user switches doors or stays
	 * Initializes the number of times a user wins when switching doors
	 * Initializes the number of times the user wins when staying
	 */
	public GameShowStats() {
		doorPicker = new StageDoors(3);
		rounds = 0;
		switches = 0;
		stays = 0;
		switchWins = 0;
		stayWins = 0;
	}

	/**
	 * Simulates the Monty Hall problem where a the car is placed and a player
	 * can guess and initial door and then either stay or change their choice
	 * after the door with the goat is revealed.
	 * @param guess the number of the door that they guessed
	 * @param stay true if the player kept their original door, false if they switched
	 * If stay = false, the number of switches increases by 1
	 * If stay = true, the number of stays increases by 1
	 * @return true if the player won the car, false otherwise
	 */
	public boolean playGame(int guess, boolean stay) {
		rounds+=1;
		int carDoor = this.doorPicker.roll();
		if(!stay) {
			guess = this.switchDoor(guess, carDoor);
			//System.out.println("You switched to door "+guess);
			switches+=1;
		}
		else {
			stays+=1;
		}
		
		
		if(carDoor == guess && !stay) {
			switchWins+=1;
			return true;
		}
		else if (carDoor == guess && stay){
			stayWins+=1;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Determines what door a player would switch to after a goat is revealed
	 * @param guess the players initial guess
	 * @param car the location of the car
	 * @return the door that they would switch, -1 if guess is not a valid door
	 */
	private int switchDoor(int guess, int car) {
		if(guess == 1) {
			if(car == 2 || car == 3) {
				return car;
			}
			else {
				return 2;
			}
		}
		else if(guess == 2) {
			if (car == 1 || car == 3) {
				return car;
			}

			else {
				return 1;
			}
		}
		else if(guess == 3) {
			if(car == 1 || car == 2) {
				return car;
			}
			else {
				return 1;
			}
		}
		return -1;
	}
	
    /**
     * @return the number of rounds in this session
     */
	
	public int getRounds() {
		return rounds;
	}
	
    /**
     * @return the number of times the user kept their decision
     */
	public int getNumStay() {
		return stays;
	}
	
    /**
     * @return the number of times the user switched doors
     */
	public int getNumSwitch() {
		return switches;
	}
	
    /**
     * @return the number of times the user won when switching doors
     */
	public int getNumWonSwitch() {
		return switchWins;
	}
	
    /**
     * @return the number of times the user won when keeping their decision
     */
	public int getNumWonStay() {
		return stayWins;
	}
	
	
	

	
	
    /**
     * @return the results of the game session
     */
	public String showStats() {
		
		int stayWinPct = (int)Math.round(((double)getNumWonStay()/(double)getRounds()) * 100);
		int switchWinPct = (int)Math.round(((double)getNumWonSwitch()/(double)getRounds()) * 100);
		
		String result = "Stay: " + getNumWonStay() + " out of " + 
	getRounds() + " rounds the player won the car (" + stayWinPct + "%)" + 
				"\nSwitch " + getNumWonSwitch() + " out of " + getRounds() + 
				" rounds the player won the car (" + switchWinPct + "%).";
		
		
		return result;
		
		
	}
	
	


}
