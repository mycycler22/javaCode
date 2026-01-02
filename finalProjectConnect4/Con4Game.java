package hw6Connect4;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Connect 4 Game Class
 * @author Mark Yan
 * @version 12.10.25
 * 
 * 
 */

public class Con4Game {

	private int rows;
	private int cols;
	private int[][] gameArray; // array that indicated which player's tokens
	// are in which column
	private int currentPlayer;
	private boolean endGame = false;
	private int[][] winSpot;
	private int winner = -1;
	private int player0Wins = 0;
	private int player1Wins = 0;

	/**
	 * Constructs the data model for the connect 4 game
	 * @param r - number of rows
	 * @param c - number of cols
	 */
	Con4Game(int r, int c)
	{
		rows = r;
		cols = c;
		
		gameArray = new int[r][c];
		winSpot = new int[r][c];

		//setGameArray(new int[rows][cols]);
		for(int row =0; row < rows; row++)
			for(int col =0; col < cols; col++)
				getGameArray()[row][col] = -1;  // -1 indicated no token present
		currentPlayer = 0;
	}

	/**
	 * adds a player's token into the column selected 
	 * 
	 * @param c - column selected
	 */
	public void makeMove(int c)
	{
		if(endGame) {
			return;
		}
		
        for(int row = (rows - 1); row >= 0; row--)
        	if( getGameArray()[row][c] == -1)
        	{
        		getGameArray()[row][c] = currentPlayer;
        		
        		
        		if(checkWin(row, c)) {
        			winner = currentPlayer;
        			endGame = true;
        			if(currentPlayer == 0) {
        				player0Wins++;
        			}
        			else {
        				player1Wins++;
        			}
        		}
        		else if(isBoardFull()) {
        			endGame = true;
        		}
        		else {
        			nextPlayer();
        		}
        		return;
        	}
        
	}
	
	/**
	 * 
	 * Boolean method that checks if the board is full
	 * 
	 * @return true or false
	 */
	public boolean isBoardFull() {
		for(int c = 0; c < cols; c++) {
			if(gameArray[0][c] == -1) {
				return false;
			}
		}
		return true; 
	}
	
	/**
	 * Getter method to get the game status
	 * 
	 * @return - game status
	 */
	public boolean isGameOver() {
		return endGame;
	}
	
	/**
	 * Getter for the area where the player won the game
	 * 
	 * @return - winning area
	 */
	public int[][] getWinSpot(){
		return winSpot;
	}
	
	/**
	 * Private method that checks if the game is won
	 * 
	 * @param r
	 * @param c
	 * @return if the tokens are 4 in a row/diagonal
	 */
	private boolean checkWin(int r, int c) {
		int player = gameArray[r][c];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				winSpot[i][j] = 0;
			}
		}
		return checkDirection(r, c, 1, 0, player) || checkDirection(r, c, 0, 1, player) ||
				checkDirection(r, c, 1, 1, player) || checkDirection(r, c, 1, -1, player);
		
	}
	
	/**
	 * 
	 * Checks if the placement of the token leads to a 4 in a row, vertically, or diagonally
	 * 
	 * @param r
	 * @param c
	 * @param dx
	 * @param dy
	 * @param player
	 * @return - if there is a 4 in a row, column, or diagonally
	 */
	private boolean checkDirection(int r, int c, int dx, int dy, int player) {
		int count = 1;
		
		int rr = r + dy;
		int cc = c + dx;
		
		while(inBounds(rr, cc) && gameArray[rr][cc] == player) {
			count++;
			rr += dy;
			cc += dx;
		}
		
		rr = r - dy;
		cc = c - dx;
		
		while(inBounds(rr, cc) && gameArray[rr][cc] == player) {
			count++;
			rr-=dy;
			cc-=dx;
					
		}
		
		if(count >= 4) {
			winningLine(r, c, dx, dy, player);
			return true;
		}
		return false;
		
		
	}
	
	/**
	 * Void method that marks all the board positions in a winning sequence
	 * 
	 * @param r
	 * @param c
	 * @param dx
	 * @param dy
	 * @param player
	 */
	private void winningLine(int r, int c, int dx, int dy, int player) {
		int rr = r;
		int cc = c;
		
		while(inBounds(rr, cc) && gameArray[rr][cc] == player) {
			winSpot[rr][cc] = 1;
			rr += dy;
			cc += dx;
		}
		rr = r - dy;
		cc = c - dx;
		
		while(inBounds(rr, cc) && gameArray[rr][cc] == player) {
			winSpot[rr][cc] = 1;
			rr -= dy;
			cc -= dx;
		}
	}
	
	/**
	 * Checks to see if the move is in bounds
	 * 
	 * @param r
	 * @param c
	 * @return
	 */
	private boolean inBounds(int r, int c) {
		return r >= 0 && r < rows && c >= 0 && c < cols;
	}

	/**
	 * show the token at a location (-1 for empty; 0 or 1 for players)
	 * @param r - row selected
	 * @param c - col selected
	 * @return - value at the location
	 */
	public int getToken(int r, int c)
	{
		return getGameArray()[r][c];
	}

/**
 * toggles between the players for whose turn it is
 */
	public void nextPlayer()
	{
		currentPlayer++;
		currentPlayer %= 2;
	}

	/**
	 * Getter method for getting the current player
	 * 
	 * @return the currentPlayer
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

/**
 * provide a shallow copy of the game array
 * @return game array
 */
	public int[][] getGameArray() {
		return gameArray;
	}

/**
 * store a shallow copy of the game array
 * @param gameArray
 */
	public void setGameArray(int[][] gameArray) {
		this.gameArray = gameArray;
	}
	
	/**
	 * Getter method to get the winner of the game
	 * 
	 * @return winner
	 */
	public int getWinner() {
		return winner;
	}
	
	/**
	 * Getter method to see if a winner is crowned
	 * 
	 * @return - if there is a winner
	 */
	public boolean didPlayerWin() {
		return winner != -1;
	}
	
	/**
	 * Getter method for the number of times player 0 has won
	 * 
	 * @return - number of player 0 wins
	 */
	public int getPlayer0Wins() {
		return player0Wins;
	}
	
	/**
	 * Getter method for the number of times player 1 has won
	 * 
	 * @return - number of player 1 wins
	 */
	public int getPlayer1Wins() {
		return player1Wins;
	}
	
	/**
	 * Getter method for the number of rows in the game
	 * 
	 * @return - number of rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Getter method for the number of columns in the game
	 * 
	 * @return - number of columns
	 */
	public int getCols() {
		return cols;
	}
	
	/**
	 * Void method that saves a file
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void saveGame(File file) throws Exception {
		PrintWriter output = new PrintWriter(file);
		
		output.println(rows + " " + cols);
		output.println(currentPlayer);
		output.println(endGame);
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				output.print(gameArray[r][c] + " ");
			}
			output.println();
		}
		output.close();
	}
	
	/**
	 * Void method that loads a game
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void loadGame(File file) throws Exception {
		Scanner in = new Scanner(file);
		
		rows = in.nextInt();
		cols = in.nextInt();
		currentPlayer = in.nextInt();
		endGame = in.nextBoolean();
		
		gameArray = new int[rows][cols];
		winSpot = new int[rows][cols];
		
		for (int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				gameArray[r][c] = in.nextInt();
			}
		}
		in.close();
	}
	
	/**
	 * Void method that clears the board
	 * 
	 */
	public void resetBoard() {
		endGame = false;
		winner = -1;
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				gameArray[r][c] = -1;
				winSpot[r][c] = 0;
			}
		}
		currentPlayer = 0;
	}
	
	

}
