package hw4;

/** Cell object for the MazeGame for robot simulation program.
 * @author Mark Yan
 * @version@1.0 Fall 2025
 * 
 * You are NOT to modify this program
 */


public class Cell {

	private int row, col;
	private char val;
	
	/**
	 * constructor
	 */
	public Cell() {
		row=0;
		col=0;
		val='*';
	}	

	/**
	 * constructor that uses initial values
	 * @param r - row
	 * @param c -col
	 * @param v -character value 
	 */
	public Cell(int r,int c,char v)
	{	
		row=r;
		col=c;
		val=v;
	}
	
	public String toString() {return "["+row+":"+col+"]="+val;} //can be uncommented for testing purposes but is not needed
	
	/**
	 * getters
	 */
	public int getRow() {return row;}
	public int getCol() {return col;}
	public char getVal() {return val;}
	
	/**
	 * setters
	 */
	public void setRow(int r) {row=r;}
	public void setCol(int c) {col=c;}
	public void setVal(char v) {val=v;}
}
