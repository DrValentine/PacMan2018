package edu.unl.raikes.pacman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Actually runs and renders the PacMan Game
 * @author Stephanie Valentine
 */
public class GameRunner implements KeyListener, EventObserver{
	private final String boardFileName = "./board.txt";
	private GameBoard gameBoard;
	private ScoreBoard scoreBoard;
	private GamePane gamePane;
	private JFrame frame;

	/**
	 * Default constructor that initializes a game of PacMan and the views
	 * associated with it.
	 */
	public GameRunner() {
		// initialize gameboard
		this.gameBoard = new GameBoard(new File(boardFileName));
		
		// add this as an event observer so it can be notified of state changes
		this.gameBoard.addEventObserver(this);
		
		
		// initialize the view
		this.initialize();
	}
	
	/**
	 * Handles the setup of the view components and the display frame.
	 */
	private void initialize() {
		// dispose of an old frame if one already exists (when starting a new game)
		if(frame!=null) {
			frame.dispose();
		}
		
		// set up the frame
		frame = new JFrame("PacMan");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.BLACK);
		
		// initialize the game pane
		gamePane = new GamePane();
		int gameboardRows = gameBoard.getNumberOfRows();
		int gameboardCols = gameBoard.getNumberOfColumns();
		gamePane.setGridDimensions(gameboardRows, gameboardCols);
		for (int row = 0; row < gameboardRows; row++) {
			for (int col = 0; col < gameboardCols; col++) {
				gamePane.add(gameBoard.getCell(row, col));
			}
		}

		// set up the necessary items for listening for & responding to keystrokes
		frame.addKeyListener(this);
		frame.setFocusable(true);
		
		// initialize score board
		this.scoreBoard = gameBoard.getScoreBoard();

		// add the various panels/components to the frame
		frame.add(gamePane, BorderLayout.NORTH);
		frame.add(scoreBoard, BorderLayout.SOUTH);
		
		// finish setting up the frame. 
		frame.pack();
		frame.setLocationRelativeTo(null);

		// make it visible and start the timer
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
				gameBoard.startAnimationTimer();
			}
		});
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		// which key was pressed? 
		int keyCode = keyEvent.getKeyCode();
		
		// if the key pressed was the escape button, exit the program.
		if(keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		// move pac man in that direction
		gameBoard.movePacMan(keyCode);
		
		// paint in case there are any view changes
		frame.repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		// do nothing
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		// do nothing
	}

	@Override
	public void respondToEvent() {
		String message = null;
		
		// check with the game board for game over states
		if(gameBoard.getWinState()) {
			message = "YOU WON!!!!! WANT TO PLAY AGAIN?";
		}
		else if (gameBoard.getLossState()) {
			message = "Sorry, you lost. Want to play again?";
		}
		
		if (message != null) {
			// display a popup informing that the game is over, and asking if 
			// the user wants to play again.
			Object[] options = {"Yes, please!",
			                    "No, thanks!"};
			int choice = JOptionPane.showOptionDialog(frame.getContentPane(),
			    message,
			    boardFileName, JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options, 
			    options[0]);
			
			// if user doesn't want to play again
			if (choice == 1) {
				System.exit(0);
			}
			// if user does want to play again
			else {
				gameBoard.initialize();
				this.initialize();
			}
		}
	}

	/**
	 * Runs the program
	 * @param args This program does not accept any args, so this array is empty.
	 */
	public static void main(String[] args) {
		new GameRunner();
	}

}
