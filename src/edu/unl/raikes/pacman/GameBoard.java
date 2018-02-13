package edu.unl.raikes.pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class that defines the gameboard and handles all aspects of gameplay.
 * @author Stephanie Valentine
 */
public class GameBoard implements EventObservable{
	private String rawBoard;
	private ScoreBoard scoreBoard;
	private int scoreRequiredToWin;
	private boolean winState;
	private boolean lossState;
	private GameBoardCell[][] grid;
	private PacMan pacman;
	private ArrayList<Ghost> ghosts;
	private ArrayList<EventObserver> eventObservers;
	private Timer timer;

	/**
	 * Constructor that accepts a file. In the file is a representation of 
	 * the gameboard (walls, passageways, coins, the lair, etc.)
	 * @param rawBoardFile the file containing the gameboard representation
	 */
	public GameBoard(File rawBoardFile) {
		// the file and save it to the rawBoard string
		Scanner scanner;
		try {
			scanner = new Scanner(rawBoardFile);
			this.rawBoard = "";
			while (scanner.hasNextLine()) {
				this.rawBoard += "\n" + scanner.nextLine();
			}
			this.rawBoard = rawBoard.trim();
		} 
		// if there was a problem with the file, fail gracefully
		catch (FileNotFoundException e) {
			System.out.println("Gameboard file was not found.");
			e.printStackTrace();
			System.exit(0);
		}

		// initialize the list of observers
		this.eventObservers = new ArrayList<EventObserver>();
		
		// initialize the game board
		this.initialize();
	}

	/**
	 * Constructor that accepts a string representation of the gameboard (walls,
	 * passageways, coins, the lair, etc.)
	 * @param rawBoard the string containing the gameboard representation
	 */
	public GameBoard(String rawBoard) {
		this.rawBoard = rawBoard;
		this.initialize();
	}

	/**
	 * Sets up the game board data structure and all its components
	 */
	public void initialize() {
		// initialize score board
		this.scoreBoard = new ScoreBoard();
		
		// initialize member variables
		this.scoreRequiredToWin = 0;
		this.winState = false;
		this.lossState = false;
		this.ghosts = new ArrayList<Ghost>();
		
		// read through the rawBoard string and create appropriate GameBoardCell objects
		String[] lines = rawBoard.split("[\\r\\n]+");
		this.grid = new GameBoardCell[lines.length][lines[0].length()];
		for (int row = 0; row < lines.length; row++) {
			for (int col = 0; col < lines[row].length(); col++) {
				// the char in the string determines the type of cell to create
				grid[row][col] = new GameBoardCell(lines[row].charAt(col),row,col);
				// count how many coin cells there are - users win when they have eaten them all
				if (GameBoardCellImageType.getType(lines[row].charAt(col)) == GameBoardCellImageType.COIN) {
					scoreRequiredToWin++;
				}
			}
		}
		
		// TODO: Assignment 4: initialize PacMan and add him to the appropriate cell 
		// on the board note that pacman should be added to the first column of the 
		// row that is one less than the center.
		
		
		// TODO: Assignment 5: initialize ghosts and add to appropriate cells
		// note that ghosts should be added to the four center-most columns of the 
		// row that is one less than the center. The ghosts should occupy the four 
		// center columns
		
						
		// set up timer to move ghosts
		int delay = 3000;   // delay for 3 sec.
		int interval = 250;  // iterate every 25/100ths of a sec.
		if(timer!=null) {
			timer.cancel();
		}
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			public void run() {
				advanceGhosts();
			}
		};
		
