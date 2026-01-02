package hw2;
/**
 * Class that simulates a Stage with doors
 * @author Sherri Weitl-Harms (based on content from Catie Baker)
 *
 */
public class StageDoors {
	private int numDoors;
	
	/**
	 * Creates a StageDoor object with the specified number of doors
	 * @param doors the number of doors on the stage
	 */
	public StageDoors(int doors) {
		numDoors = doors;
	}
	
	/**
	 * Choose a door
	 * @return a random number between 1 and the number of doors (inclusive)
	 */
	public int roll() {
		return (int) (Math.random()*this.numDoors) + 1;
	}
	
	/**
	 * Gets the number of doors on the Stage
	 * @return the number of doors on the Stage
	 */
	public int getNumDoors() {
		return this.numDoors;
	}
}
