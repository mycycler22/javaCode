package lab4;
/**
* Dice.java
* Simulates die and dice rolls
* Used in RaceTest class
* @author Lewis/Loftus with updates by WeitlHarms
*/

public class Dice
{
   private final int MIN_FACES = 4;

   private int numFaces;   // number of sides on the die
   private int faceValue;  // current value showing on the die
   private int numRolls;   // number of rolls
   /**
    * Defaults to a six-sided die. Initial face value is 1.
    */
   public Dice ()
   {
      this(6);
   }

   /**
    * Explicitly sets the size of the die. Defaults to a size of
    * six if the parameter is invalid.  Initial face value is 1. 
    * @param faces
    */
   public Dice (int faces)
   {
      if (faces < MIN_FACES)
         numFaces = 6;
      else
         numFaces = faces;
      numRolls=0;
      faceValue = 1;
   }

  /**
   *  Rolls the die.
   * @return the result
   */
   public int roll ()
   {
      faceValue = (int) (Math.random() * numFaces) + 1;
      numRolls++;
      return faceValue;
   }

   /**
    * 
    * @return the current die value.
    */
   public int getFaceValue ()
   {
      return faceValue;
   }
   
	/**
	 * Gets the number of sides of the die
	 * @return the number of sides on the die
	 */
	public int getNumFaces() {
		return this.numFaces;
	}

   public String toString()
   {
       String outputString = "You rolled a " + faceValue;
       return outputString;
   }
}