		timer.scheduleAtFixedRate(timerTask, delay, interval);
	}
	
	/**
	 * Function called from the timer that animates the ghosts.
	 * For each ghost, gets the next move in the path and executes it.
	 */
	private void advanceGhosts() {
		// TODO: Assignment 5: loop through each ghost and move them forward one step
		// in their paths. (Create a path for the ghost if it doesn't have one already
		// or if their path has no more steps in it.)
		
		// after the ghosts have been moved, see if the game has been lost
		this.setIfLossState();
	}
	
	/**
	 * Moves the PacMan object in the given direction. Directions that cause PacMan
	 * to move are are KeyEvent ids for VK_LEFT, VK_UP, VK_RIGHT, & VK_DOWN arrows
	 * (int values 37-40).
	 * @param direction KeyEvent id for the arrow in the direction of desired movement
	 */
	public void movePacMan(int direction) {
		// TODO: Assignment 4: call moveAgent on pacman and the given direction and 
		// store in newCell;
		GameBoardCell newCell = null;
		
		if(newCell!=null) {
			// if there was a coin in this location, eat the coin and modify the score
			this.eatIfCoin(newCell);
			
			// determine if the move causes user to win the game
			this.setIfWinState();
			
			// determine if the move causes user to lose the game
			this.setIfLossState();
		}
	}
	
	/**
	 * Moves an agent in a specific direction
	 * @param agent the agent to move
	 * @param direction the direction to move
	 * @return the agent's new cell if the move was successful, null otherwise
	 */
	public GameBoardCell moveAgent(Agent agent, int direction) {
		// TODO: Assignment 4: If the cell in the direction of the agent's current 
		// cell isn't a wall, then move the agent in that direction.
		return null;
	}
	
	/**
	 * Eats a coin & updates the score if a coin exists in the provided cell.
	 * @param cell
	 */
	public void eatIfCoin(GameBoardCell cell) {
		if(cell.getHasCoin()) {
			cell.setHasCoin(false);
			cell.setImageType(GameBoardCellImageType.EMPTY);
			scoreBoard.addToScore(1);
		}
	}
	
	/**
	 * Tests to see if the user has eaten all the coins and thus wins the game. If
	 * the user has won, sets the winState to true.
	 */
	public void setIfWinState() {
		if (this.scoreBoard.getScore() == scoreRequiredToWin) {
			// set the win state
			this.winState = true;
			// stop the timer
			timer.cancel();
			// notify any observers that there is a change of state
			this.notifyObservers();
		}
	}
	
	/**
	 * Returns whether the user has won.
	 * @return
	 */
	public boolean getWinState() {
		return this.winState;
	}

	/**
	 * Tests to see if the user has been eaten by a ghost and thus lost the game.
	 * If the user has lost, set lossState to true.
	 */
	public void setIfLossState() {
		// TODO: Assignment 5:  replace the "null" in the right-hand side of this 
		// assignment statement with a method that gets the GameBoardCell that PacMan 
		// belongs to at the moment
		GameBoardCell pacmanCell = null;
		
		if (pacmanCell!=null && pacmanCell.getAgents().size()>1) {
			// set the loss state
			this.lossState = true;
			// stop the timer
			timer.cancel();
			// notify any observers that there is a change of state
			this.notifyObservers();
		}
	}

	/**
	 * Returns whether the user has lost the game.
	 * @return whether the user has lost
	 */
	public boolean getLossState() {
		return this.lossState;
	}

	/**
	 * Returns the number of rows in the loaded gameboard.
	 * @return the number of rows in the loaded gameboard
	 */
	public int getNumberOfRows() {
		return grid.length;
	}
	
	/**
	 * Returns the number of columns in the loaded gameboard.
	 * @return the number of columns in the loaded gameboard
	 */
	public int getNumberOfColumns() {
		return grid[0].length;
	}
	
	/**
	 * Returns the gameboard cell at the given row and column.
	 * @param row the row of the desired cell
	 * @param col the column of the desired cell
	 * @return the desired cell
	 */
	public GameBoardCell getCell(int row, int col) {
		return grid[row][col];
	}

	/**
	 * Returns the ScoreBoard associated with the gameboard
	 * @return the scoreBoard
	 */
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	/**
	 * Returns the grid of the board.
	 * @return the grid of the board
	 */
	public GameBoardCell[][] getGrid() {
		return this.grid;
	}

	@Override
	public void addEventObserver(EventObserver observer) {
		this.eventObservers.add(observer);
		
	}

	@Override
	public void removeEventObserver(EventObserver observer) {
		this.eventObservers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<this.eventObservers.size();i++) {
			this.eventObservers.get(i).respondToEvent();
		}
	}
}
