package hw5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * The Maze class that creates a Maze object
 * 
 * @author Mark Yan
 * @version 10.27.25
 * 
 * 
 */

public class Maze {

	private int numRows, numCols;
	private int startRow, startCol;
	private int exitRow, exitCol;
	private ArrayList<Cell> maze;
	
	/**
	 * Constructor of the Maze object
	 * 
	 * @param filename
	 */
	public Maze(File filename) {
		this.maze = new ArrayList<>();
		
		try(Scanner input = new Scanner(filename)) {
			input.nextLine();
			input.nextLine();
			input.nextLine();
			
			ArrayList<String> lines = new ArrayList<>();
			
			while(input.hasNextLine()) {
				lines.add(input.nextLine());

				}

			numRows = lines.size();
			numCols = 0;
			for(String line: lines) {
				if(line.length() > numCols) {
					numCols = line.length();
				}
			}

			for(int i = 0; i < numRows; i++) {
				String line = lines.get(i);
				for(int c = 0; c < numCols; c++) {
					char ch;
					if(c < line.length()) {
						ch = line.charAt(c);
					}
					else { // Accounts for uneven rows
						ch = '*';
					}
					Cell cell = new Cell(i, c, ch);
					maze.add(cell);
										
					if(ch == 'S') {
						startRow = i;
						startCol = c;
					}
					else if(ch == 'X') {
						exitRow = i;
						exitCol = c;
					}
				}
			
			}
			
			input.close();
		}
		catch(IOException e) {
			System.out.println("Error reading file");
		}
	}

	/**
	 * Getter method that returns the number of rows in the maze
	 * 
	 * @return the number of rows in the maze
	 */
	public int getRows() {
		return numRows;
	}
	/**
	 * Getter method that returns the number of columns in the maze
	 * 
	 * @return the number of columns in the maze
	 */
	public int getCols() {
		return numCols;
	}
	/**
	 * Getter method that returns the row of the maze's starting location
	 * 
	 * @return the row where the start of the maze is located
	 */
	public int getStartRow() {
		return startRow;
	}
	/**
	 * Getter method that returns the column of the maze's starting location
	 * 
	 * @return the column where the start of the maze is located
	 */
	public int getStartCol() {
		return startCol;
	}
	/**
	 * Getter method that returns the row where the end of the maze is located
	 * 
	 * @return the row where the end of the maze is located
	 */
	public int getExitRow() {
		return exitRow;
	}
	/**
	 * Getter method that returns the column where the end of the maze is located
	 * 
	 * @return the column where the end of the maze is located
	 */
	public int getExitCol() {
		return exitCol;
	}
	/**
	 * Method that returns the cell element in the ArrayList
	 * 
	 * @param row
	 * @param col
	 * @return the character in the ArrayList
	 */
	public char getCell(int row, int col) {
		return maze.get(indexOf(row, col)).getVal();
	}
	/**
	 * Method that tests if the cell is an open space or not
	 * * - indicates a wall
	 * 
	 * @param row
	 * @param col
	 * @return whether the cell is a white space (true) or a wall (false)
	 */
	public boolean openCell(int row, int col) {
		char ch = getCell(row, col);
		if(getCell(row, col) != '*' && getCell(row, col) != 'D') {
			return true;
		}
		return ch != '*';
	}
	/**
	 * Void method that sets the value of the cell at the location
	 * 
	 * @param row
	 * @param col
	 * @param newCh
	 */
	public void setCell(int row, int col, char newCh) {
		maze.get(indexOf(row, col)).setVal(newCh);
	}
	/**
	 * Method that returns the location of the cell in the ArrayList
	 * 
	 * @param row
	 * @param col
	 * @return the location of the cell in the ArrayList
	 */
	public int indexOf(int row, int col) {
		return row * numCols + col;
	}
	/**
	 * toString() method
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int r = 2; r < numRows; r++) {
			for(int c = 0; c < numCols; c++) {
				sb.append(getCell(r, c));
			}
			sb.append("\n");
		}
		return sb.toString();
		
	
	}

}
