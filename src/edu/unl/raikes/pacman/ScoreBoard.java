package edu.unl.raikes.pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * Class to keep track of the game's score and render that score to a panel.
 * @author Reid Jones
 */
@SuppressWarnings("serial")
public class ScoreBoard extends JLabel{
	private static final String FONT_NAME = Font.SANS_SERIF;
	private static final int FONT_STYLE = Font.PLAIN;
	private static final int FONT_SIZE = 14;
	private int score;
	
	/**
	 * Initializes a score of zero as well as the display panel.
	 */
	public ScoreBoard(){
		// initializes the score panel
		super("Score: ");
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		this.setForeground(Color.WHITE);
		
		// initialize the initial score
		score = 0;
	}
	
	/**
	 * Adds the specified number of points to the score
	 * @param points the points to add to the score
	 */
	public void addToScore(int points){
		this.score += points;
	}
	
	/**
	 * Gets the current score of the game
	 * @return the current score of the game
	 */
	public int getScore(){
		return score;
	}
	
	@Override
	public void paint(Graphics g){
		this.setText(String.format("Score: %d", score));
		super.paint(g);
	}
}
